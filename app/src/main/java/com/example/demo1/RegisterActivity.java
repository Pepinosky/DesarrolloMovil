package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import java.util.Date;

import com.example.demo1.controllers.AuthController;
import com.example.demo1.models.User;
import com.example.demo1.ui.DatePickerFragment;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    private final String DATE_PATTERN = "yyyy-MM-dd";
    private TextInputLayout fieldBirthday, fieldFirstName, fieldLastName,  fieldPassword, fieldNickName, fieldHeight;
    private Button btnRegister, btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        btnRegister= findViewById(R.id.activity_register_btn_register);
        btnLogin= findViewById(R.id.activity_register_btn_login);
        fieldBirthday= findViewById(R.id.activity_register_field_birth_date);
        fieldFirstName= findViewById(R.id.activity_register_field_first_name);
        fieldLastName= findViewById(R.id.activity_register_field_last_name);
        fieldNickName= findViewById(R.id.activity_register_field_nickname);
        fieldPassword= findViewById(R.id.activity_register_field_password);
        fieldHeight= findViewById(R.id.activity_register_field_height);

        btnLogin.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), "Volviendo a inicio de sesion...",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(view.getContext(), LoginActivity.class);
            startActivity(i);
            finish();
        });

        fieldBirthday.getEditText().setOnClickListener(view -> {
            DatePickerFragment.showDatePickerDialog(this, fieldBirthday, new Date());
        });

        btnRegister.setOnClickListener(view -> {
            String nickname = fieldNickName.getEditText().getText().toString();
            String firstName = fieldFirstName.getEditText().getText().toString();
            String lastName = fieldLastName.getEditText().getText().toString();
            String password = fieldPassword.getEditText().getText().toString();
            String birthday = fieldBirthday.getEditText().getText().toString();
            double height =  Double.parseDouble(fieldHeight.getEditText().getText().toString());




            boolean nicknameValid = !nickname.isEmpty();
            boolean firstNameValid = !firstName.isEmpty();
            boolean lastNameValid = !lastName.isEmpty();
            boolean birthdayValid = !birthday.isEmpty();
            boolean passwordValid = !password.isEmpty();


            if (!nicknameValid) {
                fieldNickName.setError("El email es inválido");
            } else {
                fieldNickName.setError(null);
                fieldNickName.setErrorEnabled(false);
            }
            if (!firstNameValid) {
                fieldPassword.setError("Campo requerido");
            } else {
                fieldPassword.setError(null);
                fieldPassword.setErrorEnabled(false);
            }
            if (!birthdayValid) {
                fieldPassword.setError("Campo requerido");
            } else {
                fieldPassword.setError(null);
                fieldPassword.setErrorEnabled(false);
            }
            if (!lastNameValid) {
                fieldPassword.setError("Campo requerido");
            } else {
                fieldPassword.setError(null);
                fieldPassword.setErrorEnabled(false);
            }

            if (!passwordValid) {
                fieldPassword.setError("Campo requerido");
            } else {
                fieldPassword.setError(null);
                fieldPassword.setErrorEnabled(false);
            }

            if (nicknameValid && firstNameValid && lastNameValid && birthdayValid && passwordValid){
                SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_PATTERN);

                Date birthdayDate = null;
                try {
                    birthdayDate = dateFormatter.parse(birthday);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                User user = new User(nickname, firstName, lastName, height, birthdayDate);
                user.setPassword(password);

                AuthController controller = new AuthController(view.getContext());

                controller.register(user);
            }else{
                Toast.makeText(view.getContext(), "Campos inválidos", Toast.LENGTH_SHORT).show();
            }







        });
    }
}