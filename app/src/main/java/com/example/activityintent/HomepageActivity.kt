package com.example.activityintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityintent.databinding.ActivityHomepageBinding

class HomepageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            val intent = intent
            val bundle = intent.extras
            val username = bundle?.getString("username")
            val email = bundle?.getString("email")
            val phone = bundle?.getString("phone")
            val password = bundle?.getString("password")

            txtRegisterInfo.text = "Welcome $username\nYour $email has been activated\nYour $phone has been registered"

            btnLogout.setOnClickListener {
                val intentToMainActivity = Intent(this@HomepageActivity, MainActivity::class.java)
                startActivity(intentToMainActivity)
            }
        }
    }
}