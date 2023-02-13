package com.example.test_project_001


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loginEt = findViewById<EditText>(R.id.login_et)
        val authorizationPassEt = findViewById<EditText>(R.id.password_et)
        val authorizationButton = findViewById<Button>(R.id.authorize_btn)
        val registrationButton = findViewById<TextView>(R.id.registration_btn)
        val aboutApplicationTextView = findViewById<TextView>(R.id.about_application_tv)
        val ticTacToeButton = findViewById<Button>(R.id.tic_tac_toe_btn)
        registrationButton.setOnClickListener() {
            printInfo("User clicked on Registration button")
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
        authorizationButton.setOnClickListener() {
            printInfo("User authorized: ${loginEt.text}")
            // TODO: Add a function to send user to another screen
        }
        loginEt.addTextChangedListener {
            printInfo("User is typing login details")
            authorizationButton.isEnabled =
                loginEt.text.isNotEmpty() && authorizationPassEt.text.isNotEmpty()

        }
        authorizationPassEt.addTextChangedListener {
            printInfo("User is typing password")
            authorizationButton.isEnabled =
                loginEt.text.isNotEmpty() && authorizationPassEt.text.isNotEmpty()
        }
        aboutApplicationTextView.setOnClickListener() {
            printInfo("User clicked on Registration Button")
            startActivity(Intent(this, AboutApplicationActivity::class.java))
        }
        ticTacToeButton.setOnClickListener() {
            printInfo("User clicked on Tic Tac Toe Button")
            startActivity(Intent(this, TicTacToeActivity::class.java))
        }
    }

    override fun onPause() {
        super.onPause()
        printInfo("The application is on pause")
    }

    fun printInfo(
        anyString: String
    ) {
        println("!!! ${anyString}")
    }

    fun printInfo(
        anyString: List<String>
    ) {
        println("!!! ${anyString}")
    }


    fun showMessage(text:String) {

        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }


}

//const val nameSize = 6
///**
//Day And Month of New Year
// **/
//const val DAY_AND_MONTH = "01 01"
//
///**
// * Closest Star to Earth
// */
//const val CLOSEST_STAR = "Sun"