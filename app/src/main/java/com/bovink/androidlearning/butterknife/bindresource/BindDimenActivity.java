package com.bovink.androidlearning.butterknife.bindresource;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bovink.androidlearning.R;

import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * com.bovink.androidlearning.butterknife
 *
 * @author bovink
 * @since 2018/1/29
 */

public class BindDimenActivity extends AppCompatActivity {

    @BindDimen(R.dimen.test)
    int textSize;
    @BindDimen(R.dimen.exact_amount)
    float exact_amount;
    @BindView(R.id.tv_test)
    TextView testTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bindresource_dimen);
        ButterKnife.bind(this);

        System.out.println("exact_amount = " + exact_amount);
        System.out.println("textSize = " + textSize);
        testBindDimen();
    }

    private void testBindDimen() {
        testTextView.setTextSize(textSize);
    }
}
