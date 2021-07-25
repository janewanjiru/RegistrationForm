package com.example.codehiveregistrationform

import androidx.appcompat.app.ppCompatActivity
import android.os.Bundle

class loginActivity : AppCompatActivity(loginRequest){
    lateinit var email: EditText
//    lateinit var etpassword: EditText
    lateinit var btnlogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun setViews() {
        email = findViewById(R.id.etemmail)
//        etpassword = findViewById(R.id.etpasswrd)
        btnlogin = findViewById(R.id.btnlogin)
    }

    fun clickLogin() {
        var error = false
        btnlogin.setOnClickListener {
            var etemail = email.text.toString()
            if (etemail.isEmpty())
                email.setError("Email required")

//            var etpassword = email.text.toString()
//            if (etpassword.isEmpty())
//                email.setError("Password required")

        }
        var logoinRequest = LoginRequest(
            email = "Email",
//            password = "password"
        )

    }

    var retrofit = ApiClient.buildApiClient(ApiInteface::class.java)
    var request = retrofit.logiStudent(loginRequest).enqueue(object : Callback<LoginResponce> {
        override fun onResponse(call: Call<LoginResponce>, response: Response<LoginResponce>) {
            if (response.isSuccessful)
                Toast.makeText(baseContext, "Login Successful", Toast.LENGTH_LONG)
                    .show()
        }

        override fun onFailure(call: Call<LoginResponce>, t: Throwable) {
            Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
        }
    })
}