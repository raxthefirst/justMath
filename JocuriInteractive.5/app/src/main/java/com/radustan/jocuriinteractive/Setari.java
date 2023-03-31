package com.radustan.jocuriinteractive;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class Setari extends AppCompatActivity {

    @SuppressLint("UseSwitchCompatOrMaterialCode")

    public static boolean FaAnim = true;
    public static boolean cuNori = true;

    @Override
    public void onCreate(Bundle savedInstanceState) { ///inainte era protected void
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setari);

        TextView txtVolum = findViewById(R.id.txtVolum);
        TextView txtAudio = findViewById(R.id.txtAudio);
        SeekBar seekBarVolum = findViewById(R.id.seekBarVolum);
        TextView txtVideo = findViewById(R.id.txtVideo);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int heightbtn = displayMetrics.heightPixels;
        int widthbtn = displayMetrics.widthPixels;
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch tts = (Switch) findViewById(R.id.TTS);
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch tts2 = findViewById(R.id.TTS2);

        txtVolum.setTextSize(widthbtn / 25);
        txtAudio.setTextSize(widthbtn / 15);
        txtVideo.setTextSize(widthbtn / 15);
/*        txtAudio.setEnabled(false);
        txtVideo.setEnabled(false);
            */

        tts2.setTextSize(widthbtn/25);

        tts.setTextSize(widthbtn/25);
        tts.setSwitchPadding(widthbtn/30);
        tts.setChecked(FaAnim);  ///faanim ia 1 daca e checked sau 0 daca nu

        SharedPreferences sharedPreferences = getSharedPreferences("switch_state", MODE_PRIVATE);
        FaAnim = sharedPreferences.getBoolean("fa_anim_key", false);
        boolean switchState = sharedPreferences.getBoolean("switch_state_key", false);
        tts.setChecked(switchState);
        tts.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("switch_state_key", isChecked);
                editor.putBoolean("fa_anim_key", FaAnim);
                editor.apply();
                if (isChecked) {
                    FaAnim = true;
                } else {
                    FaAnim = false;
                }
            }
        });

        SharedPreferences sharedPreferences2 = getSharedPreferences("switch_state2", MODE_PRIVATE);
        cuNori = sharedPreferences2.getBoolean("cuNori_key", false);
        boolean switchState2 = sharedPreferences2.getBoolean("switch_state2_key", false);
        tts2.setChecked(switchState2);
        tts2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked2) {
                cuNori = isChecked2;
                SharedPreferences.Editor editor = sharedPreferences2.edit();
                editor.putBoolean("switch_state2_key", isChecked2);
                editor.putBoolean("cuNori_key", cuNori);
                editor.apply();
                if (isChecked2) {
                    cuNori = true;
                } else {
                    cuNori = false;
                }
            }
        });



       /* SharedPreferences prefs = getSharedPreferences("com.bitproject.driverapplication", MODE_PRIVATE);
        boolean switchState = prefs.getBoolean("service_status", false);
        tts.setChecked(switchState);
        tts.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    FaAnim = true;
                } else {
                    FaAnim = false;
                }

                SharedPreferences.Editor editor = getSharedPreferences("com.bitproject.driverapplication", MODE_PRIVATE).edit();
                editor.putBoolean("service_status",isChecked);
                editor.commit();
            }
        });
        ///mentin valoarea butonului de mai sus*/



        seekBarVolum.getLayoutParams().width=widthbtn / (25/10);
        seekBarVolum.getLayoutParams().height=heightbtn / 20;

        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        seekBarVolum.setMax(maxVolume);
        seekBarVolum.setProgress(curVolume);

        seekBarVolum.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}