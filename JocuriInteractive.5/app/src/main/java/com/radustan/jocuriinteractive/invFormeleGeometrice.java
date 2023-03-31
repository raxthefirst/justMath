package com.radustan.jocuriinteractive;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class invFormeleGeometrice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invformelegeometrice);


        ImageView imgCerc = findViewById(R.id.cerc);
        ImageView imgPatrat = findViewById(R.id.patrat);
        ImageView imgDreptunghi = findViewById(R.id.dreptunghi);
        ImageView imgOval = findViewById(R.id.oval);
        ImageView imgTrapez = findViewById(R.id.trapez);
        ImageView imgPentagon = findViewById(R.id.pentagon);
        ImageView imgHexagon = findViewById(R.id.hexagon);
        ImageView imgTriunghi = findViewById(R.id.triunghi);
        ImageView imgRomb = findViewById(R.id.romb);

        TextView txtCerc = findViewById(R.id.txtcerc);
        TextView txtPatrat = findViewById(R.id.txtpatrat);
        TextView txtDreptunghi = findViewById(R.id.txtdreptunghi);
        TextView txtOval = findViewById(R.id.txtoval);
        TextView txtTrapez = findViewById(R.id.txttrapez);
        TextView txtPentagon = findViewById(R.id.txtpentagon);
        TextView txtHexagon = findViewById(R.id.txthexagon);
        TextView txtTriunghi = findViewById(R.id.txttriunghi);
        TextView txtRomb = findViewById(R.id.txtromb);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int heightbtn = displayMetrics.heightPixels;
        int widthbtn = displayMetrics.widthPixels;

        imgCerc.getLayoutParams().width=widthbtn / 3;
        imgCerc.getLayoutParams().height=heightbtn / 3;
        imgCerc.setTranslationX(widthbtn / 10);
        txtCerc.setTextSize(widthbtn/15);
        txtCerc.setTranslationX(widthbtn/5);

        imgDreptunghi.getLayoutParams().width=widthbtn / 5;
        imgDreptunghi.getLayoutParams().height=heightbtn / 5;
        imgDreptunghi.setTranslationX(widthbtn / 10);
        txtDreptunghi.setTextSize(widthbtn/15);
        txtDreptunghi.setTranslationX(widthbtn/5);

        imgPatrat.getLayoutParams().width=widthbtn / 5;
        imgPatrat.getLayoutParams().height=heightbtn / 5;
        imgPatrat.setTranslationX(widthbtn / 10);
        txtPatrat.setTextSize(widthbtn/15);
        txtPatrat.setTranslationX(widthbtn/5);

        imgTriunghi.getLayoutParams().width=widthbtn / 5;
        imgTriunghi.getLayoutParams().height=heightbtn / 5;
        imgTriunghi.setTranslationX(widthbtn / 10);
        txtTriunghi.setTextSize(widthbtn/15);
        txtTriunghi.setTranslationX(widthbtn/5);

        imgPentagon.getLayoutParams().width=widthbtn / 5;
        imgPentagon.getLayoutParams().height=heightbtn / 5;
        imgPentagon.setTranslationX(widthbtn / 10);
        txtPentagon.setTextSize(widthbtn/15);
        txtPentagon.setTranslationX(widthbtn/5);

        imgHexagon.getLayoutParams().width=widthbtn / 5;
        imgHexagon.getLayoutParams().height=heightbtn / 5;
        imgHexagon.setTranslationX(widthbtn / 10);
        txtHexagon.setTextSize(widthbtn/15);
        txtHexagon.setTranslationX(widthbtn/5);

        imgOval.getLayoutParams().width=widthbtn / 5;
        imgOval.getLayoutParams().height=heightbtn / 5;
        imgOval.setTranslationX(widthbtn / 10);
        txtOval.setTextSize(widthbtn/15);
        txtOval.setTranslationX(widthbtn/5);

        imgTrapez.getLayoutParams().width=widthbtn / 5;
        imgTrapez.getLayoutParams().height=heightbtn / 5;
        imgTrapez.setTranslationX(widthbtn / 10);
        txtTrapez.setTextSize(widthbtn/15);
        txtTrapez.setTranslationX(widthbtn/5);

        imgRomb.getLayoutParams().width=widthbtn / 5;
        imgRomb.getLayoutParams().height=heightbtn / 5;
        imgRomb.setTranslationX(widthbtn / 10);
        txtRomb.setTextSize(widthbtn/15);
        txtRomb.setTranslationX(widthbtn/5);


        imgCerc.setColorFilter(Color.TRANSPARENT);
        imgOval.setColorFilter(Color.TRANSPARENT);
        imgDreptunghi.setColorFilter(Color.TRANSPARENT);
        imgPatrat.setColorFilter(Color.TRANSPARENT);
        imgRomb.setColorFilter(Color.TRANSPARENT);
        imgHexagon.setColorFilter(Color.TRANSPARENT);
        imgTrapez.setColorFilter(Color.TRANSPARENT);
        imgPentagon.setColorFilter(Color.TRANSPARENT);
        imgTriunghi.setColorFilter(Color.TRANSPARENT);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}