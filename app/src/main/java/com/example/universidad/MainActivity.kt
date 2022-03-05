package com.example.universidad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.URLUtil
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mensaje = findViewById<EditText>(androidx.appcompat.R.id.message)
        val submit = findViewById<FloatingActionButton>(R.id.fab)

        submit.setOnClickListener {
            val mensaje = mensaje.text.toString()
            sendMessage(mensaje);
        }
    }
    fun sendMessage(message: String){
        val intent = Intent(Intent.ACTION_SEND)
        intent.type= "text/plain"
        intent.setPackage("com.Whatsapp")
        intent.putExtra(Intent.EXTRA_TEXT, message)

        if(intent.resolveActivity(packageManager) == null) {
            Toast.makeText(this, "Primero instala WhatsApp", Toast.LENGTH_SHORT).show()
            return
        }
        startActivity(intent)
    }

    fun irOferta(view: View){
        val intent = Intent(this, oferta::class.java)
        startActivity(intent)
    }
    fun irLogin(view: View){
        val intent = Intent(this, Login::class.java)
        startActivity(intent)


}}