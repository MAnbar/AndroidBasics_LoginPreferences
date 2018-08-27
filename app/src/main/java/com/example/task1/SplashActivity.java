package com.example.task1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

import handlers.PreferencesHandler;

public class SplashActivity extends Activity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splashfile);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                PreferencesHandler preferencesHandler=new PreferencesHandler(getBaseContext());
                Boolean isInitialized = preferencesHandler.getInitialized();

                if(isInitialized){
                    String strUserName =  preferencesHandler.getUserName();
                    if(strUserName.equals("")){
                        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                    String message = strUserName;
                    intent.putExtra(PreferencesHandler.EXTRA_USERNAME, message);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 5000);

    }
}