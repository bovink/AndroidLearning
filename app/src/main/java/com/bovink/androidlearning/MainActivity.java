package com.bovink.androidlearning;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn_download);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                @SuppressLint("StaticFieldLeak")
                AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {

                    @Override
                    protected Void doInBackground(Void... params) {
                        try {
                            String WCPay_url = "http://10.0.2.2:8080/city/class.xml";
                            URL url = new URL(WCPay_url);
//                            URLConnection urlConnection = url.openConnection();
                            HttpURLConnection httpURLConnection =
                                    (HttpURLConnection) url.openConnection();
                            httpURLConnection.setConnectTimeout(3000);
                            httpURLConnection.setDoInput(true);
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setRequestMethod("GET");
                            httpURLConnection.setUseCaches(false);
                            httpURLConnection.setRequestProperty("Content-Type",
                                    "application/x-www-form-urlencoded");

                            int response = httpURLConnection.getResponseCode(); //鑾峰緱鏈嶅姟鍣ㄧ殑鍝嶅簲鐮�

                            if (response == HttpURLConnection.HTTP_OK) {
                                InputStream inputStream = httpURLConnection.getInputStream();
                                int fileLength = httpURLConnection.getContentLength();

                                int byteSum = 0; //当前下载的数据量
                                int byteRead = 0;//记录读取的结果，如果为-1，则代表读取完毕
                                FileOutputStream fileOutputStream = createFileOutputStream();
                                byte[] buffer = new byte[1024];
                                while ((byteRead = inputStream.read(buffer)) != -1) {
                                    byteSum += byteRead;
                                    fileOutputStream.write(buffer, 0, byteRead);
                                    int currentProgress = byteSum * 100 / fileLength;
                                    System.out.println("currentProgress = " + currentProgress);

                                }
                                inputStream.close();
                                fileOutputStream.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                };
                asyncTask.execute();
            }
        });

    }

    private FileOutputStream createFileOutputStream() throws IOException {
        FileOutputStream outputStream;

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File rootFile = getExternalFilesDir(null);
            assert rootFile != null;
            String filePath = rootFile.getAbsolutePath() + "/" + "class.xml";
            File file = new File(filePath);
            file.createNewFile();
            System.out.println("filePath = " + filePath);
            outputStream = new FileOutputStream(file);
            Log.e("no", "no");
        } else {
            outputStream = openFileOutput("class.xml", Context.MODE_WORLD_READABLE);
            Log.e("yes", "yes");
        }
        return outputStream;
    }
}
