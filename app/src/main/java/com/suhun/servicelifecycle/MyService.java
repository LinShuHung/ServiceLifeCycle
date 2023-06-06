package com.suhun.servicelifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    private String tag;
    private int counter;
    private Timer timer;
    private UIHandler uiHandler;

    private class UIHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            counter++;
            Log.d(tag, "+++++MainActivity handleMessage+++++"+ counter);
        }
    }

    private class MyTask extends TimerTask {
        @Override
        public void run() {
            uiHandler.sendEmptyMessage(0);
        }
    }
    public MyService() {
        tag = MyService.class.getSimpleName();
        uiHandler = new UIHandler();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(tag, "+++++MyService onBind+++++");
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(tag, "+++++MyService onCreate+++++");
        timer = new Timer();
        timer.schedule(new MyTask(), 100, 100);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(tag, "+++++MyService onStartCommand+++++");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(tag, "+++++MyService onDestroy+++++");
        super.onDestroy();
        if(timer!=null){
            timer.cancel();
            timer.purge();
            timer = null;
        }
    }
}