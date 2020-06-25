package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView timerTextView;
Button startButton;
Button resetButton;
Button stopButton;
private int seconds = 0;
private boolean running = false;
public void startButton(View view){
    startButton.setVisibility(View.INVISIBLE);
    Log.i("Startbutton clicked","pressed start");
    stopButton.setVisibility(View.VISIBLE);
    resetButton.setVisibility(View.VISIBLE);
    running = true;
}
public void stopButton(View view){
    startButton.setVisibility(View.VISIBLE);
    resetButton.setVisibility(View.INVISIBLE);
    stopButton.setVisibility(View.INVISIBLE);
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
if(running)
{
    Handler handler = new Handler();
    Runnable run = new Runnable() {
        @Override
        public void run() {

        }
    };

}
else {

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

}
}