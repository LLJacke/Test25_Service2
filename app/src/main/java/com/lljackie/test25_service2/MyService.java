package com.lljackie.test25_service2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "serviceTag";

    private LocalBinder myBinder = new LocalBinder();

    public class LocalBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }

    public int add(int x, int y){
        return x + y;
    }

    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG,"onBind");
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG,"onUnbind");
        return super.onUnbind(intent);
    }
}
