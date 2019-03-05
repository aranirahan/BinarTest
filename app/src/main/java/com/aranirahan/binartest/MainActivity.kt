package com.aranirahan.binartest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.aranirahan.binartest.feature.HomeActivity
import com.aranirahan.binartest.feature.LoginActivity
import com.aranirahan.binartest.feature.RegisterActivity
import com.aranirahan.binartest.helper.PreferencesHelper
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private lateinit var sp: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sp = PreferencesHelper(this)

        Handler().postDelayed(
            {
                if (sp.isRegister) {
                    if (sp.isLogin) startActivity<HomeActivity>()
                    else startActivity<LoginActivity>()
                } else {
                    startActivity<RegisterActivity>()
                }
                finish()
            },
            1000
        )
    }
}
