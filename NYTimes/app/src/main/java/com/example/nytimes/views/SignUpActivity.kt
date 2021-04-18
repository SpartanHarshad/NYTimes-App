package com.example.nytimes.views

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nytimes.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnSignUp.setOnClickListener(View.OnClickListener { Register() })

        btnCreateAccountArrow.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@SignUpActivity, MakeAccountActivity::class.java)
            startActivity(intent)
            finish()
        })
        LoginAccount.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        })
    }

    private fun Register() {
        val Email: String = etEmail.getText().toString()
        val password: String = etPassword.getText().toString()
        val confirmpassword: String = etConfirmPassword.getText().toString()
        if (TextUtils.isEmpty(Email)) {
            etEmail.setError("Enter your email")
            return
        } else if (TextUtils.isEmpty(password)) {
            etPassword.setError("Enter your password")
            return
        } else if (TextUtils.isEmpty(confirmpassword)) {
            etConfirmPassword.setError("Enter your password")
            return
        } else if (password != confirmpassword) {
            etConfirmPassword.setError("Different password")
            return
        } else if (password.length < 4) {
            etPassword.setError("Length should be > 4")
            return
        } else if (!isValidEmail(Email)) {
            etPassword.setError("Invalid email")
            return
        }
        firebaseAuth.createUserWithEmailAndPassword(Email, password).addOnCompleteListener(
            this
        ) { task ->
            if (task.isSuccessful) {
                Toast.makeText(this@SignUpActivity, " Successfully registered", Toast.LENGTH_LONG)
                    .show()
                val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this@SignUpActivity, " Sign up fail", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun isValidEmail(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}