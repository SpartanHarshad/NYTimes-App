package com.example.nytimes.views

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nytimes.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val firebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener(View.OnClickListener { Login() })
        login.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        })
        CreateAccount.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        })
    }

    private fun Login() {
        val Email: String = etLoginEmail.text.toString()
        val password: String = etLoginPassword.text.toString()
        Log.d("LOG", "Login: $Email  $password")
        if (TextUtils.isEmpty(Email)) {
            etLoginEmail.setError("Enter your email")
            return
        } else if (TextUtils.isEmpty(password)) {
            etLoginPassword.setError("Enter your password")
            return
        }
        firebaseAuth.signInWithEmailAndPassword(Email, password).addOnCompleteListener(this,
            OnCompleteListener<AuthResult?> { task ->
                if (task.isSuccessful) {
                    Toast.makeText(
                        this@LoginActivity,
                        " Successfully registered",
                        Toast.LENGTH_LONG
                    ).show()
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this@LoginActivity, " Sign up fail", Toast.LENGTH_LONG).show()
                }
            })
    }

    private fun isValidEmail(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}