package com.bovink.androidlearning;

import android.view.View;
import android.widget.Toast;

/**
 * com.bovink.androidlearning
 *
 * @author bovink
 * @since 2018/3/3
 */

public class EventHandler {
    public void onClickHappen(View view) {

        Toast.makeText(view.getContext(),"hh",Toast.LENGTH_SHORT).show();
    }
}
