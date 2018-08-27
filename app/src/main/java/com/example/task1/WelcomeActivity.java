package com.example.task1;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import handlers.PreferencesHandler;

public class WelcomeActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PreferencesHandler preferencesHandler=new PreferencesHandler(getBaseContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(LoginActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.textView2);
        textView.setText(message);

        boolean isNew = preferencesHandler.getIsNew();

        if(isNew) {
            Snackbar.make(findViewById(R.id.welcome_layout), R.string.new_user, Snackbar.LENGTH_SHORT).show();
            preferencesHandler.setIsNew(false);
        }
    }
}
