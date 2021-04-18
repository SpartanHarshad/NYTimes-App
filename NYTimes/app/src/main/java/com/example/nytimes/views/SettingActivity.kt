package com.example.nytimes.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.nytimes.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val firebaseAuth = FirebaseAuth.getInstance()
        val user = firebaseAuth.getCurrentUser()
        tvDisplayEmail.setText(user!!.getEmail())

        tvLogOut.setOnClickListener(View.OnClickListener {
            firebaseAuth.signOut()
            startActivity(Intent(this@SettingActivity, LoginActivity::class.java))
            finish()
        })
    }
}