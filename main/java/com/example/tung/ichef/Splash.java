package com.example.tung.ichef;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    private Handler mWaitHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mWaitHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try{
                    Intent intent = new Intent(getApplicationContext(), Home.class);
                    startActivity(intent);
                    finish();
                } catch (Exception ignored){
                    ignored.printStackTrace();
                }
            }
        }, 2000);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mWaitHandler.removeCallbacksAndMessages(null);
    }
}
