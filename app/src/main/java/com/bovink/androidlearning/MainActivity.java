package com.bovink.androidlearning;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint("StaticFieldLeak")
        AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    String WCPay_url = "http://10.0.2.2:8080/city/class.xml";
                    URL url = new URL(WCPay_url);
                    HttpURLConnection httpURLConnection =
                            (HttpURLConnection) url.openConnection();
                    httpURLConnection.setConnectTimeout(3000);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestProperty("Content-Type",
                            "application/x-www-form-urlencoded");
                    int response = httpURLConnection.getResponseCode();

                    if (response == HttpURLConnection.HTTP_OK) {
                        InputStream inputStream = httpURLConnection.getInputStream();

                        XmlPullParser parser = Xml.newPullParser();
                        try {
                            parser.setInput(inputStream, "utf-8");
                            int event = parser.getEventType();
                            while (event != XmlPullParser.END_DOCUMENT) {
                                switch (event) {
                                    case XmlPullParser.START_TAG:
                                        if (parser.getName().equals("class")) {
                                            System.out.println("=====班级=====");
                                            System.out.println(parser.getAttributeValue(0));
                                            System.out.println(parser.getAttributeValue(1));

                                        } else if (parser.getName().equals("teacher")) {
                                            System.out.println("=====老师=====");
                                            System.out.println(parser.getAttributeValue(0));
                                            System.out.println(parser.nextText());

                                        } else if (parser.getName().equals("student")) {
                                            System.out.println("=====学生=====");
                                            System.out.println(parser.getAttributeValue(0));
                                            System.out.println(parser.getAttributeValue(1));
                                            System.out.println(parser.nextText());
                                        }
                                        break;
                                }
                                event = parser.next();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (XmlPullParserException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        asyncTask.execute();
    }
}
