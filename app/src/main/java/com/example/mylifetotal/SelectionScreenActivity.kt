package com.example.mylifetotal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SelectionScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment = SelectionScreenFragment()
        fragmentTransaction.add(R.id.activity_main, fragment)
        fragmentTransaction.commit()
    }
}