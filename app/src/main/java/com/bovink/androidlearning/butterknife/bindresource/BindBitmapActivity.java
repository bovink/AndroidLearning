package com.bovink.androidlearning.butterknife.bindresource;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bovink.androidlearning.R;

import butterknife.BindBitmap;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * com.bovink.androidlearning.butterknife
 *
 * @author bovink
 * @since 2018/1/29
 */

public class BindBitmapActivity extends AppCompatActivity {

    @BindBitmap(R.drawable.all)
    Bitmap bitmap;
    @BindView(R.id.iv_test)
    ImageView testImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bindresource_bitmap);
        ButterKnife.bind(this);

        testBindBitmap();
    }

    private void testBindBitmap() {

        testImageView.setImageBitmap(bitmap);
    }
}
