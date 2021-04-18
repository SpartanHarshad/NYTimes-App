package com.example.nytimes.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nytimes.R;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText EmailEt, PasswordEt, ConfirmPasswordEt;
    private Button SignupButton;
    private TextView SignInTv;
    private FirebaseAuth firebaseAuth;
    private ImageView sign;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();
        EmailEt = findViewById(R.id.etEmail);
        PasswordEt = findViewById(R.id.etPassword);
        ConfirmPasswordEt = findViewById(R.id.etConfirmPassword);
        SignupButton = findViewById(R.id.btnSignUp);
        SignInTv = findViewById(R.id.LoginAccount);
        sign=findViewById(R.id.btnCreateAccountArrow);


        SignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();

            }
        });

sign.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent( SignUpActivity.this,MakeAccountActivity.class);
        startActivity(intent);
        finish();
    }
});
        SignInTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void Register() {
        String Email = EmailEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String confirmpassword = ConfirmPasswordEt.getText().toString();
        if (TextUtils.isEmpty(Email)) {
            EmailEt.setError("Enter your email");
            return;
        } else if (TextUtils.isEmpty(password)) {
            PasswordEt.setError("Enter your password");
            return;

        } else if (TextUtils.isEmpty(confirmpassword)) {
            ConfirmPasswordEt.setError("Enter your password");
            return;

        } else if (!password.equals(confirmpassword)) {
            ConfirmPasswordEt.setError("Different password");
            return;

        } else if (password.length() < 4) {
            PasswordEt.setError("Length should be > 4");
            return;
        } else if (!isValidEmail(Email)) {
            PasswordEt.setError("Invalid email");
            return;
        }
        firebaseAuth.createUserWithEmailAndPassword(Email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(SignUpActivity.this," Successfully registered", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent( SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(SignUpActivity.this," Sign up fail", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
    private boolean isValidEmail(CharSequence target){
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());

    }
}