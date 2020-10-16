package com.kpe.foodaway.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.kpe.foodaway.FoodStuff
import com.kpe.foodaway.R

class SplashActivity : AppCompatActivity() {
    val SPLASH_DISPLAY_LENGTH = 3000


    val prefManager = FoodStuff.instance!!.preferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            if (prefManager.isFirstTimeLaunch) {
                gotoWalkThrough()
            } else {
                goToMainActivity()
            }
        }, 5000)
    }

    private fun gotoWalkThrough() {
        val myIntent = Intent(this, WalkThrough::class.java)
        this.startActivity(myIntent)
    }

    private fun goToMainActivity() {
        val myIntent = Intent(this, MainActivity::class.java)
        this.startActivity(myIntent)
    }


}