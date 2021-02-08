package com.fadhlyaulia.gedbook

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val savedLogin = getSharedPreferences("Login", Context.MODE_PRIVATE)
        val editSavedLogin = savedLogin.edit()
        if (savedLogin.getString("Status","Off")=="On"){
            startActivity(Intent(this, MainActivity::class.java))
        }
        val editUsername:EditText = findViewById(R.id.login_username)
        val editPassword: EditText = findViewById(R.id.password_login)
        val btnlogin : Button = findViewById(R.id.btn_login)
        val btnregister: Button = findViewById(R.id.btnregister)
        val userDataHelper = DataHelper(this)
        btnlogin.setOnClickListener {
            var emailku = editUsername.text.toString()
            var passku = editPassword.text.toString()
            var cekLogin = userDataHelper.cekLogin(emailku, passku)
           if (cekLogin=="1"){
               editSavedLogin.putString("Email", emailku)
               editSavedLogin.putString("Password",passku)
               editSavedLogin.putString("Status", "on")
               editSavedLogin.commit()

               val intent = Intent(this, MainActivity::class.java)
               startActivity(intent)
           } else {
               val toast: Toast = Toast.makeText(applicationContext, "Gagal Login", Toast.LENGTH_SHORT)
               toast.show()
           }
        }

        btnregister.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}