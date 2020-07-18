package com.saisreenivas.androidmediaplayer.moodscanner;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView thumbPrint;
    private TextView moodText;
    private AnimationDrawable animationDrawable;
    private String[] moodData;
    private Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moodData = new String[]{
                "You are happy!",
                "Excited",
                "Sad..",
                "Smile - it is good for you.",
                "Not your day :(",
                "In the clouds...",
                "Angry",
                "Disappointed",
                "Lovely!",
                "You are happy!",
                "You are happy!",
                "You are happy!"
        };

        moodText =(TextView) findViewById(R.id.mood_data);

        thumbPrint = (ImageView) findViewById(R.id.thumbPrint);
        thumbPrint.setBackgroundResource(R.drawable.thumb_animation);
        animationDrawable = (AnimationDrawable) thumbPrint.getBackground();

        thumbPrint.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                animationDrawable.start();
                showResult();

                return true;
            }
        });
    }

    public void showResult(){

        runnable = new Runnable() {
            @Override
            public void run() {
                int rand = (int) (Math.random() * moodData.length);
                moodText.setText(moodData[rand]);
                animationDrawable.stop();
            }
        };

        Handler mHandler = new Handler();
        mHandler.postDelayed(runnable, 3000); //3 seconds
    }
}
