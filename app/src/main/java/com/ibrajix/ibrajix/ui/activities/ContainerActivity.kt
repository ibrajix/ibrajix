/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.ibrajix.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.ibrajix.ibrajix.R
import com.ibrajix.ibrajix.databinding.ActivityContainerBinding
import com.ibrajix.ibrajix.utils.Utility.viewBinding
import com.ibrajix.ibrajix.utils.Utility.whiteStatusBar
import com.skydoves.transformationlayout.TransformationAppCompatActivity

class ContainerActivity : TransformationAppCompatActivity() {

    private val binding by viewBinding(ActivityContainerBinding::inflate)
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        whiteStatusBar()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }

    private fun initView(){
        setUpBottomNavigation()
    }

    private fun setUpBottomNavigation(){

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHost.navController

        binding.bottomNavigation.setupWithNavController(navController)


    }

    override fun onBackPressed() {

        val navControl = findNavController(R.id.nav_host_fragment)

        // Check if the current destination is actually the start sestination (Home screen)
        if (navControl.graph.startDestination == navController.currentDestination?.id)
        {
            val exitIntent = Intent(Intent.ACTION_MAIN)
            exitIntent.addCategory(Intent.CATEGORY_HOME)
            exitIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(exitIntent)

        }
        else {
            super.onBackPressed()
        }

    }

}