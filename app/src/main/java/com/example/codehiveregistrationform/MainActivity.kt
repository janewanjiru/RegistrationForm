package com.example.codehiveregistrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var etName: EditText
    lateinit var etDob: EditText
    lateinit var etEmail: EditText
    lateinit var etIdNumber: EditText
    lateinit var etPhoneNumber: EditText
    lateinit var btnRegister: Button
    lateinit var spNationality:Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
        buttonListener()
    }
    fun castViews(){
        etName=findViewById(R.id.etName)
        etDob=findViewById(R.id.etD_O_B)
        spNationality=findViewById(R.id.spNationality)
        etEmail=findViewById(R.id.etEmail)
        etIdNumber=findViewById(R.id.etIdNumber)
        etPhoneNumber=findViewById(R.id.etPhoneNumber)
        btnRegister=findViewById(R.id.btnRegister)
        val nationalities = arrayOf("Kenyan", "Rwandan", "Southsudanese", "Ugandan")
        val nationalityAdapter = ArrayAdapter<String>(
            baseContext, android.R.layout.simple_spinner_item,
            nationalities
        )
        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spNationality.adapter = nationalityAdapter


    }

    fun buttonListener() {
        btnRegister.setOnClickListener {
            var name = etName.text.toString()
            if (name.isEmpty()) {
                etName.setError("name is required")

            }
            var dob = etDob.text.toString()
            if (dob.isEmpty()) {
                etDob.setError("dob is required")
            }
            var natioanlity = spNationality.selectedItem.toString()
            var email = etEmail.text.toString()
            var idNumber = etIdNumber.toString()
            var phoneNumber = etPhoneNumber.text.toString()

            Toast.makeText(baseContext, name, Toast.LENGTH_LONG).show()
            var details = Details(
                name = name,
                dob = dob,
                nationality = natioanlity,
                phoneNumber = phoneNumber,
                idNumber = idNumber,
                email= email
            )


            Toast.makeText(baseContext, details.toString(), Toast.LENGTH_LONG).show()
            val intent = Intent(baseContext, coursesActivity::class.java)
            startActivity(intent)

        }

    }
}

data class Details(var name:String,var dob:String,var nationality:String,var phoneNumber:String,var email:String,var idNumber:String)

