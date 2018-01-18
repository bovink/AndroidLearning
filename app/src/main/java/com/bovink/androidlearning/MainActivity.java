package com.bovink.androidlearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.TextView;

import butterknife.BindAnim;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindAnim(R.anim.anim_fade_in)
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        TextView textView = (TextView) findViewById(R.id.tv_hello);

        textView.startAnimation(animation);
    }
}
