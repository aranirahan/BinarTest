package com.aranirahan.binartest.feature

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.aranirahan.binartest.helper.PreferencesHelper
import com.aranirahan.binartest.R
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity() {

    private lateinit var sp: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sp = PreferencesHelper(this)

        iv_login.setOnClickListener {

            val email = et_email.text.toString()
            val pass = et_pass.text.toString()

            when {
                email.isEmpty() -> toast("Email can't be empty")
                pass.isEmpty() -> toast("Password can't be empty")
                !email.equals(sp.email, ignoreCase = true) -> toast("Wrong Email")
                pass != sp.pass -> toast("Wrong Password")

                else -> {
                    sp.isLogin = true
                    toast("Success Login")
                    startActivity<HomeActivity>()
                    finish()
                }
            }
        }

        tv_or_reg.setOnClickListener { startActivity<RegisterActivity>() }
    }
}
