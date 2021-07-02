package com.unipi.p17172p17168p17164.multiplicationgameadminapp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.animation.AnimationUtils
import com.google.firebase.auth.FirebaseAuth
import com.unipi.p17172.emarket.utils.SnackBarErrorClass
import com.unipi.p17172p17168p17164.multiplicationgameadminapp.R
import com.unipi.p17172p17168p17164.multiplicationgameadminapp.databinding.ActivitySignInBinding


class SignInActivity : BaseActivity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        init()
    }

    private fun init() {
        setupUI()
        setupClickListeners()
    }

    private fun setupUI() {
        binding.apply {
            inputTxtEmail.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    inputTxtLayoutEmail.isErrorEnabled = false
                }

                override fun afterTextChanged(s: Editable?) {}
            })

            inputTxtPassword.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    inputTxtLayoutPassword.isErrorEnabled = false
                }

                override fun afterTextChanged(s: Editable?) {}
            })
        }
    }

    private fun setupClickListeners() {
        binding.apply {
            txtViewForgotPassword.setOnClickListener {
                playButtonPressSound(this@SignInActivity)
                // Launch the forgot password screen when the user clicks on the forgot password text.
                val intent = Intent(this@SignInActivity, ForgotPasswordActivity::class.java)
                startActivity(intent)
            }
            btnSignIn.setOnClickListener {
                playButtonPressSound(this@SignInActivity)
                signInUser()
            }
        }
    }

    private fun signInUser() {
        if (validateFields()) {
            // Show the progress dialog.
            showProgressDialog(this)

            binding.apply {
                // Get the text from editText and trim the space
                val email = inputTxtEmail.text.toString().trim { it <= ' ' }
                val password = inputTxtPassword.text.toString().trim { it <= ' ' }

                // Log-In using FirebaseAuth
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->

                        FirebaseAuth.getInstance()
                        if (task.isSuccessful) {
                            userLoggedInSuccess()
                        }
                        else {
                            // Hide the progress dialog
                            hideProgressDialog()

                            SnackBarErrorClass
                                .make(root, task.exception!!.message.toString())
                                .show()
                        }
                    }
            }
        }
        else
            binding.btnSignIn.startAnimation(AnimationUtils.loadAnimation(this@SignInActivity, R.anim.anim_shake))
    }

    /**
     * A function to notify user that logged in success and get the user details from the FireStore database after authentication.
     */
    private fun userLoggedInSuccess() {

        // Hide the progress dialog.
        hideProgressDialog()

        // Redirect the user to Dashboard Screen after log in.
        goToMainActivity(this@SignInActivity)
        finish()
    }

    private fun validateFields(): Boolean {
        binding.apply {
            return when {
                TextUtils.isEmpty(inputTxtEmail.text.toString().trim { it <= ' ' }) -> {
                    SnackBarErrorClass
                        .make(root, getString(R.string.txt_error_empty_email))
                        .show()
                    inputTxtLayoutEmail.requestFocus()
                    inputTxtLayoutEmail.error = getString(R.string.txt_error_empty_email)
                    false
                }

                TextUtils.isEmpty(inputTxtPassword.text.toString().trim { it <= ' ' }) -> {
                    SnackBarErrorClass
                        .make(root, getString(R.string.txt_error_empty_password))
                        .show()
                    inputTxtLayoutPassword.requestFocus()
                    inputTxtLayoutPassword.error = getString(R.string.txt_error_empty_password)
                    false
                }

                else -> true
            }
        }
    }

    override fun onBackPressed() {
        doubleBackToExit()
    }
}