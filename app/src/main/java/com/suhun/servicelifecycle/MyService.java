package com.suhun.servicelifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private String tag;
    public MyService() {
        tag = MyService.class.getSimpleName();
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
    }
}