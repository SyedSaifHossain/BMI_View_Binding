package com.example.bmicalculatorproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.bmicalculatorproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        binding.calButton.setOnClickListener{
            val weight = binding.weightEtx.text.toString().toDouble()

            val height = binding.heightEtx.text.toString().toDouble()
            val bmi = weight/(height*height)

            val bundle = bundleOf("score" to bmi)
            findNavController().navigate(R.id.navAction,bundle)
            Toast.makeText(activity,bmi.toString(),Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

}