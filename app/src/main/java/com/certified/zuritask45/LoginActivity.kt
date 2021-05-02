package com.certified.zuritask45

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.certified.zuritask45.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    var binding: ActivityLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.apply {
            tvSignup.setOnClickListener(this@LoginActivity)
            tvForgotPassword.setOnClickListener(this@LoginActivity)
            btnLogin.setOnClickListener(this@LoginActivity)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun onClick(v: View?) {
        binding?.apply {
            when (v) {
                tvSignup -> Toast.makeText(
                    this@LoginActivity,
                    getString(R.string.check_back_in_a_bit),
                    Toast.LENGTH_LONG
                ).show()

                tvForgotPassword -> Toast.makeText(
                    this@LoginActivity,
                    getString(R.string.check_back_in_a_bit),
                    Toast.LENGTH_LONG
                ).show()

                btnLogin -> {
                    if (etEmail.text.toString().trim() != "" &&
                        etPassword.text.toString().trim() != "" ) {
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        finish()
                    } else
                        Toast.makeText(
                            this@LoginActivity,
                    getString(R.string.all_fields_are_required),
                    Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}