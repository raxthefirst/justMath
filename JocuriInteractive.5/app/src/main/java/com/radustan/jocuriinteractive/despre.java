package com.radustan.jocuriinteractive;

import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class despre extends AppCompatActivity {
    TextView txtdespre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.despre);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int heightbtn = displayMetrics.heightPixels;
        int widthbtn = displayMetrics.widthPixels;
        txtdespre = findViewById(R.id.txtDespre);
        txtdespre.setTextSize(widthbtn / 20);
        txtdespre.setText("  Suntem o echipă de 2 elevi de la Liceul Teoretic de Informatică „Grigore Moisil” Iași, cu misiunea de a promova educația în toate mediile. " +
                "  Astfel, vă invităm să reflectați asupra joculețelor propuse de noi." + '\n' +
                "        JustMath - Justice in math!");
        txtdespre.setPadding(70, 70, 70, 70 );
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            txtdespre.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}

