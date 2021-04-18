package com.example.nytimes.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nytimes.R;

public class MakeAccountActivity extends AppCompatActivity {
    private TextView Notnow;
    private  Button account;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_account);
        Notnow=findViewById(R.id.btnNotNow);
        account=findViewById(R.id.btnFreeAccount);
        Notnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MakeAccountActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MakeAccountActivity.this,SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}