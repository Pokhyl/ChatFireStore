package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginregister.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
     //   updateUI(currentUser)
        binding.loginButton.setOnClickListener {
            auth.signInWithEmailAndPassword(
                binding.emailEditText.text.toString(),
                binding.passwordEditText.text.toString()
            ).addOnCompleteListener{
                println("sacses")
                var intent = Intent(this,Chat::class.java)
                startActivity(intent)
            }
        }
       binding.registerButton.setOnClickListener{
           auth.createUserWithEmailAndPassword(
               binding.emailEditText.text.toString(),
               binding.passwordEditText.text.toString()
           ).addOnCompleteListener{
               if (it.isSuccessful){
                   println("sacses")
               }
           }
       }
    }
}