package com.example.android_mnist.fragments

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_mnist.databinding.FragmentMainBinding
import java.io.ByteArrayOutputStream

class MainFragment: Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBindings()
    }

    private fun setupBindings() {

        binding.clearButton.setOnClickListener {
            binding.canvasView.clear()
        }

        binding.materialButton.setOnClickListener {
            binding.canvasView.getBitMap()
        }
    }

}