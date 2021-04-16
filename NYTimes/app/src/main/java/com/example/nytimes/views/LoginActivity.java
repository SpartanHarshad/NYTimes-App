package com.example.nytimes.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nytimes.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText EmailEtt, PassworddEt;
    private Button SignInButton;
    private TextView SignUpTv;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        EmailEtt = findViewById(R.id.etLoginEmail);
        PassworddEt = findViewById(R.id.etLoginPassword);
        SignInButton = findViewById(R.id.btnLogin);
        SignUpTv = findViewById(R.id.CreateAccount);
        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();

            }
        });
        SignUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    private void Login(){
        String Email = EmailEtt.getText().toString();
        String password = PassworddEt.getText().toString();

        if (TextUtils.isEmpty(Email)) {
            EmailEtt.setError("Enter your email");
            return;
        } else if (TextUtils.isEmpty(password)) {
            PassworddEt.setError("Enter your password");
            return;
        }
        firebaseAuth.signInWithEmailAndPassword(Email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity.this," Successfully registered", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent( LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this," Sign up fail", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
    private boolean isValidEmail(CharSequence target){
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());

    }
}