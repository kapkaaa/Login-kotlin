package com.example.learning2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learning2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val  username: String = "kafka"
    private val password: String = "password"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.button.setOnClickListener{

            if(binding.txtUsn.text.toString().isNullOrBlank()) {
                Toast.makeText(this, "Mohon isi kolom username", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if (binding.txtUsn.text.toString() != username) {
                Toast.makeText(this, "Username tidak sesuai", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if(binding.txtPw.text.toString().isNullOrBlank()) {
                Toast.makeText(this, "Mohon isi kolom Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if(binding.txtPw.text.toString() != password) {
                Toast.makeText(this, "Password tidak sesuai", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if(binding.txtUsn.text.toString() == username && binding.txtPw.text.toString() == password) {
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomePage::class.java)
                startActivity(intent)
            }
        }
    }
}