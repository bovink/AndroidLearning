package com.bovink.androidlearning.butterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bovink.androidlearning.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnLongClick;

/**
 * @author fox
 * @since 2018/02/08
 */

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.et_test1)
    EditText testEditText1;
    @BindView(R.id.et_test2)
    EditText testEditText2;

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

    @OnClick(R.id.tv_test1)
    void clickText1(TextView view) {

        System.out.println("TestActivity.clickText1");
        testEditText1.requestFocus();

    }

    @OnClick(R.id.tv_test2)
    void clickText2(TextView view) {

        System.out.println("TestActivity.clickText2");
        testEditText2.requestFocus();
    }

    @OnLongClick({R.id.tv_test1,R.id.tv_test2})
    boolean longClickText1(View view) {

        if (view.getId() == R.id.tv_test1) {

            System.out.println("TestActivity.longClickText1");
            return true;
        }else {

            System.out.println("TestActivity.longClickText2");
            return true;
        }
    }

    @OnFocusChange({R.id.et_test1, R.id.et_test2})
    void TextOnFocusChange(TextView textView, boolean focus) {

        switch (textView.getId()) {
            case R.id.et_test1:

                Toast.makeText(this, focus ? "test1 focused" : "test1 not focused", Toast.LENGTH_SHORT).show();
                break;
            case R.id.et_test2:
                Toast.makeText(this, focus ? "test2 focused" : "test2 not focused", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
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
