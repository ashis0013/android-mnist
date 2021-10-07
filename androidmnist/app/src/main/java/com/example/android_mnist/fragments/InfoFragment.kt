package com.example.android_mnist.fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.android_mnist.R
import com.example.android_mnist.databinding.FragmentInfoBinding
import com.google.android.material.appbar.MaterialToolbar

class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private lateinit var toolbar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  FragmentInfoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolBar()
        setupBindings()
    }

    private fun setupBindings() {
        binding.modelInfoContainer.setOnClickListener {
            binding.modelInfo.visibility.apply {
                if (this == View.VISIBLE) binding.modelInfo.visibility = View.GONE
                else binding.modelInfo.visibility = View.VISIBLE
            }
        }

        binding.instaIcon.setOnClickListener {
            openBrowser("https://instagram.com/ashis0013")
        }

        binding.fbIcon.setOnClickListener {
            openBrowser("https://facebook.com/paulashis0013")
        }

        binding.gmailIcon.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.fromParts("mailto", "paulashis0013@gmail.com", null)
            startActivity(intent)
        }
    }

    private fun initToolBar() {
        toolbar = binding.infoToolbar
        toolbar.title = "About the App"
        toolbar.setTitleTextColor(Color.WHITE)
        (activity as AppCompatActivity?)?.apply {
            setSupportActionBar(toolbar)
            supportActionBar?.let {
                it.setDisplayHomeAsUpEnabled(true)
                it.setHomeAsUpIndicator(R.drawable.ic_back_arrow)
            }
        }
        toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val inflatedMenu = R.menu.blank_menu
        inflater.inflate(inflatedMenu, menu)
    }

    private fun openBrowser(url: String) {

        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.addCategory(Intent.CATEGORY_BROWSABLE)

        intent.data = Uri.parse(url)
        startActivity(intent)
    }


}