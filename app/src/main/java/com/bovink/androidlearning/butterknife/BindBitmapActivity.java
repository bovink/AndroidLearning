package com.bovink.androidlearning.butterknife;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bovink.androidlearning.R;

import butterknife.BindBitmap;
import butterknife.ButterKnife;

/**
 * com.bovink.androidlearning.butterknife
 *
 * @author bovink
 * @since 2018/1/29
 */

public class BindBitmapActivity extends AppCompatActivity {

    @BindBitmap(R.mipmap.ic_launcher_round)
    Bitmap bitmap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
        ButterKnife.bind(this);
    }

    private void testBindBitmap() {

        ImageView imageView = findViewById(R.id.iv_bitmap);
        imageView.setImageBitmap(bitmap);
    }
}
