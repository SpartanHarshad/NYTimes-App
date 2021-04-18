package com.example.nytimes.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.nytimes.R
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            Handler().postDelayed({
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()

            }, 3000)
        } else {
            Handler().postDelayed({
                val intent = Intent(this@SplashActivity, MakeAccountActivity::class.java)
                startActivity(intent)
                finish()

            }, 3000)
        }
    }
}