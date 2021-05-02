package com.certified.zuritask45

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.certified.zuritask45.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    var binding: ActivityLoginBinding? = null

    companion object {
        const val email = "achiagasamson5@gmail.com"
        const val password = "99.9%Pass"
    }

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
                        etPassword.text.toString().trim() != ""
                    ) {
                        if (etEmail.text.toString().trim() == email &&
                            etPassword.text.toString().trim() == password
                        ) {
                            etPasswordLayout.error = null
                            etEmailLayout.error = null
                            progressBar.visibility = View.VISIBLE
                            val handler = Handler(Looper.myLooper()!!)
                            handler.postDelayed({
                                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                                finish()
                            }, 3000L)
                        } else {
                            etPasswordLayout.error = getString(R.string.error)
                            etEmailLayout.error = getString(R.string.error)
                        Toast.makeText(
                            this@LoginActivity,
                            getString(R.string.wrong_email_or_password),
                            Toast.LENGTH_LONG
                        ).show()
                        }
                    } else {
                        etPasswordLayout.error = getString(R.string.required)
                        etEmailLayout.error = getString(R.string.required)
                    }
                }
            }
        }
    }
}