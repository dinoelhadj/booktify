package com.hadjhadji.booktify;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import java.net.URL;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Utils {

    public static String randomString(){
        String toReturn = "";
        String allowedChars = "azertyuiopqsdfghjklmwxcvbnAZERTYUIOPQSDFGHJKLMWXCVBN0123456789";
        for (int i = 0; i < 10; i++) {
            toReturn = toReturn.concat(""+allowedChars.charAt((int) Math.round(Math.random() * 60)));
        }
        Log.e("randomString()",toReturn);
        return toReturn;
    }

    public static String randomColor(){
        String[] colors = {
                "red",
                "pink",
                "orange",
                "yellow",
                "purple",
                "green",
                "blue",
                "brown"};
        return colors[(int)Math.round(Math.random()*7)];
    }

    public static void fetchPng(CircleImageView profile_image, String url) {
        try {
            URL newurl = new URL(url);
            Bitmap bitmap = BitmapFactory.decodeStream(newurl.openConnection().getInputStream());
            profile_image.setImageBitmap(bitmap);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void setNewAvatar(CircleImageView imageView){
        String url = "https://avatars.dicebear.com/api/jdenticon/"
                + Utils.randomString()
                + ".png?background="
                + Utils.randomColor();
        Utils.fetchPng(imageView,url);
    }
}
