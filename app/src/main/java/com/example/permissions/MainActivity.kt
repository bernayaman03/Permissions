package com.example.permissions

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etTelefon: EditText
    private lateinit var btnKamera: Button
    private lateinit var ivFotograf: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etTelefon = findViewById(R.id.etTelefon)
        btnKamera = findViewById(R.id.btnKamera)
        ivFotograf = findViewById(R.id.ivFotograf)

        btnKamera.setOnClickListener {
            val telNo = etTelefon.text.toString()

            if (telNo.isNotEmpty()) {
                // 1. KAMERAYI AÇ (Sınavda bu Intent ismini sorar!)
                val kameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(kameraIntent, 101)

                // 2. SMS GÖNDER (Direkt uygulamadan gönderir)
                try {
                    val smsManager = SmsManager.getDefault()
                    smsManager.sendTextMessage(telNo, null, "Telefondan fotoğraf çekildi", null, null)
                    Toast.makeText(this, "SMS Gönderildi", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    Toast.makeText(this, "SMS Hatası!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Lütfen numara girin!", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 101 && resultCode == RESULT_OK) {
            // Çekilen fotoğrafı "Bitmap" olarak alıyoruz
            val imageBitmap = data?.extras?.get("data") as Bitmap
            // ImageView'da gösteriyoruz
            ivFotograf.setImageBitmap(imageBitmap)
        }
    }
}