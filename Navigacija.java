package com.metropolitan.cs330_pz_4244;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;

public class Navigacija extends AppCompatActivity {

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lokacija);
    }

    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    public void onClickShowMap(View view) {
        Intent i = new
                Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/maps/place/Vin%C4%8Da+-+Belo+Brdo/@44.7620091,20.6210482,17z/data=!3m1!4b1!4m5!3m4!1s0x475a77eef7c0be21:0xf9b1ea01de473d8b!8m2!3d44.7620091!4d20.6232369"));

        startActivity(i);
    }
    public void onClickShowMap1(View view) {
        Intent i = new
                Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://goo.gl/maps/8hCeVBsF9GTs9ZxU7"));

        startActivity(i);
    }

    public void onClickShowMap2(View view) {
        Intent i = new
                Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://goo.gl/maps/VAxxniie3ASA5guJA"));

        startActivity(i);
    }
    public void onClickShowMap3(View view) {
        Intent i = new
                Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://goo.gl/maps/F3m7h7wn8kq7GXjg6"));

        startActivity(i);
    }





}
