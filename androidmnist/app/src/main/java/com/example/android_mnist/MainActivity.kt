package com.example.android_mnist

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.example.android_mnist.fragments.InfoFragment
import com.example.android_mnist.fragments.MainFragment
import com.example.android_mnist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainFragment: MainFragment
    private lateinit var infoFragment: InfoFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        changeStatusBarColor(false, R.color.white)
        super.onCreate(savedInstanceState)
        loadFragments()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigateToMainFragment()
        setupBindings()
        val x:Int? = null
        val y = x!!
    }

    private fun setupBindings() {
        binding.navBar.apply {
            inflateMenu(R.menu.nav_menu)
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.action_draw_tab -> navigateToMainFragment()
                    R.id.action_info_tab -> navigateToInfoFragment()
                }
                true
            }
            setOnItemReselectedListener {  }
        }
    }

    private fun loadFragments() {
        mainFragment = MainFragment()
        infoFragment = InfoFragment()
    }

    private fun navigateToMainFragment() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_frame, mainFragment)
            commit()
        }
    }

    private fun navigateToInfoFragment() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_frame, infoFragment)
            commit()
        }
    }

    private fun changeStatusBarColor(isBlack: Boolean, color: Int) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        if (isBlack) {
            window.statusBarColor = color
            window.decorView.systemUiVisibility = 0
        } else {
            window.statusBarColor = Color.WHITE
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    override fun onBackPressed() {
        if (binding.navBar.selectedItemId == R.id.action_info_tab) {
            binding.navBar.selectedItemId = R.id.action_draw_tab
        }
        else super.onBackPressed()
    }
}