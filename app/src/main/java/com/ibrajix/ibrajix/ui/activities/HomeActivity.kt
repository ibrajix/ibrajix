/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.ibrajix.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ibrajix.ibrajix.databinding.ActivityHomeBinding
import com.ibrajix.ibrajix.utils.Utility.viewBinding
import com.skydoves.transformationlayout.TransformationCompat
import com.skydoves.transformationlayout.onTransformationStartContainer

class HomeActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityHomeBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {

        onTransformationStartContainer()

        super.onCreate(savedInstanceState)

        @Suppress("DEPRECATION") //until I find a simpler and better way of doing this
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        setContentView(binding.root)

        initView()

    }

    private fun initView(){

        //on click button, go to container activity, which houses the fragments
        binding.btnNext.setOnClickListener {
            val intent = Intent(this, ContainerActivity::class.java)
            TransformationCompat.startActivity(binding.transformationLayout, intent)
        }

    }
}