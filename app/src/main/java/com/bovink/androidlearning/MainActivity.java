package com.bovink.androidlearning;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn_install);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                installApk();

            }
        });
    }

    private void installApk() {
        String path = Environment.getExternalStorageDirectory() + "/" + "bovink/apk/app-debug.apk";
        System.out.println("path = " + path);

        //apk文件的本地路径
        File apkfile = new File(path);
        //会根据用户的数据类型打开android系统相应的Activity。
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        Uri contentUri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID, apkfile);
        intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
        //设置intent的数据类型是应用程序application
//        intent.setDataAndType(Uri.parse("file://" + apkfile.toString()), "application/vnd.android.package-archive");
        //为这个新apk开启一个新的activity栈
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //开始安装
        startActivity(intent);
        //关闭旧版本的应用程序的进程
//        android.os.Process.killProcess(android.os.Process.myPid());

    }
}
