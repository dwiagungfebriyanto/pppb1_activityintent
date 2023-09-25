package com.example.activityintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.activityintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            editTextUsername.setSingleLine(true)
            editTextPassword.setSingleLine(true)

            btnRegister.setOnClickListener {
                val intentToHomepageActivity = Intent(this@MainActivity, HomepageActivity::class.java)
                val checked = checkboxTc.isChecked

                val username = editTextUsername.text.toString()
                val email = editTextEmail.text.toString()
                val phone = editTextPhone.text.toString()
                val password = editTextPassword.text.toString()

                val bundle = Bundle()
                bundle.putString("username", username)
                bundle.putString("email", email)
                bundle.putString("phone", phone)
                bundle.putString("password", password)
                intentToHomepageActivity.putExtras(bundle)

                if (username == "" || email == "" || phone == "" || password == "") {
                    Toast.makeText(this@MainActivity, "Please make sure that all forms are filled in!", Toast.LENGTH_SHORT).show()
                } else {
                    if (!checked) {
                        Toast.makeText(this@MainActivity, "Please agree to our terms and conditions!", Toast.LENGTH_SHORT).show()
                    } else {
                        startActivity(intentToHomepageActivity)
                    }
                }

            }
        }
    }
}