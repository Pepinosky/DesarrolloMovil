package com.example.demo1.controllers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.demo1.LoginActivity;
import com.example.demo1.MainActivity;
import com.example.demo1.models.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuthController {
    private final String KEY_USER_ID = "userId";
    private final String KEY_HEIGHT = "userHeight";
    private final String KEY_FIRST_NAME = "userFirstName";
    private final String KEY_LAST_NAME = "userLastName";
    private final String KEY_BIRTH_DAY ="userBirthDay";
    private final String KEY_NICKNAME ="userNickName";
    private Context ctx;
    private SharedPreferences preferences;

    SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
    public AuthController(Context ctx) {
        this.ctx = ctx;
        int PRIVATE_MODE= 0;
        String PREF_NAME= "GymAppPref";
        this.preferences= ctx.getSharedPreferences(PREF_NAME, PRIVATE_MODE);

    }

    private void setUserSession(User user){
      SharedPreferences.Editor editor = this.preferences.edit();
        editor.putLong(KEY_USER_ID, user.getId());
        editor.putString(KEY_BIRTH_DAY, dateFormat.format(user.getBirthday()));
        editor.putString(KEY_HEIGHT, Double.toString(user.getHeight()));
        editor.putString(KEY_FIRST_NAME, user.getFirstName());
        editor.putString(KEY_LAST_NAME, user.getLastName());
        editor.putString(KEY_NICKNAME, user.getNickName());
        editor.apply();

    }
    public User getUserSession() {
        long id = preferences.getLong(KEY_USER_ID, 0);
        String nickName = preferences.getString(KEY_NICKNAME, "");
        String firstName = preferences.getString(KEY_FIRST_NAME, "");
        String lastName = preferences.getString(KEY_LAST_NAME, "");
        Double height = Double.parseDouble(preferences.getString(KEY_HEIGHT, "")) ;


        User user = new User(nickName , firstName, lastName, height, new Date());
        user.setId(id);

        return user;
    }

    public void checkUserSession() {
        long id = preferences.getLong(KEY_USER_ID, 0);
        if (id != 0) {
            Intent i = new Intent(ctx, MainActivity.class);
            ctx.startActivity(i);
            ((Activity) ctx).finish();
        }
    }

    public void register(User user) {
        Toast.makeText(ctx, String.format("Usuario %s registrado", user.getNickName()), Toast.LENGTH_SHORT).show();
        Intent i = new Intent(ctx, LoginActivity.class);
        ctx.startActivity(i);
    }

    public void login(String nickName, String password) {
        User user= new User("pepino", "alonso", "astorga", 1.70,  new Date());
        user.setPassword("123456");
        user.setId(1);
        if (password.equals(user.getPassword())) {
            setUserSession(user);
            Toast.makeText(ctx, String.format("Bienvenido %s", user.getNickName()), Toast.LENGTH_SHORT).show();
            Intent i = new Intent(ctx, MainActivity.class);
            ctx.startActivity(i);
            ((Activity) ctx).finish();
        } else {
            Toast.makeText(ctx, String.format("La contraseña es incorrecta", nickName), Toast.LENGTH_SHORT).show();
        }
    }

    public void logout() {
        SharedPreferences.Editor editor = this.preferences.edit();
        editor.clear();
        editor.apply();
        Toast.makeText(ctx, "Cerrando Sesión", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(ctx, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ctx.startActivity(i);
        ((Activity) ctx).finish();
    }
}
