package com.bovink.androidlearning;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.bovink.androidlearning.socket.SocketManager;
import com.bovink.androidlearning.socket.bean.SocketUser;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * @author fox
 * @since 2018/04/16
 */

public class MyService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startForeground(1001, new Notification());
        Intent innerIntent = new Intent(this, MyInnerService.class);
        startService(innerIntent);
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static class MyInnerService extends Service {

        private CompositeDisposable disposable;
        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            startForeground(1001, new Notification());
            stopForeground(true);
            stopSelf();

            disposable = new CompositeDisposable();
            disposable.add(Completable.complete()
                    .observeOn(Schedulers.io())
                    .subscribeWith(new DisposableCompletableObserver() {
                        @Override
                        public void onComplete() {

                            List<String> groupIds = new ArrayList<>();
                            groupIds.add("yunduo_4002");
                            groupIds.add("yunduo_single");

                            SocketUser user = new SocketUser();
                            user.setAppId("yunduo");
                            user.setGroupIds(groupIds);
                            user.setUserName("测试用学生2");
                            user.setUserUid("4012");

                            SocketManager socketManager = SocketManager.newInstance();
                            socketManager.setSocketUser(user);
                            socketManager.registerUser(user);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }
                    }));

            return super.onStartCommand(intent, flags, startId);
        }

        @Nullable
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }
    }
}
