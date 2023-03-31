package com.radustan.jocuriinteractive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnJocuri;
    private Button btnDespreNoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView llanim = (ImageView) findViewById(R.id.llanim);
        ImageView imageNor2 = (ImageView) findViewById(R.id.imageNor2);
        ImageView imageNor3 = (ImageView) findViewById(R.id.imageNor3);
        LinearLayoutCompat myLinearLayout = findViewById(R.id.linearLayout1);


        Animation shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        Animation shakeAnimation2 = AnimationUtils.loadAnimation(this, R.anim.shake2);
        Animation shakeAnimation3 = AnimationUtils.loadAnimation(this, R.anim.shake3);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                llanim.setVisibility(View.VISIBLE);
                llanim.startAnimation(shakeAnimation); //animeaza norul STANGA CENTRU

                imageNor2.setVisibility(View.VISIBLE);
                imageNor2.startAnimation(shakeAnimation2); //animeaza norul DREAPTA CENTRU

                imageNor3.setVisibility(View.VISIBLE);
                imageNor3.startAnimation(shakeAnimation3); //animeaza norul SUS DREAPTA

                AlphaAnimation fadeIn = new AlphaAnimation(0f, 1f);
                fadeIn.setDuration(5000); // 5 seconds
                myLinearLayout.startAnimation(fadeIn);
            }
        }, 10); // Delay for 10 miliseconds

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                llanim.setVisibility(View.GONE);
                imageNor2.setVisibility(View.GONE);
                imageNor3.setVisibility(View.GONE);
                myLinearLayout.setAlpha(1f);
            }
        }, 5010); // Delay for 5010 miliseconds (10 miliseconds to show image + 5 seconds to remove image)





        ImageView imgLogo = findViewById(R.id.imgLogo);

        Button btnJocuri =  findViewById(R.id.btnJocuri);
        btnJocuri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity2();
            }
        });

        Button btnSetari =  findViewById(R.id.btnSetari);
        btnSetari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSetari();
            }
        });

        Button btnDespreNoi =  findViewById(R.id.btnDespreNoi);
        btnDespreNoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDespre();
            }
        });

        ///fac butonul sa isi schimbe dimensiunile dupa rezolutia device-ului
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int heightbtn = displayMetrics.heightPixels;
        int widthbtn = displayMetrics.widthPixels;
        btnJocuri.getLayoutParams().width=widthbtn / (25/10);
        btnJocuri.getLayoutParams().height=heightbtn / 20;

        btnSetari.getLayoutParams().width=widthbtn / (25/10);
        btnSetari.getLayoutParams().height=heightbtn / 20;

        btnDespreNoi.getLayoutParams().width=widthbtn / (25/10);
        btnDespreNoi.getLayoutParams().height=heightbtn / 20;

        imgLogo.getLayoutParams().height=heightbtn * 5 / 10;
        imgLogo.getLayoutParams().width=heightbtn * 5 / 10;


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            /*imgLogo.scale*/
            decreaseLinearLayoutHeight();
        }

    }
    private void decreaseLinearLayoutHeight() {
        LinearLayout linearLayoutLogo = findViewById(R.id.LinearLayoutLogo);
        linearLayoutLogo.setTranslationY(100);
    }

    public void openSetari() {
        Intent intent = new Intent(this, Setari.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void openDespre() {
        Intent intent = new Intent(this, despre.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }


    public void openMainActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void clickDespreNoi (View view){
        
        TextView txtHello = findViewById(R.id.txtMessage);
        txtHello.setText("Justice in Math");
    }

}