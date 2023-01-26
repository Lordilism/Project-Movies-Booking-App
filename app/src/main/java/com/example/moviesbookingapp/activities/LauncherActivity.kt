package com.example.moviesbookingapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesbookingapp.R
import kotlinx.android.synthetic.main.activity_launcher.*

class LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        navigateToLogin()
    }

    private fun navigateToLogin() {
        btnGetStarted.setOnClickListener {
            startActivity(LogInActivity.newIntent(this))
        }

    }
}