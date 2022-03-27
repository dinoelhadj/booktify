package com.hadjhadji.booktify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.View;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    CircleImageView mainActivity_mainIv;
    Handler handler = new Handler();
    Runnable runnable;
    int delay = 750;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        mainActivity_mainIv = findViewById(R.id.mainActivity_mainIv);
        mainActivity_mainIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNewAvatar();
            }
        });

    }

    @Override
    protected void onPause() {
        handler.removeCallbacks(runnable); //stop handler when activity not visible
        super.onPause();
    }

    @Override
    protected void onResume() {
        setNewAvatar();

        handler.postDelayed( runnable = new Runnable() {
            public void run() {
                //do something
                setNewAvatar();
                handler.postDelayed(runnable, delay);
            }
        }, delay);

        super.onResume();
    }

    public void goToLogin(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void goToRegisterActivity(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
    public void setNewAvatar(){
        String url = "https://avatars.dicebear.com/api/jdenticon/"
                + Utils.randomString()
                + ".png?background="
                + Utils.randomColor();
        String url2 = "https://avatars.dicebear.com/api/jdenticon/"
                + Utils.randomString()
                + ".png";
        Utils.fetchPng(mainActivity_mainIv,url);
    }
}