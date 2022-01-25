  package com.example.emargencyhelpline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

  public class SplashScreen extends AppCompatActivity {
      ProgressBar progressbar;
      TextView lodingtext;
      int value;
      Handler handler =new Handler();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        // Find by id
        progressbar = findViewById(R.id.progressBar);
        lodingtext= findViewById(R.id.lodingtext);

        //Thread class for Progress bar
        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                strtProgress();
                splashaction();
            }
        });
        thread.start();
      }

      private void splashaction() {

          try {
              Thread.sleep(50);
              Intent intent=new Intent(SplashScreen.this,MainActivity.class);
              startActivity(intent);
              finish();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }

      private void strtProgress() {

        for (value=0;value<=100;value=value+20){
            try {
                Thread.sleep(500);
                progressbar.setProgress(value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    lodingtext.setText(String.valueOf("Loding : "+value+"%"));
                }
            });
        }
      }
  }