package com.bovink.androidlearning;

import android.os.Bundle;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,
                "user").build();
        new Thread() {
            @Override
            public void run() {
                super.run();
                List<User> users = db.userDao().getALl();
                int id = 0;
                for (User user : users) {
                    System.out.println("==============================");
                    System.out.println("user.uid = " + user.uid);
                    System.out.println("user.firstName = " + user.firstName);
                    System.out.println("user.lastName = " + user.lastName);
                }
                User user = new User();
                user.firstName = "lei";
                user.lastName = "li";
                users.add(user);
                db.userDao().insertAll(users);
            }
        }.start();
    }
}
