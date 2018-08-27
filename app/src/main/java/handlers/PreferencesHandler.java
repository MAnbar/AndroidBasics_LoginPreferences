package handlers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferencesHandler {

    public final static  String EXTRA_USERNAME = "EXTRA_MESSAGE_USER";
    SharedPreferences preferences ;
    SharedPreferences.Editor editor;


    public PreferencesHandler(Context baseContext) {
        this.preferences = PreferenceManager.getDefaultSharedPreferences(baseContext);
        this.editor = preferences.edit();
    }

    public  Boolean getInitialized() {
        return preferences.getBoolean("isInit", false);
    }

    public  void Initialize(String userName, String PassWord) {
        editor.putString("userName", userName);
        editor.putString("passWord", PassWord);
        editor.putBoolean("isInit", true);
        editor.putBoolean("isNew", true);
        editor.apply();
    }

    public  String getUserName() {
        return preferences.getString("userName", "");
    }

    public boolean getIsNew(){
        return preferences.getBoolean("isNew",false);
    }

    public  void setIsNew(boolean isNew){
        editor.putBoolean("isNew", isNew);
        editor.apply();
    }
}
