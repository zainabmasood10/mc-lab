package com.example.finalexam191184;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.google.android.material.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {
    ImageView ball_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        ball_img=findViewById(R.id.img_ball);
        img();

    }
         new Handler().postDelayed(() -> {
        Intent i = new Intent(Splash.this,Signup.class);
        startActivity(i);
    }, 6000);
}
    public void img(){
    Animation img1=AnimationUtils.LoadAnimation(this,R.anim.animation);
    ball_img.startAnimation(img1);
    }
}