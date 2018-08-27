package com.example.task1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import handlers.PreferencesHandler;

public class LoginActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE_USER";
    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0) {
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                PreferencesHandler preferencesHandler=new PreferencesHandler(getBaseContext());

                TextInputLayout layUserName = (TextInputLayout) findViewById(R.id.textInputLayoutUsername);
                TextInputLayout layPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);

                EditText etUserName = (TextInputEditText) findViewById(R.id.textInputUsername);
                EditText etPassword = (TextInputEditText) findViewById(R.id.textInputPassword);

                String strUserName = etUserName.getText().toString();
                String strPassword = etPassword.getText().toString();

                layUserName.setError(null);
                layPassword.setError(null);

                if (TextUtils.isEmpty(strUserName)) {
                    //etUserName.setError("Username can't be empty");
                    layUserName.setError("Username can't be empty");
                    return;
                }
                if (TextUtils.isEmpty(strPassword)){
                    //etPassword.setError("Password can't be empty");
                    layPassword.setError("Password can't be empty");
                    return;
                }


                Boolean isInitialized = preferencesHandler.getInitialized();

                if(!isInitialized){
                    preferencesHandler.Initialize(strUserName,strPassword);
                }

                Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                String message = strUserName;
                intent.putExtra(PreferencesHandler.EXTRA_USERNAME, message);
                startActivity(intent);
            }
        });
    }
}
