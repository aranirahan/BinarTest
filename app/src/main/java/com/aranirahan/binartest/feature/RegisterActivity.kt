package com.aranirahan.binartest.feature

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.aranirahan.binartest.helper.PreferencesHelper
import com.aranirahan.binartest.R
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegisterActivity : AppCompatActivity() {

    private lateinit var sp: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        sp = PreferencesHelper(this)

        iv_reg.setOnClickListener {

            val email = et_email.text.toString()
            val pass = et_pass.text.toString()
            val passValid = et_pass_valid.text.toString()

            when {
                email.isEmpty() -> toast("Email can't be empty")
                !email.contains("@") || !email.contains(".") -> toast("Email format not right")

                pass.isEmpty() -> toast("Password can't be empty")
                pass.length < 6 -> toast("Minimum pass is 6 character")
                passValid.isEmpty() -> toast("Passwor validation can't be empty")

                pass != passValid -> toast("Password not same")

                else -> {
                    sp.pass = pass
                    sp.email = email
                    sp.isRegister = true
                    toast("Success Register")
                    startActivity<LoginActivity>()
                    finish()
                }
            }
        }
    }
}
