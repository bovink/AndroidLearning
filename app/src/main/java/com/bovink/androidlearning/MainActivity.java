package com.bovink.androidlearning;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
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

        Uri uri;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            uri = Uri.fromFile(new File(path));
        } else {
            // 从安卓版本24开始，需要通过FileProvider才能获取文件的Uri
            uri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID, new File(path));
        }
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        startActivity(intent);

    }
}
