package com.bovink.androidlearning;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindAnim;
import butterknife.BindArray;
import butterknife.BindBitmap;
import butterknife.BindBool;
import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindDrawable;
import butterknife.BindFloat;
import butterknife.BindInt;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

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

    @BindView(R.id.tv_hello)
    TextView helloTextView;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        testBindArray();
        testBindAnim();
        testBindBitmap();
        testBindColor();
        testBindBool();
        testBindDimen();
        testBindDrawable();
        testBindFloat();
        testBindInt();
        testBindString();
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
