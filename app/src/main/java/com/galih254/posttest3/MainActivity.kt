package com.galih254.posttest3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.galih254.posttest3.HasilActivity.Companion.DATA_AGE
import com.galih254.posttest3.HasilActivity.Companion.DATA_EMAIL
import com.galih254.posttest3.HasilActivity.Companion.DATA_FULLNAME
import com.galih254.posttest3.HasilActivity.Companion.DATA_GENDER
import com.galih254.posttest3.HasilActivity.Companion.DATA_USERNAME
import com.galih254.posttest3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            // Get text from all fields
            val fullName = binding.etFullName.text.toString()
            val username = binding.etUsername.text.toString()
            val age = binding.etAge.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val confirmPassword = binding.etConfirmPassword.text.toString()

            // Get selected gender
            val gender = if (binding.rbLaki.isChecked) {
                "Laki-laki"
            } else {
                "Perempuan"
            }

            // Simple validation
            if (fullName.isEmpty() || username.isEmpty() || age.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Create Intent to start HasilActivity
            val intent = Intent(this, HasilActivity::class.java).apply {
                putExtra(DATA_FULLNAME, fullName)
                putExtra(DATA_USERNAME, username)
                putExtra(DATA_AGE, age)
                putExtra(DATA_EMAIL, email)
                putExtra(DATA_GENDER, gender)
            }
            startActivity(intent)
        }
    }
}