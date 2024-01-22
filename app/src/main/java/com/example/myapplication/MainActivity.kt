package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.location.Location
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.FusedLocationProviderClient

class MainActivity : AppCompatActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)



    // Find views by ID
        val myButton = findViewById<Button>(R.id.myButton)

        // Atmen Icon
        val ivIcon = findViewById<ImageView>(R.id.ivIcon)
        val rotation = AnimationUtils.loadAnimation(this, R.anim.atmen)
        ivIcon.startAnimation(rotation)

        // Set OnClickListener
        myButton.setOnClickListener{
            // Show Signed-In-Message
            Toast.makeText(this, getString(R.string.signed_in), Toast.LENGTH_LONG).show()

            // Open ListActivity
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }
}