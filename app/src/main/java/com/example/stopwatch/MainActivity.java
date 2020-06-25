package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
TextView timerTextView;
Button startButton;
Button resetButton;
Button stopButton;
private int seconds = 0;
private boolean running = false;
private boolean wasRunning = false;
public void startButton(View view){
    startButton.setVisibility(View.INVISIBLE);
    Log.i("Startbutton clicked","pressed start");
    stopButton.setVisibility(View.VISIBLE);
    resetButton.setVisibility(View.VISIBLE);
    running = true;
}
public void stopButton(View view){

    running = false;
}
public void resetButton(View view){
    startButton.setVisibility(View.VISIBLE);
    resetButton.setVisibility(View.INVISIBLE);
    stopButton.setVisibility(View.INVISIBLE);
    running  =false;
    seconds = 0;
}


public void runTimer(){
    final Handler handler = new Handler();
    handler.post(new Runnable() {
        @Override
        public void run() {
       int hrs = seconds/3600;
       int min = (seconds%3600)/60;
       int sec  = seconds%60;

       String setTime = String.format(Locale.getDefault(),"%d:%02d:%02d", hrs,min, sec);
       timerTextView.setText(setTime);
       if (running){
           seconds++;
       }
       handler.postDelayed(this,1000);
        }

    });


}
public void onPause() {
    super.onPause();
    wasRunning = running;
    running = false;
}
public void onResume() {
    super.onResume();
    if (wasRunning) {
        running = true;
    }
}




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerTextView = findViewById(R.id.timerTextView);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);
        resetButton = findViewById(R.id.resetButton);
        startButton.setVisibility(View.VISIBLE);
        resetButton.setVisibility(View.INVISIBLE);
        stopButton.setVisibility(View.INVISIBLE);

        if(savedInstanceState!=null){
            //to get last state of the stopwatch
            seconds = savedInstanceState.getInt("seconds");
            running
                    = savedInstanceState
                    .getBoolean("running");
            wasRunning= savedInstanceState
                    .getBoolean("wasRunning");
        }
runTimer();
}

    public void onSaveInstanceState(
            Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState
                .putInt("seconds", seconds);
        savedInstanceState
                .putBoolean("running", running);
        savedInstanceState
                .putBoolean("wasRunning", wasRunning);
    }
}