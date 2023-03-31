package com.radustan.jocuriinteractive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {
    int widthbtn;
    ImageView norcentru;
    ImageView norjos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnInvFormeGeometrice = findViewById(R.id.btnInvFormeGeometrice);
        Button btnFormeGeometrice = findViewById(R.id.btnFormeGeometrice);
        Button btnBanii = findViewById(R.id.btnBanii);
        Button btnVBcorect = findViewById(R.id.brnVBcorect);
        Button btnHarta = findViewById(R.id.btnHarta);
        ImageView norcentru = findViewById(R.id.norcentru);
        ImageView norjos;
        norjos = (ImageView) findViewById(R.id.norjos);




        btnFormeGeometrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFormeGeometrice();
            }
        });

        btnInvFormeGeometrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openinvFormeGeometrice();
            }
        });
        btnBanii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openbani();
            }
        });


        ///fac butonul sa isi schimbe dimensiunile dupa rezolutia device-ului
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int heightbtn = displayMetrics.heightPixels;
        widthbtn = displayMetrics.widthPixels;
        btnInvFormeGeometrice.getLayoutParams().width=widthbtn / (25/10);
        btnInvFormeGeometrice.getLayoutParams().height=heightbtn / 20;

        btnFormeGeometrice.getLayoutParams().width=widthbtn / (25/10);
        btnFormeGeometrice.getLayoutParams().height=heightbtn / 20;

        btnBanii.getLayoutParams().width=widthbtn / (25/10);
        btnBanii.getLayoutParams().height=heightbtn / 20;

        btnVBcorect.getLayoutParams().width=widthbtn / (25/10);
        btnVBcorect.getLayoutParams().height=heightbtn / 20;

        btnHarta.getLayoutParams().width=widthbtn / (25/10);
        btnHarta.getLayoutParams().height=heightbtn / 20;


        mHandler.postDelayed(mRunnable, 100);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Resume the Runnable when the activity is resumed
        mHandler.postDelayed(mRunnable, 100);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Stop the Runnable when the activity is paused
        mHandler.removeCallbacks(mRunnable);
    }

    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            int orientation = getResources().getConfiguration().orientation;

            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                norcentru.setTranslationX(widthbtn / 2);
                norcentru.setTranslationY(widthbtn / 6);
                norjos.setTranslationY(-widthbtn / 3);
                norjos.setTranslationX(-widthbtn / 2);
            } else {
                norjos = findViewById(R.id.norjos);
                norcentru = findViewById(R.id.norcentru);
                norcentru.setVisibility(View.VISIBLE);
                norcentru.setTranslationX(widthbtn / 10);
                norjos.setTranslationY(widthbtn / 2);
                norjos.setTranslationX(-widthbtn / 5);
            }
            mHandler.postDelayed(this, 100); // Run this Runnable again after 100ms
        }
    };


    public void openFormeGeometrice() {
        Intent intent = new Intent(this, activity_quiz1.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void openbani() {
        Intent intent = new Intent(this, activity_quiz3.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void openinvFormeGeometrice() {
        Intent intent = new Intent(this, invFormeleGeometrice.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}


//TODO: https://www.youtube.com/watch?v=4ZxsvXMeSkM&ab_channel=How%27sTheCode