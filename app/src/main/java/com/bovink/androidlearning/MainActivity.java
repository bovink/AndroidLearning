package com.bovink.androidlearning;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String videoPath = Environment.getExternalStorageDirectory() + File.separator + "AudioRecord/video.mp4";
        String audioPath = Environment.getExternalStorageDirectory() + File.separator + "AudioRecord/audio.mp3";
        String dstPath = Environment.getExternalStorageDirectory() + File.separator + "AudioRecord/target.mp4";
        Compounder compounder = Compounder.createCompounder(videoPath, audioPath, dstPath);
        compounder.start();
    }
}
