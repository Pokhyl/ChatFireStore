package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Chat : AppCompatActivity() {
    lateinit var firebaseUser:FirebaseUser
    private lateinit var auth: FirebaseAuth
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
    }

    override fun onStart() {
        super.onStart()
        auth = Firebase.auth
        firebaseUser = auth.currentUser!!
        if (firebaseUser == null) {
            var intent = Intent(this, MainActivity::class.java)
        }
        val massage = hashMapOf(
            "first" to firebaseUser.uid,
            "last" to "LAST",
            "born" to "BORN"
        )

// Add a new document with a generated ID
        db.collection("massages")
            .add(massage)
            .addOnSuccessListener { documentReference ->

            }
            .addOnFailureListener { e ->

            }
    }
}