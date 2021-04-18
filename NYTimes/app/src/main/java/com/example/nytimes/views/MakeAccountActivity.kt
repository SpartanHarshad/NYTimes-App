package com.example.nytimes.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.nytimes.R
import kotlinx.android.synthetic.main.activity_make_account.*

class MakeAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_account)

        btnNotNow.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MakeAccountActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        })

        btnFreeAccount.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MakeAccountActivity, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        })
    }
}