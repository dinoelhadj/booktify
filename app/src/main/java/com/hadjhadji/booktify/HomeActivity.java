package com.hadjhadji.booktify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {
    CircleImageView homeActivity_profileIv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homeActivity_profileIv= findViewById(R.id.homeActivity_profileIv);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setNewAvatar();

    }

    public void setNewAvatar(){
        String url = "https://avatars.dicebear.com/api/jdenticon/"
                + Utils.randomString()
                + ".png?background=blue";
        //+ Utils.randomColor();
        Utils.fetchPng(homeActivity_profileIv,url);
    }
}