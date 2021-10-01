package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout fieldFirstName, fieldLastName, fieldHeight, fieldBirthDate, fieldPassword, fieldUser;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fieldUser = findViewById(R.id.activity_main_field_user);
        fieldFirstName = findViewById(R.id.activity_main_field_name);
        fieldLastName = findViewById(R.id.activity_main_field_last_name);
        fieldBirthDate = findViewById(R.id.activity_main_field_birth_date);

        btnRegister = findViewById(R.id.activity_main_btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("RegisterPressed", fieldUser.getEditText().getText().toString());
            }
        })




        Log.v( "Debugging", "se creo el activity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v( "Debugging", "se pauso el activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v( "Debugging", "se reanudo el activity");


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v( "Debugging", "se detuvo el activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v( "Debugging", "se destruyo el activity");
    }
}