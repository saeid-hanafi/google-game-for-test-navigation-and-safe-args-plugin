package com.example.android.navigationsample;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {
    private SharedPreferences sharedPreferences;

    public UserManager(Context context) {
        this.sharedPreferences = context.getSharedPreferences("auth", Context.MODE_PRIVATE);
    }

    public boolean saveSignUp(String username, String email, String pass) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("email", email);
        editor.putString("pass", pass);
        return editor.commit();
    }

    public String getUsername() {
        return sharedPreferences.getString("username", "");
    }

    public String getEmail() {
        return sharedPreferences.getString("email", "");
    }

    public String getPass() {
        return sharedPreferences.getString("pass", "");
    }
}
