package com.quizapplications.usernamepasswordcredentials;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.quizapplications.usernamepasswordcredentials.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnSignUp.setOnClickListener(v -> {

            checkCredentials();

        });


    }

    private void checkCredentials() {

        String name = binding.etName.getText().toString();
        String email = binding.etEmail.getText().toString();
        String password = binding.etPassword.getText().toString();
        String conformPassword = binding.etConformPassword.getText().toString();


        if (name.isEmpty() || name.length() < 7) {

            showError(binding.etName, "Your username is not valid!");
        }
        else if (email.isEmpty() || !email.contains("@")) {
            showError(binding.etEmail, "Email is not Valid");
        }

        else if (password.isEmpty() || password.length() < 7) {
            showError(binding.etPassword, "Password must be 7 character");
        }

        else if (conformPassword.isEmpty() || !conformPassword.equals(password)) {
            showError(binding.etConformPassword, "Password not match!");
        }


        else {
            Toast.makeText(this, "Signup Successfully", Toast.LENGTH_SHORT).show();
        }


    }

    private void showError(EditText etName, String s) {

        etName.setError(s);
        etName.requestFocus();
    }
}