package com.aranirahan.binartest.helper

import android.content.Context
import android.preference.PreferenceManager

class PreferencesHelper(context: Context) {
    companion object {
        private const val PASS = "pass"
        private const val EMAIL = "email"
        private const val IS_LOGIN = "is_login"
        private const val IS_REG = "is_reg"
    }

    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)!!
    var email = preferences.getString(EMAIL, "")
        set(value) = preferences.edit().putString(EMAIL, value).apply()
    var pass = preferences.getString(PASS, "")
        set(value) = preferences.edit().putString(PASS, value).apply()
    var isLogin = preferences.getBoolean(IS_LOGIN, false)
        set(value) = preferences.edit().putBoolean(IS_LOGIN, value).apply()
    var isRegister = preferences.getBoolean(IS_REG, false)
        set(value) = preferences.edit().putBoolean(IS_REG, value).apply()
}