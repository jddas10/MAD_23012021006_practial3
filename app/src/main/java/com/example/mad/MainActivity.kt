package com.example.mad

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast  // ✅ Toast ke liye import
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.net.Uri

import android.widget.Button
import android.annotation.SuppressLint
import android.provider.AlarmClock
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.text.parseAsHtml


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity.kt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

       // aa code login button ne connect kare .
        val mainLoginButton = findViewById<Button>(R.id.btnLogin)
        mainLoginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
       val sendButton = findViewById<Button>(R.id.btnBrowse)
        val EditURl = findViewById<EditText>(R.id.etWebUrl)
        sendButton.setOnClickListener {
            var url = EditURl.text.toString().trim()
            val intent = Intent (Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        val phoneno = findViewById<EditText>(R.id.etPhoneNo)
        val call = findViewById<Button>(R.id.btnCall)
        call.setOnClickListener {
            val call1 = phoneno.text.toString()
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$call1"))
            startActivity(intent)
        }
        val callLogButton = findViewById<Button>(R.id.btnCallLog)

        callLogButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = android.provider.CallLog.Calls.CONTENT_URI
            startActivity(intent)
        }
        val galleryButton = findViewById<Button>(R.id.btnGallery)

        galleryButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.type = "image/*"
            startActivity(intent)
        }
        val cameraButton = findViewById<Button>(R.id.btnCamera)

        cameraButton.setOnClickListener {
            val intent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }


        val alarmButton = findViewById<Button>(R.id.btnAlarm)

        alarmButton.setOnClickListener {
            val intent = Intent(AlarmClock.ACTION_SHOW_ALARMS)
            startActivity(intent)
        }





    }


    private fun showMessege(msg: String) {
        Log.d(TAG, msg)  // Logcat me message
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


    override fun onStart() {
        showMessege("JDDAS:)")
        super.onStart()
    }




    }

