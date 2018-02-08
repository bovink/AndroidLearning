package com.bovink.androidlearning.butterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.Toast;

import com.bovink.androidlearning.R;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * @author fox
 * @since 2018/02/08
 */

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_test)
    void clickBtn() {

        System.out.println("TestActivity.clickBtn");
    }

    @OnCheckedChanged(R.id.tb_test)
    void onChecked(boolean checked) {

        Toast.makeText(this, checked ? "checked" : "not checked", Toast.LENGTH_SHORT).show();
    }

    @OnCheckedChanged({R.id.rb_test1, R.id.rb_test2})
    void checkRadio(RadioButton rb, boolean checked) {

        System.out.println("TestActivity.checkRadio");
        switch (rb.getId()) {
            case R.id.rb_test1:

                Toast.makeText(this, "rb1 checked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_test2:

                Toast.makeText(this, "rb2 checked", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }

    @OnCheckedChanged(R.id.cb_test)
    void checkbox(boolean checked) {

        Toast.makeText(this, checked ? "选中复选框" : "取消复选框", Toast.LENGTH_SHORT).show();
    }

    @OnCheckedChanged(R.id.switch_test)
    void switchOnCheck(boolean checked) {

        Toast.makeText(this, checked ? "切换选中" : "切换未选中", Toast.LENGTH_SHORT).show();
    }
}
