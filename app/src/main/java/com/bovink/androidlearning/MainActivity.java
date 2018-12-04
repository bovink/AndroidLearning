package com.bovink.androidlearning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int flag;

    private static int SYSTEM_UI_TYPE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SYSTEM_UI_TYPE = 4;
        flag = generateThemeFlag();

        View view = findViewById(R.id.fl_main);
        view.setSystemUiVisibility(flag);

        Button btn = findViewById(R.id.btn_click);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setSystemUiVisibility(flag);
            }
        });
    }

    int generateThemeFlag() {

        int flag;
        switch (SYSTEM_UI_TYPE) {

            case 0:
                flag = View.SYSTEM_UI_FLAG_FULLSCREEN;
                break;
            case 1:
                flag = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
                break;
            case 2:
                flag = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                break;
            case 3:
                flag = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
                break;
            case 4:
                flag = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
                break;
            case 5:
                flag = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE;
                break;
            case 6:
                flag = View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
                break;
            case 7:
                flag = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
                break;

            default:
                flag = View.SYSTEM_UI_FLAG_LOW_PROFILE;
                break;
        }


        return flag;
    }
}
