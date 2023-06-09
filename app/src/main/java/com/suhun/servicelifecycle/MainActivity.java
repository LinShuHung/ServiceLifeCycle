package com.suhun.servicelifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private String tag = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag, "+++++MainActivity onCreate+++++");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "+++++MainActivity onStart+++++");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "+++++MainActivity onResume+++++");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "+++++MainActivity onPause+++++");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "+++++MainActivity onStop+++++");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "+++++MainActivity onDestroy+++++");
    }

    public void startServiceFun(View view){
        Log.d(tag, "+++++MainActivity startServiceFun+++++");
        Intent intent = new Intent(this, MyService.class);
        startService(intent);

    }
    public void stopServiceFun(View view){
        Log.d(tag, "+++++MainActivity stopServiceFun+++++");
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }
}