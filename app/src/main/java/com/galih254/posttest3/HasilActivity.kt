package com.galih254.posttest3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.galih254.posttest3.databinding.ActivityHasilBinding

class HasilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHasilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHasilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get data from Intent
        val fullName = intent.getStringExtra(DATA_FULLNAME)
        val username = intent.getStringExtra(DATA_USERNAME)
        val age = intent.getStringExtra(DATA_AGE)
        val email = intent.getStringExtra(DATA_EMAIL)
        val gender = intent.getStringExtra(DATA_GENDER)

        // Set the text for each TextView
        binding.apply {
            tvFullName.text = "Full Name: $fullName"
            tvUsername.text = "Username: $username"
            tvAge.text = "Age: $age"
            tvEmail.text = "Email: $email"
            tvGender.text = "Gender: $gender"
        }
    }

    // Companion object to hold the keys for Intent data
    companion object {
        const val DATA_FULLNAME = "data_fullname"
        const val DATA_USERNAME = "data_username"
        const val DATA_AGE = "data_age"
        const val DATA_EMAIL = "data_email"
        const val DATA_GENDER = "data_gender"
    }
}