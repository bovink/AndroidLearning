package com.bovink.androidlearning.socket;

import com.bovink.androidlearning.HttpUtils;
import com.bovink.androidlearning.socket.bean.ReceiveSocketMsg;
import com.bovink.androidlearning.socket.bean.SocketUser;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * 接收消息的Socket
 *
 * @author Retina975
 * @since 2017/07/15
 */

public class SocketManager {
    private final static String TAG = "SocketManager";

    private CompositeDisposable disposable = new CompositeDisposable();
    private boolean tryToConnect = false;
    private int urgentSuccess = 0;
    private Gson gson = new Gson();
    private List<OnMessageReceivedListener> onMessageReceivedListeners = new ArrayList<>();
    private SocketUser socketUser;
    private OnSocketConnectListener onSocketConnectListener;
    /**
     * socket
     */
    private Socket socket;
    /**
     * 单例
     */
    private static volatile SocketManager mInstance = null;

    private SocketManager() {
        connect(HttpUtils.SocketHost, HttpUtils.SocketPort);
        heartbeat();
    }

    /**
     * 生成单例
     */
    public static SocketManager newInstance() {
        if (mInstance == null) {
            synchronized (SocketManager.class) {
                if (mInstance == null) {
                    mInstance = new SocketManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 连接Socket服务器
     */
    private void connect(String host, int port) {
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(host, port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 断开与Socket服务器的连接
     */
    public void close() {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            socket = null;
            urgentSuccess = 0;
            tryToConnect = false;
        }
        disposable.clear();
        mInstance = null;
    }

    public void setSocketUser(SocketUser socketUser) {
        this.socketUser = socketUser;
    }

    public SocketUser getSocketUser() {
        return socketUser;
    }

    /**
     * Socket发送心跳
     */
    public void heartbeat() {

        disposable.add(Observable.interval(5000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        try {
                            if (socket != null) {
                                System.out.println("发送心跳包");
                                if (tryToConnect) {
                                    urgentSuccess++;
                                }
                                socket.sendUrgentData(0xFF);
                            } else {
                                System.out.println("试图重连");
                                tryToConnect = true;
                                connect(HttpUtils.SocketHost, HttpUtils.SocketPort);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            socket.close();
                            socket = null;
                            urgentSuccess = 0;
                            tryToConnect = false;
                            System.out.println("连接已断开");
                        }

                        // 重新连接Socket并发送三次验证数据都成功后执行
                        if (tryToConnect && urgentSuccess == 3) {

                            System.out.println("重连成功");
                            tryToConnect = false;
                            urgentSuccess = 0;
                            if (onSocketConnectListener != null) {
                                onSocketConnectListener.onSocketConnect();
                            }
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {

                        throwable.printStackTrace();
                    }
                }));
    }

    public void registerUser(SocketUser socketUser) {

        if (socket != null && socket.isConnected()) {
            sendMessage(gson.toJson(socketUser) + "\n");
            receiveMessage(socket);
        }
    }

    /**
     * 往Socket服务器发送消息
     */
    public void sendMessage(String msg) {
        disposable.add(Single.just(msg)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribeWith(new DisposableSingleObserver<String>() {
                    @Override
                    public void onSuccess(@NonNull String msg) {

                        try {
                            if (socket == null) {
                                return;
                            }
                            OutputStream outputStream = socket.getOutputStream();
                            outputStream.write(msg.getBytes());
                            outputStream.flush();
                            System.out.println("发送msg = " + msg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                        e.printStackTrace();
                    }
                }));
    }

    /**
     * 接收Socket发送的消息
     */
    private void receiveMessage(Socket socket) {

        disposable.add(Single.just(socket)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribeWith(new DisposableSingleObserver<Socket>() {
                    @Override
                    public void onSuccess(@NonNull Socket socket) {

                        try {
                            InputStream inputStream = socket.getInputStream();
                            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                            String msg;
                            while ((msg = bufferedReader.readLine()) != null) {
                                msg = URLDecoder.decode(msg);
                                System.out.println("接收msg = " + msg);
                                ReceiveSocketMsg receiveSocketMsg = gson.fromJson(msg, ReceiveSocketMsg.class);
                                for (int i = 0; i < onMessageReceivedListeners.size(); i++) {
                                    onMessageReceivedListeners.get(i).onMessageReceived(receiveSocketMsg);
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                        e.printStackTrace();
                    }
                }));
    }

    /**
     * 添加消息返回监听
     *
     * @param onMessageReceivedListener
     */
    public void addOnMessageReceivedListener(OnMessageReceivedListener onMessageReceivedListener) {
        onMessageReceivedListeners.add(onMessageReceivedListener);
    }

    /**
     * 移除消息返回监听
     *
     * @param onMessageReceivedListener
     */
    public void removeOnMessageReceivedListener(OnMessageReceivedListener onMessageReceivedListener) {
        onMessageReceivedListeners.remove(onMessageReceivedListener);
    }

    /**
     * 判断是否有存在该消息返回监听
     *
     * @param onMessageReceivedListener
     * @return
     */
    public boolean hasOnMessageReceivedListener(OnMessageReceivedListener onMessageReceivedListener) {
        return onMessageReceivedListeners.contains(onMessageReceivedListener);
    }

    /**
     * 消息返回监听
     */
    public interface OnMessageReceivedListener {
        void onMessageReceived(ReceiveSocketMsg msg);
    }

    public void setOnSocketConnectListener(OnSocketConnectListener onSocketConnectListener) {
        this.onSocketConnectListener = onSocketConnectListener;
    }

    public interface OnSocketConnectListener {
        void onSocketConnect();
    }
}
