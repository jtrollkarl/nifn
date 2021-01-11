package com.example.finn.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.finn.R

class SingleFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_fragment)
        setupFragment()
    }

    private fun setupFragment() {
        val fragment = AdListFragment()
        supportFragmentManager.takeIf { it.findFragmentById(R.id.fragment_container) == null }
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, fragment)
            ?.commit()
    }

}