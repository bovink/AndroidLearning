package com.bovink.androidlearning.first;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bovink.androidlearning.R;
import com.bovink.androidlearning.second.SecondActivity;

/**
 * @author fox
 * @since 2018/04/08
 */

public class SecondFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_second, container, false);
        Button button = root.findViewById(R.id.btn_forward);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SecondActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }
}
