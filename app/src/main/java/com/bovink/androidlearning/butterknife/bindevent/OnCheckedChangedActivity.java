package com.bovink.androidlearning.butterknife.bindevent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.Toast;

import com.bovink.androidlearning.R;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

/**
 * com.bovink.androidlearning.butterknife.bindevent
 *
 * @author bovink
 * @since 2018/2/3
 */

public class OnCheckedChangedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bindevent_oncheckedchanged);
        ButterKnife.bind(this);
    }

    @OnCheckedChanged(R.id.rb_test1)
    void checkRadio1(RadioButton rb, boolean checked) {

        if (checked) {

            Toast.makeText(this, "1 checked", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this, "1 not checked", Toast.LENGTH_SHORT).show();
        }

    }

    @OnCheckedChanged(R.id.rb_test2)
    void checkRadio2(RadioButton rb, boolean checked) {

        if (checked) {

            Toast.makeText(this, "2 checked", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this, "2 not checked", Toast.LENGTH_SHORT).show();
        }

    }
}
