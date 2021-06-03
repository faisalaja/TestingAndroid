package com.koanba.testingandroid.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.koanba.testingandroid.R
import com.koanba.testingandroid.databinding.ActivityAuthBinding
import com.koanba.testingandroid.ui.MainViewModel
import com.koanba.testingandroid.ui.list.MainActivity

class AuthActivity : AppCompatActivity() {
    private lateinit var authBinding: ActivityAuthBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        authBinding = ActivityAuthBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setContentView(authBinding.root)

        authBinding.btnAction.setOnClickListener {
            val emailView = authBinding.authInputEmail.text.toString()
            val passwordView = authBinding.authInputPassword.text.toString()

            when {
                emailView.isNullOrEmpty() -> {
                    authBinding.authInputEmail.error = getString(R.string.err_null_email)
                }
                passwordView.isNullOrEmpty() -> {
                    authBinding.authInputPassword.error = getString(R.string.err_null_password)
                }
                emailView.isNotEmpty() && passwordView.isNotEmpty() -> {
                    authBinding.progressBar.visibility = View.VISIBLE
                    viewModel.auth(emailView, emailView)
                }
                else -> {
                    showSnackBar(getString(R.string.err_null_account))
                }
            }
        }

        viewModel.authResponse.observe(this, {
            authBinding.progressBar.visibility = View.VISIBLE

            if (it.token.isNotEmpty() && it.error.isNullOrEmpty()) {
                startActivity(Intent(this, MainActivity::class.java))
            }
        })

        viewModel.msgError.observe(this, { msg ->
            showSnackBar(msg)
        })
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(window.decorView.rootView, message, Snackbar.LENGTH_SHORT).show()
    }
}