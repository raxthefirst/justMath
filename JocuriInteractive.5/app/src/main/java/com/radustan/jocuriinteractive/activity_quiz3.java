package com.radustan.jocuriinteractive;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class activity_quiz3 extends AppCompatActivity implements View.OnClickListener {
    TextView totalQuestionTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;
    ImageButton imagebtn1, imagebtn2, imagebtn3, imagebtn4, lastClickedButton;
    public static int resID, resID2, resID3, resID4;
    int widthbtn;

    ImageView sageata;
    ImageView norstanga, norsupa, norvesel, norsus, nordreapta;



    int totalQuestion = QuestionAnswer3.question.length;
    int scor = 0;
    int currentQuestionIndex = 0;


    /* TIMER --------------------- */

    private TextView timer_TextView;
    public int secondsPassed = 0;
    private Handler handler = new Handler();
    private boolean isTimerRunning = true;
    String total = "";
    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (isTimerRunning) {
                secondsPassed++;
                int minutes = secondsPassed / 60;
                int seconds = secondsPassed % 60;
                String formattedMinutes = String.format("%02d", minutes);
                String formattedSeconds = String.format("%02d", seconds);
                timer_TextView.setText(formattedMinutes + " : " + formattedSeconds);
                total = formattedMinutes + ":" + formattedSeconds;
                handler.postDelayed(this, 1000);
            }
        }
    };
    private void freezeTimer() {
        isTimerRunning = false;
    }
    private void unfreezeTimer() {
        isTimerRunning = true;
    }
     /*END OF TIMER -------------------------*/

    private void onImageButtonClicked(ImageButton clickedButton) {
        lastClickedButton = clickedButton;
    }


    public void animNorsupa(){
        Animation shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.norsupa);
        norsupa.setVisibility(View.VISIBLE);
        Glide.with(this).clear(norsupa); // clear any ongoing image loading
        Glide.with(this).load(R.drawable.norsupa).into(norsupa); // load the GIF from the beginning
        norsupa.startAnimation(shakeAnimation); //animeaza norul supa

        new Handler().postDelayed(() -> norsupa.setVisibility(View.GONE), 5500); // Delay for 3010 miliseconds (10 miliseconds to show image + 3 seconds to remove image)
    }
    public void animVesel(){
        Animation shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.norsupa);
        norvesel.setVisibility(View.VISIBLE);
        Glide.with(this).clear(norvesel); // clear any ongoing image loading
        Glide.with(this).load(R.drawable.norvesel).into(norvesel); // load the GIF from the beginning
        norvesel.startAnimation(shakeAnimation); //animeaza norul supa

        new Handler().postDelayed(() -> norvesel.setVisibility(View.GONE), 8500); // Delay for 3010 miliseconds (10 miliseconds to show image + 3 seconds to remove image)
    }


    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
        protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_quiz1);

            timer_TextView = findViewById(R.id.timer_textView);
            handler.postDelayed(runnable, 1000);

            totalQuestionTextView = findViewById(R.id.total_question);
            questionTextView = findViewById(R.id.question);
            ansA = findViewById(R.id.ans_A);
            ansB = findViewById(R.id.ans_B);
            ansC = findViewById(R.id.ans_C);
            ansD = findViewById(R.id.ans_D);
            submitBtn = findViewById(R.id.submit_btn);
            imagebtn1 = findViewById(R.id.imageBtn1);
            imagebtn2 = findViewById(R.id.imageBtn2);
            imagebtn3 = findViewById(R.id.imageBtn3);
            imagebtn4 = findViewById(R.id.imageBtn4);
            sageata = findViewById(R.id.sageata);
            norstanga = findViewById(R.id.norstanga);
            norsus = findViewById(R.id.norsus);
            nordreapta = findViewById(R.id.nordreapta);
            norsupa = findViewById(R.id.norsupa);
            norvesel = findViewById(R.id.norvesel);
            MediaPlayer mediaPlayer1 = MediaPlayer.create(this, R.raw.raspcorect);
            lastClickedButton = null;
            unfreezeTimer();


        ansA.setOnClickListener(this);
            ansB.setOnClickListener(this);
            ansC.setOnClickListener(this);
            ansD.setOnClickListener(this);
            submitBtn.setOnClickListener(this);

             ///fac butonul sa isi schimbe dimensiunile dupa rezolutia device-ului
             //-----------------

                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int heightbtn = displayMetrics.heightPixels;
                int widthbtn = displayMetrics.widthPixels;
                ProgressBar pbintre = findViewById(R.id.progress_bar);

                ansA.getLayoutParams().width=widthbtn / (25/10);
                ansA.getLayoutParams().height=heightbtn / 20;
                ansB.getLayoutParams().width=widthbtn / (25/10);
                ansB.getLayoutParams().height=heightbtn / 20;
                ansC.getLayoutParams().width=widthbtn / (25/10);
                ansC.getLayoutParams().height=heightbtn / 20;
                ansD.getLayoutParams().width=widthbtn / (25/10);
                ansD.getLayoutParams().height=heightbtn / 20;
                pbintre.getLayoutParams().width=widthbtn / 4;


                submitBtn.getLayoutParams().width=widthbtn / (25/10);
                submitBtn.getLayoutParams().height=heightbtn / 20;
                submitBtn.setTextSize(widthbtn/35);

                totalQuestionTextView.setTextSize(widthbtn/30);
                questionTextView.setTextSize(widthbtn/20);
                questionTextView.setTranslationY(widthbtn/20);

                 ansA.setTextSize(widthbtn/35);
                 ansB.setTextSize(widthbtn/35);
                 ansC.setTextSize(widthbtn/35);
                 ansD.setTextSize(widthbtn/35);
                 timer_TextView.setTextSize(widthbtn/35);

                 sageata.setTranslationX(-widthbtn/35);
                 sageata.setPadding(0,0,0, 20);

                //----------


        imagebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int oldColor1 = Color.parseColor("#ffda1f");    ///schimb culorile butonului apasat
                int newColor1 = Color.parseColor("#faa200");
                int oldColor2 = Color.parseColor("#b88934");
                int newColor2 = Color.parseColor("#b86834");

                ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                        oldColor1 == Color.RED ? 0 : 1, 0, 0, 0, Color.red(newColor1) - Color.red(oldColor1),
                        0, oldColor1 == Color.GREEN ? 0 : 1, 0, 0, Color.green(newColor1) - Color.green(oldColor1),
                        0, 0, oldColor1 == Color.BLUE ? 0 : 1, 0, Color.blue(newColor1) - Color.blue(oldColor1),
                        0, 0, 0, 1, 0,
                });
                colorMatrix.postConcat(new ColorMatrix(new float[]{
                        oldColor2 == Color.RED ? 0 : 1, 0, 0, 0, Color.red(newColor2) - Color.red(oldColor2),
                        0, oldColor2 == Color.GREEN ? 0 : 1, 0, 0, Color.green(newColor2) - Color.green(oldColor2),
                        0, 0, oldColor2 == Color.BLUE ? 0 : 1, 0, Color.blue(newColor2) - Color.blue(oldColor2),
                        0, 0, 0, 1, 0,
                }));
                ColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
                imagebtn1.getDrawable().setColorFilter(colorFilter);
                imagebtn2.setColorFilter(Color.TRANSPARENT);
                imagebtn3.setColorFilter(Color.TRANSPARENT);
                imagebtn4.setColorFilter(Color.TRANSPARENT);

                onImageButtonClicked(imagebtn1);
            }
        });

        imagebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int oldColor1 = Color.parseColor("#ffda1f");    ///schimb culorile butonului apasat
                int newColor1 = Color.parseColor("#faa200");
                int oldColor2 = Color.parseColor("#b88934");
                int newColor2 = Color.parseColor("#b86834");

                ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                        oldColor1 == Color.RED ? 0 : 1, 0, 0, 0, Color.red(newColor1) - Color.red(oldColor1),
                        0, oldColor1 == Color.GREEN ? 0 : 1, 0, 0, Color.green(newColor1) - Color.green(oldColor1),
                        0, 0, oldColor1 == Color.BLUE ? 0 : 1, 0, Color.blue(newColor1) - Color.blue(oldColor1),
                        0, 0, 0, 1, 0,
                });
                colorMatrix.postConcat(new ColorMatrix(new float[]{
                        oldColor2 == Color.RED ? 0 : 1, 0, 0, 0, Color.red(newColor2) - Color.red(oldColor2),
                        0, oldColor2 == Color.GREEN ? 0 : 1, 0, 0, Color.green(newColor2) - Color.green(oldColor2),
                        0, 0, oldColor2 == Color.BLUE ? 0 : 1, 0, Color.blue(newColor2) - Color.blue(oldColor2),
                        0, 0, 0, 1, 0,
                }));
                ColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
                imagebtn2.getDrawable().setColorFilter(colorFilter);
                imagebtn1.setColorFilter(Color.TRANSPARENT);
                imagebtn3.setColorFilter(Color.TRANSPARENT);
                imagebtn4.setColorFilter(Color.TRANSPARENT);

                onImageButtonClicked(imagebtn2);
            }
        });

        imagebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int oldColor1 = Color.parseColor("#ffda1f");    ///schimb culorile butonului apasat
                int newColor1 = Color.parseColor("#faa200");
                int oldColor2 = Color.parseColor("#b88934");
                int newColor2 = Color.parseColor("#b86834");

                ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                        oldColor1 == Color.RED ? 0 : 1, 0, 0, 0, Color.red(newColor1) - Color.red(oldColor1),
                        0, oldColor1 == Color.GREEN ? 0 : 1, 0, 0, Color.green(newColor1) - Color.green(oldColor1),
                        0, 0, oldColor1 == Color.BLUE ? 0 : 1, 0, Color.blue(newColor1) - Color.blue(oldColor1),
                        0, 0, 0, 1, 0,
                });
                colorMatrix.postConcat(new ColorMatrix(new float[]{
                        oldColor2 == Color.RED ? 0 : 1, 0, 0, 0, Color.red(newColor2) - Color.red(oldColor2),
                        0, oldColor2 == Color.GREEN ? 0 : 1, 0, 0, Color.green(newColor2) - Color.green(oldColor2),
                        0, 0, oldColor2 == Color.BLUE ? 0 : 1, 0, Color.blue(newColor2) - Color.blue(oldColor2),
                        0, 0, 0, 1, 0,
                }));
                ColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
                imagebtn3.getDrawable().setColorFilter(colorFilter);
                imagebtn1.setColorFilter(Color.TRANSPARENT);
                imagebtn2.setColorFilter(Color.TRANSPARENT);
                imagebtn4.setColorFilter(Color.TRANSPARENT);

                onImageButtonClicked(imagebtn3);
            }
        });

        imagebtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int oldColor1 = Color.parseColor("#ffda1f");    ///schimb culorile butonului apasat
                int newColor1 = Color.parseColor("#faa200");
                int oldColor2 = Color.parseColor("#b88934");
                int newColor2 = Color.parseColor("#b86834");

                ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                        oldColor1 == Color.RED ? 0 : 1, 0, 0, 0, Color.red(newColor1) - Color.red(oldColor1),
                        0, oldColor1 == Color.GREEN ? 0 : 1, 0, 0, Color.green(newColor1) - Color.green(oldColor1),
                        0, 0, oldColor1 == Color.BLUE ? 0 : 1, 0, Color.blue(newColor1) - Color.blue(oldColor1),
                        0, 0, 0, 1, 0,
                });
                colorMatrix.postConcat(new ColorMatrix(new float[]{
                        oldColor2 == Color.RED ? 0 : 1, 0, 0, 0, Color.red(newColor2) - Color.red(oldColor2),
                        0, oldColor2 == Color.GREEN ? 0 : 1, 0, 0, Color.green(newColor2) - Color.green(oldColor2),
                        0, 0, oldColor2 == Color.BLUE ? 0 : 1, 0, Color.blue(newColor2) - Color.blue(oldColor2),
                        0, 0, 0, 1, 0,
                }));
                ColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
                imagebtn4.getDrawable().setColorFilter(colorFilter);
                imagebtn1.setColorFilter(Color.TRANSPARENT);
                imagebtn2.setColorFilter(Color.TRANSPARENT);
                imagebtn3.setColorFilter(Color.TRANSPARENT);

                onImageButtonClicked(imagebtn4);
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Setari.FaAnim){                                        //daca este apasat butonul din setari
                    if(ok){                  //daca s-a terminat animatia
                        if(lastClickedButton != null) {
                            int lastClickedTag = (int) lastClickedButton.getTag();
                            Resources res = getResources();
                            String correctAnswerName = QuestionAnswer3.correctAnswers[currentQuestionIndex];
                            int correctAnswerTag = res.getIdentifier(correctAnswerName, "drawable", getPackageName());

                            if (Integer.toString(lastClickedTag).equals(Integer.toString(correctAnswerTag))) {
                                scor++;
                                mediaPlayer1.start();
                                if(Setari.cuNori){  animVesel(); }
                                try {
                                    Thread.sleep(500); // 1000 milliseconds = 1 second
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } else{
                               if(Setari.cuNori){ animNorsupa();}
                            }
                            currentQuestionIndex++;
                            loadNewQuestion();
                        }
                        else {
                            currentQuestionIndex++;
                            loadNewQuestion();
                        }
                    }
                    else{
                        LayoutInflater inflater = getLayoutInflater();
                        @SuppressLint("InflateParams") View layout = inflater.inflate(R.layout.toast_layout, null);
                        TextView text = layout.findViewById(R.id.textView1);
                        text.setText("Ascultă întrebarea până la final!");

                        Toast toast = new Toast(getApplicationContext());
                        toast.setGravity(Gravity.BOTTOM, 0, 190); // set position 70 pixels higher
                        toast.setDuration(Toast.LENGTH_LONG);
                        toast.setView(layout);
                        toast.show();

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                toast.cancel();
                            }
                        }, 2000); // Delay in milliseconds before hiding the Toast
                    }
                }else
                {
                    if(lastClickedButton != null) {
                        int lastClickedTag = (int) lastClickedButton.getTag();
                        Resources res = getResources();
                        String correctAnswerName = QuestionAnswer3.correctAnswers[currentQuestionIndex];
                        int correctAnswerTag = res.getIdentifier(correctAnswerName, "drawable", getPackageName());

                        if (Integer.toString(lastClickedTag).equals(Integer.toString(correctAnswerTag))) {
                            scor++;
                            mediaPlayer1.start();
                            if(Setari.cuNori){  animVesel(); }
                        } else{
                            if(Setari.cuNori){  animNorsupa();}
                        }

                        try {
                            Thread.sleep(500); // 1000 milliseconds = 1 second
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        currentQuestionIndex++;
                        loadNewQuestion();
                    } else{
                        currentQuestionIndex++;
                        loadNewQuestion();
                    }
                }
            }
        });


            int intrCurenta = currentQuestionIndex + 1;
            totalQuestionTextView.setText("Întrebarea " + intrCurenta + "/" + totalQuestion);

            loadNewQuestion();

        mHandler.postDelayed(mRunnable, 100);

        } ///finalul void oncreate


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

            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int widthbtn = displayMetrics.widthPixels;
                norstanga.getLayoutParams().width = widthbtn;
                norstanga.getLayoutParams().height = widthbtn;
                norstanga.setTranslationX(-240);
                norstanga.setTranslationY(widthbtn / 4);
                norstanga.setAlpha(0.3f);

                norsus.getLayoutParams().width = widthbtn / (25/10);
                norsus.setTranslationY(-widthbtn / 2 - 140);
                norsus.setTranslationX(-70);

                nordreapta.getLayoutParams().width = widthbtn / 2;
                nordreapta.getLayoutParams().height = widthbtn / 2;
                nordreapta.setTranslationY(80);
            }
            mHandler.postDelayed(this, 100); // Run this Runnable again after 100ms
        }
    };


    boolean ok = false;
    public void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion - 1)
        {
            submitBtn.setText("Finalizează.");
        }
        else{
            submitBtn.setText("Mai departe!");
        }
        if(currentQuestionIndex == totalQuestion)
        {
            finishQuiz();
            return;
        }

        Resources res = getResources();

        int intrCurenta = currentQuestionIndex + 1;
        questionTextView.setText(QuestionAnswer3.question[currentQuestionIndex]);
                    resID = res.getIdentifier(QuestionAnswer3.choices[currentQuestionIndex][0], "drawable", getPackageName());
        imagebtn1.setImageResource(resID);
        imagebtn1.setTag(resID);
                    resID2 = res.getIdentifier(QuestionAnswer3.choices[currentQuestionIndex][1], "drawable", getPackageName());
        imagebtn2.setImageResource(resID2);
        imagebtn2.setTag(resID2);
                    resID3 = res.getIdentifier(QuestionAnswer3.choices[currentQuestionIndex][2], "drawable", getPackageName());
        imagebtn3.setImageResource(resID3);
        imagebtn3.setTag(resID3);
                    resID4 = res.getIdentifier(QuestionAnswer3.choices[currentQuestionIndex][3], "drawable", getPackageName());
        imagebtn4.setImageResource(resID4);
        imagebtn4.setTag(resID4);


                    ansA.setText(QuestionAnswer3.choices[currentQuestionIndex][0]); //de scos
                    ansB.setText(QuestionAnswer3.choices[currentQuestionIndex][1]); //idem
                    ansC.setText(QuestionAnswer3.choices[currentQuestionIndex][2]); //idem
                    ansD.setText(QuestionAnswer3.choices[currentQuestionIndex][3]); //idem
                    totalQuestionTextView.setText("Întrebarea: " + intrCurenta + "/" + totalQuestion);

                    ok = false;
                    if (Setari.FaAnim) {
                        int duration = 4000; // duration of animation in milliseconds
                        ValueAnimator animator = ValueAnimator.ofInt(0, questionTextView.getText().length());
                        animator.setDuration(duration);
                        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {
                                int animatedValue = (int) animation.getAnimatedValue();
                                SpannableStringBuilder builder = new SpannableStringBuilder(questionTextView.getText());
                                ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.parseColor("#ffda1f"));
                                builder.setSpan(redSpan, 0, animatedValue, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                                questionTextView.setText(builder);
                            }
                        });
                        animator.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {
                                ok = true;
                            }

                            @Override
                            public void onAnimationCancel(Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animator) {

                            }
                        });
                            animator.start();
                    }



        ProgressBar pbintre = findViewById(R.id.progress_bar);
        int tempval = currentQuestionIndex;
        pbintre.setMax(totalQuestion - 1);
        pbintre.setProgress(tempval);
    }



    @Override
    public void onClick(View view) {
        ansA.setBackgroundColor(Color.parseColor("#064594"));
        ansB.setBackgroundColor(Color.parseColor("#064594"));
        ansC.setBackgroundColor(Color.parseColor("#064594"));
        ansD.setBackgroundColor(Color.parseColor("#064594"));


        imagebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int oldColor1 = Color.parseColor("#ffda1f");    ///schimb culorile butonului apasat
                int newColor1 = Color.parseColor("#faa200");
                int oldColor2 = Color.parseColor("#b88934");
                int newColor2 = Color.parseColor("#b86834");

                ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                        oldColor1 == Color.RED ? 0 : 1, 0, 0, 0, Color.red(newColor1) - Color.red(oldColor1),
                        0, oldColor1 == Color.GREEN ? 0 : 1, 0, 0, Color.green(newColor1) - Color.green(oldColor1),
                        0, 0, oldColor1 == Color.BLUE ? 0 : 1, 0, Color.blue(newColor1) - Color.blue(oldColor1),
                        0, 0, 0, 1, 0,
                });
                colorMatrix.postConcat(new ColorMatrix(new float[]{
                        oldColor2 == Color.RED ? 0 : 1, 0, 0, 0, Color.red(newColor2) - Color.red(oldColor2),
                        0, oldColor2 == Color.GREEN ? 0 : 1, 0, 0, Color.green(newColor2) - Color.green(oldColor2),
                        0, 0, oldColor2 == Color.BLUE ? 0 : 1, 0, Color.blue(newColor2) - Color.blue(oldColor2),
                        0, 0, 0, 1, 0,
                }));
                ColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
                imagebtn1.getDrawable().setColorFilter(colorFilter);
                imagebtn2.setColorFilter(Color.TRANSPARENT);
                imagebtn3.setColorFilter(Color.TRANSPARENT);
                imagebtn4.setColorFilter(Color.TRANSPARENT);

                onImageButtonClicked(imagebtn1);
            }
        });

        imagebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int oldColor1 = Color.parseColor("#ffda1f");    ///schimb culorile butonului apasat
                int newColor1 = Color.parseColor("#faa200");
                int oldColor2 = Color.parseColor("#b88934");
                int newColor2 = Color.parseColor("#b86834");

                ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                        oldColor1 == Color.RED ? 0 : 1, 0, 0, 0, Color.red(newColor1) - Color.red(oldColor1),
                        0, oldColor1 == Color.GREEN ? 0 : 1, 0, 0, Color.green(newColor1) - Color.green(oldColor1),
                        0, 0, oldColor1 == Color.BLUE ? 0 : 1, 0, Color.blue(newColor1) - Color.blue(oldColor1),
                        0, 0, 0, 1, 0,
                });
                colorMatrix.postConcat(new ColorMatrix(new float[]{
                        oldColor2 == Color.RED ? 0 : 1, 0, 0, 0, Color.red(newColor2) - Color.red(oldColor2),
                        0, oldColor2 == Color.GREEN ? 0 : 1, 0, 0, Color.green(newColor2) - Color.green(oldColor2),
                        0, 0, oldColor2 == Color.BLUE ? 0 : 1, 0, Color.blue(newColor2) - Color.blue(oldColor2),
                        0, 0, 0, 1, 0,
                }));
                ColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
                imagebtn2.getDrawable().setColorFilter(colorFilter);
                imagebtn1.setColorFilter(Color.TRANSPARENT);
                imagebtn3.setColorFilter(Color.TRANSPARENT);
                imagebtn4.setColorFilter(Color.TRANSPARENT);

                onImageButtonClicked(imagebtn2);
            }
        });

        imagebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int oldColor1 = Color.parseColor("#ffda1f");    ///schimb culorile butonului apasat
                int newColor1 = Color.parseColor("#faa200");
                int oldColor2 = Color.parseColor("#b88934");
                int newColor2 = Color.parseColor("#b86834");

                ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                        oldColor1 == Color.RED ? 0 : 1, 0, 0, 0, Color.red(newColor1) - Color.red(oldColor1),
                        0, oldColor1 == Color.GREEN ? 0 : 1, 0, 0, Color.green(newColor1) - Color.green(oldColor1),
                        0, 0, oldColor1 == Color.BLUE ? 0 : 1, 0, Color.blue(newColor1) - Color.blue(oldColor1),
                        0, 0, 0, 1, 0,
                });
                colorMatrix.postConcat(new ColorMatrix(new float[]{
                        oldColor2 == Color.RED ? 0 : 1, 0, 0, 0, Color.red(newColor2) - Color.red(oldColor2),
                        0, oldColor2 == Color.GREEN ? 0 : 1, 0, 0, Color.green(newColor2) - Color.green(oldColor2),
                        0, 0, oldColor2 == Color.BLUE ? 0 : 1, 0, Color.blue(newColor2) - Color.blue(oldColor2),
                        0, 0, 0, 1, 0,
                }));
                ColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
                imagebtn3.getDrawable().setColorFilter(colorFilter);
                imagebtn1.setColorFilter(Color.TRANSPARENT);
                imagebtn2.setColorFilter(Color.TRANSPARENT);
                imagebtn4.setColorFilter(Color.TRANSPARENT);

                onImageButtonClicked(imagebtn3);
            }
        });

        imagebtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int oldColor1 = Color.parseColor("#ffda1f");    ///schimb culorile butonului apasat
                int newColor1 = Color.parseColor("#faa200");
                int oldColor2 = Color.parseColor("#b88934");
                int newColor2 = Color.parseColor("#b86834");

                ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                        oldColor1 == Color.RED ? 0 : 1, 0, 0, 0, Color.red(newColor1) - Color.red(oldColor1),
                        0, oldColor1 == Color.GREEN ? 0 : 1, 0, 0, Color.green(newColor1) - Color.green(oldColor1),
                        0, 0, oldColor1 == Color.BLUE ? 0 : 1, 0, Color.blue(newColor1) - Color.blue(oldColor1),
                        0, 0, 0, 1, 0,
                });
                colorMatrix.postConcat(new ColorMatrix(new float[]{
                        oldColor2 == Color.RED ? 0 : 1, 0, 0, 0, Color.red(newColor2) - Color.red(oldColor2),
                        0, oldColor2 == Color.GREEN ? 0 : 1, 0, 0, Color.green(newColor2) - Color.green(oldColor2),
                        0, 0, oldColor2 == Color.BLUE ? 0 : 1, 0, Color.blue(newColor2) - Color.blue(oldColor2),
                        0, 0, 0, 1, 0,
                }));
                ColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
                imagebtn4.getDrawable().setColorFilter(colorFilter);
                imagebtn1.setColorFilter(Color.TRANSPARENT);
                imagebtn2.setColorFilter(Color.TRANSPARENT);
                imagebtn3.setColorFilter(Color.TRANSPARENT);

                onImageButtonClicked(imagebtn4);
            }
        });



       /* submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (Setari.FaAnim){           //daca este apasat butonul din setari de tts
                        if(ok){                  //daca s-a terminat animatia
                            int lastClickedTag = (int) lastClickedButton.getTag();
                            Resources res = getResources();
                            String correctAnswerName = QuestionAnswer.correctAnswers[currentQuestionIndex];
                            int correctAnswerTag = res.getIdentifier(correctAnswerName, "drawable", getPackageName());
                            if (Integer.toString(lastClickedTag).equals(Integer.toString(correctAnswerTag))) {
                                scor++;
                                mediaPlayer1.start();
                            }
                            else{
                                animNorsupa();
                            }

                            try {
                                Thread.sleep(1000); // 1000 milliseconds = 1 second
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                                    currentQuestionIndex++;
                                    loadNewQuestion();
                        }
                        else{
                            LayoutInflater inflater = getLayoutInflater();
                            View layout = inflater.inflate(R.layout.toast_layout, null);
                            TextView text = layout.findViewById(R.id.textView1);
                            text.setText("Ascultă întrebarea până la final!");

                            Toast toast = new Toast(getApplicationContext());
                            toast.setGravity(Gravity.BOTTOM, 0, 190); // set position 70 pixels higher
                            toast.setDuration(Toast.LENGTH_LONG);
                            toast.setView(layout);
                            toast.show();

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    toast.cancel();
                                }
                            }, 2000); // Delay in milliseconds before hiding the Toast
                        }
                    }else
                    {
                        int lastClickedTag = (int) lastClickedButton.getTag();
                        Resources res = getResources();
                        String correctAnswerName = QuestionAnswer.correctAnswers[currentQuestionIndex];
                        int correctAnswerTag = res.getIdentifier(correctAnswerName, "drawable", getPackageName());
                        if (Integer.toString(lastClickedTag).equals(Integer.toString(correctAnswerTag))) {
                            scor++;
                            mediaPlayer1.start();
                        }

                        try {
                            Thread.sleep(3000); // 1000 milliseconds = 1 second
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                                currentQuestionIndex++;
                                loadNewQuestion();
                    }
                }
        });*/ //buton nou degeaba

        /*Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn) {
            if (Setari.FaAnim){           //daca este apasat butonul din setari
                if(ok){                  //daca s-a terminat animatia
                    if (selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])) {
                        scor++;
                    }
                    currentQuestionIndex++;
                    loadNewQuestion();
                }
            }
            else{
                if (selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])) {
                    scor++;
                }
                currentQuestionIndex++;
                loadNewQuestion();
            }
        }
        else
        {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.rgb(1,45,99));
        }*/ //old button
    }


    void finishQuiz(){
        freezeTimer();
        String passMsg = "";
        String[] timer = {String.valueOf(timer_TextView)};
        if(scor > totalQuestion * 0.60)
        {
            passMsg = "Ai terminat jocul în "+ total +". Felicitări! (" + scor + "/" + currentQuestionIndex + " puncte)";
        }
        else
        {
            passMsg = "Mai încearcă, vei reuși! (" + scor + "/" + currentQuestionIndex + " puncte, în "+total+")";
        }

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage(passMsg)
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .setNegativeButton("Înapoi", (dialogInterface, i) -> closeQuiz() )
                .show();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int heightbtn = displayMetrics.heightPixels;
        int widthbtn = displayMetrics.widthPixels;

        TextView textView = dialog.findViewById(android.R.id.message);
        textView.setTextSize(widthbtn/30);
        dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextSize(widthbtn/30);
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextSize(widthbtn/30);
    }



    void closeQuiz(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


    public void restartQuiz(){
        secondsPassed = 0;
        scor = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
        unfreezeTimer();
        norvesel.setVisibility(View.GONE);
        norsupa.setVisibility(View.GONE);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
