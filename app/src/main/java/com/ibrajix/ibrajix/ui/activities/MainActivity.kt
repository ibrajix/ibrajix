/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.ibrajix.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.ibrajix.ibrajix.databinding.ActivityMainBinding
import com.ibrajix.ibrajix.utils.Constants.SPLASH_SCREEN_TIME
import com.ibrajix.ibrajix.utils.Utility.viewBinding
import com.ibrajix.ibrajix.utils.Utility.whiteStatusBar

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        whiteStatusBar()
        setContentView(binding.root)
        initView()

    }

    private fun initView(){

        startAnimation()
        goToNextActivity()

    }

    private fun startAnimation(){

        YoYo.with(Techniques.RotateInDownLeft)
                .duration(3000)
                .repeat(0)
                .playOn(binding.txtIbr)

        YoYo.with(Techniques.RotateInDownRight)
                .duration(3000)
                .repeat(0)
                .playOn(binding.txtJix)

    }

    /**
     * Normally, I don't use this splash screen implementation approach, but since its a hobby portfolio app, I use this just to showcase my animation
     */

    private fun goToNextActivity(){

        //delay for 5 seconds and move to next activity
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()}, SPLASH_SCREEN_TIME)

    }
}