package com.hadjhadji.booktify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegisterActivity extends AppCompatActivity {
    CircleImageView profile_image;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        context = this;
        profile_image = findViewById(R.id.profile_image);

        setNewAvatar();

        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNewAvatar();
            }
        });



    }
    public void returnToHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void proceedRegistration(View view) {

    }

    public void setNewAvatar(){
        String url = "https://avatars.dicebear.com/api/jdenticon/"
                + Utils.randomString()
                + ".png?background="
                + Utils.randomColor();
        Utils.fetchPng(profile_image,url);
    }


}