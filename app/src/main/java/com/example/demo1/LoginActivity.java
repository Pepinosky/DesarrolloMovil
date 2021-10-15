package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.demo1.controllers.AuthController;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin, btnRegister;
    private TextInputLayout fieldNickName, fieldPassword;
    private AuthController authController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        authController = new AuthController(this);
        authController.checkUserSession();




        fieldNickName= findViewById(R.id.activity_login_field_user);
        fieldPassword= findViewById(R.id.activity_login_field_password);
        btnLogin = findViewById(R.id.activity_login_btn_login);
        btnRegister = findViewById(R.id.activity_login_btn_register);




        btnLogin.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), "Iniciando sesión", Toast.LENGTH_SHORT).show();

            String nickname = fieldNickName.getEditText().getText().toString();
            String password = fieldPassword.getEditText().getText().toString();

            boolean nicknameValid = !nickname.isEmpty() ;
            boolean passwordValid = !password.isEmpty();

            if (!nicknameValid) {
                fieldNickName.setError("El email es inválido");
            } else {
               fieldNickName.setError(null);
                fieldNickName.setErrorEnabled(false);
            }

            if (!passwordValid) {
                fieldPassword.setError("Campo requerido");
            } else {
                fieldPassword.setError(null);
                fieldPassword.setErrorEnabled(false);
            }

            if (nicknameValid && passwordValid) {
                authController.login(nickname, password);
            } else {
                Toast.makeText(view.getContext(), "Campos inválidos", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(view -> {
            Intent i = new Intent(view.getContext(), RegisterActivity.class);
            startActivity(i);
            finish();
        });




    }








    }
