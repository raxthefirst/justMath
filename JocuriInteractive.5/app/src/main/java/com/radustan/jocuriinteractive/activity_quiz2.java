package com.radustan.jocuriinteractive;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class activity_quiz2 extends AppCompatActivity implements View.OnClickListener {
    TextView totalQuestionTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;
    ImageButton imagebtn1;

    int totalQuestion = QuestionAnswer2.question.length;
    int scor = 0;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    /* TIMER --------------------- */

    private TextView timer_TextView;
    public int secondsPassed = 0;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            secondsPassed++;
            int minutes = secondsPassed / 60;
            int seconds = secondsPassed % 60;
            String formattedMinutes = String.format("%02d", minutes);
            String formattedSeconds = String.format("%02d", seconds);
            timer_TextView.setText(formattedMinutes + " : " + formattedSeconds);
            handler.postDelayed(this, 1000);
        }
    };

     /*END OF TIMER -------------------------*/




    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_quiz2);

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

                 ansA.setTextSize(widthbtn/35);
                 ansB.setTextSize(widthbtn/35);
                 ansC.setTextSize(widthbtn/35);
                 ansD.setTextSize(widthbtn/35);
                 timer_TextView.setTextSize(widthbtn/35);


                //----------


            int intrCurenta = currentQuestionIndex + 1;
            totalQuestionTextView.setText("Întrebarea " + intrCurenta + "/" + totalQuestion);

            loadNewQuestion();

        } ///finalul void oncreate



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

        int intrCurenta = currentQuestionIndex + 1;
        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
                    imagebtn1.setImageResource(R.drawable.dreptunghi);
                    ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
                    ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
                    ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
                    ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
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


        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn) {
            if (Setari.FaAnim){
                if(ok){
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
        }

    }

    void finishQuiz(){
        String passMsg = "";
        if(scor > totalQuestion * 0.60)
        {
            passMsg = "Ai terminat jocul. Felicitări! (" + scor + "/" + currentQuestionIndex + " puncte)";
        }
        else
        {
            passMsg = "Mai încearcă, vei reuși! (" + scor + "/" + currentQuestionIndex + " puncte)";
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
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
