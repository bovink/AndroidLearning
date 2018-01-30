package com.bovink.androidlearning.butterknife;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bovink.androidlearning.R;

import butterknife.BindAnim;
import butterknife.BindArray;
import butterknife.BindBitmap;
import butterknife.BindBool;
import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindDrawable;
import butterknife.BindFloat;
import butterknife.BindFont;
import butterknife.BindInt;
import butterknife.BindString;
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

    @BindArray(R.array.week)
    String[] week;

    @BindBitmap(R.mipmap.ic_launcher_round)
    Bitmap bitmap;

    @BindBool(R.bool.is_right)
    boolean isRight;

    @BindColor(R.color.colorAccent)
    int accentColor;


    @BindDrawable(R.mipmap.ic_launcher)
    Drawable iconDrawable;

    @BindDimen(R.dimen.test)
    int textSize;

    @BindFloat(R.dimen.whatever)
    float whatever;
    @BindInt(R.integer.time)
    int time;

    @BindString(R.string.app_name)
    String appName;

    @BindFont(R.font.pianpianti)
    Typeface typeface;

    @BindView(R.id.tv_hello)
    TextView helloTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
        ButterKnife.bind(this);
    }


    private void testBindFont() {
        helloTextView.setTypeface(typeface);
    }

    private void testBindString() {
        helloTextView.setText(appName);
    }

    private void testBindInt() {

        helloTextView.setTextSize(time);
    }

    private void testBindFloat() {

        helloTextView.setText(String.valueOf(whatever));
    }

    private void testBindDrawable() {
        helloTextView.setBackground(iconDrawable);
    }

    private void testBindDimen() {
        helloTextView.setTextSize(textSize);
    }

    private void testBindColor() {
        helloTextView.setTextColor(accentColor);
    }

    private void testBindBool() {
        if (isRight) {
            System.out.println("MainActivity.testBindBool");
        }
    }

    private void testBindAnim() {

        helloTextView.startAnimation(animation);
    }

    private void testBindArray() {

        for (String day : week) {
            System.out.println("day = " + day);
        }
    }

    private void testBindBitmap() {

        ImageView imageView = findViewById(R.id.iv_bitmap);
        imageView.setImageBitmap(bitmap);
    }
}
