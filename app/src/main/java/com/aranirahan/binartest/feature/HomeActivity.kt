package com.aranirahan.binartest.feature

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.aranirahan.binartest.model.Android
import com.aranirahan.binartest.adapter.AndroidAdapter
import com.aranirahan.binartest.R
import com.aranirahan.binartest.helper.PreferencesHelper
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.*

class HomeActivity : AppCompatActivity() {

    private lateinit var sp: PreferencesHelper

    private var androidList = mutableListOf<Android>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        sp = PreferencesHelper(this)

        androidList.apply {
            add(Android("(No codename)", "1.0"))
            add(Android("Petit Four", "1.1"))
            add(Android("Cupcake", "1.5"))
            add(Android("Donut", "1.6"))
            add(Android("Eclair", "2.0 – 2.1"))
            add(Android("Froyo", "2.2 – 2.2.3"))
            add(Android("Gingerbread", "2.3 – 2.3.7"))
            add(Android("Honeycomb", "3.0 – 3.2.6"))
            add(Android("Ice Cream Sandwich", "4.0 – 4.0.4"))
            add(Android("Jelly Bean", "4.1 – 4.3.1"))
            add(Android("KitKat", "4.4 – 4.4.4"))
            add(Android("Lollipop", "5.0 – 5.1.1"))
            add(Android("Marshmallow", "6.0 – 6.0.1"))
            add(Android("Nougat", "7.0 – 7.1.2"))
            add(Android("Oreo", "8.0 – 8.1"))
            add(Android("Pie", "9.0"))
        }

        rv_android.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = AndroidAdapter(androidList) {
                toast("Your choice is $it")
            }
        }

        fab_out.setOnClickListener {
            alert("Are you sure to log out?") {
                yesButton {
                    sp.isLogin = false
                    startActivity<LoginActivity>()
                    finish()
                }
                noButton {

                }
            }.show()
        }
    }
}
