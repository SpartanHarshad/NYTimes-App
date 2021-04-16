package com.example.nytimes.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nytimes.R
import kotlinx.android.synthetic.main.activity_make_account.*

class MakeAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_account)


        btnFreeAccount.setOnClickListener {
            val intent =Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}