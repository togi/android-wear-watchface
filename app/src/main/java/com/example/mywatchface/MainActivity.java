package com.example.mywatchface;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.widget.TextView;

public class MainActivity  extends Activity {

    private TextView mTextView;

//    private IHomeBackgroundService mService;
//    private ServiceConnection mServiceConnection = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            mService = IHomeBackgroundService.Stub.asInterface(service);
//
//            try {
//                mService.setStyle(WatchFaceStyle.Builder.forActivity(MainActivity.this).build());
//
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Unfortunately, this call to bind will throw a SecurityException, unless the app is signed
        // with either the same certificate as com.google.android.wearable.app, or with the system
        // certificate. The app will work without it, but you won't be able to set a WatchFaceStyle.

//        bindService(WatchFaceIntents.BIND_HOME_INTENT, mServiceConnection, BIND_AUTO_CREATE);

        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
                Log.d("", "TextView: " + mTextView.getText() + " view=" + mTextView);
            }
        });
    }
}