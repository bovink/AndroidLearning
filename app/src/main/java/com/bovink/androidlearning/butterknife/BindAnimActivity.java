package com.bovink.androidlearning.butterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.widget.TextView;

import com.bovink.androidlearning.R;

import butterknife.BindAnim;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * com.bovink.androidlearning.butterknife
 *
 * @author bovink
 * @since 2018/1/29
 */

public class BindAnimActivity extends AppCompatActivity {

    @BindAnim(R.anim.anim_fade_in)
    Animation animation;

    @BindView(R.id.tv_text1)
    TextView helloTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
        ButterKnife.bind(this);

        testBindAnim();
    }

    private void testBindAnim() {

        helloTextView.startAnimation(animation);
    }

}
