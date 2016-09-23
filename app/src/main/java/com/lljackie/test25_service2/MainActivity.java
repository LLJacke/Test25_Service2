package com.lljackie.test25_service2;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "activityTag";
    MyService myService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ServiceConnection serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.e(TAG, "onServiceConnected");
                myService = ((MyService.LocalBinder) service).getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.e(TAG,"onServiceDisconnected");
            }
        };

        Button bt_start = (Button) findViewById(R.id.bt_start);
        Button bt_close = (Button) findViewById(R.id.bt_close);
        Button bt_use = (Button) findViewById(R.id.bt_use);

        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyService.class);
                bindService(intent,serviceConnection, Service.BIND_AUTO_CREATE);
            }
        });

        bt_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myService!=null){
                    unbindService(serviceConnection);
                }
            }
        });

        bt_use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myService!=null){
                    Log.e(TAG,"UseService" + myService.add(234,432));
                }
            }
        });
    }
}
