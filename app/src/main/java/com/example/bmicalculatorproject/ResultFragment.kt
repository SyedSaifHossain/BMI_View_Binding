package com.example.bmicalculatorproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bmicalculatorproject.databinding.FragmentResultBinding
import kotlin.text.*

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater,container,false)
        val score = arguments?.getDouble("score")
        binding.score.text = String.format("%.1f",score)
        val category = when(String.format("%.1f",score).toDouble()){

           in 0.0 .. 18.4 -> underweight
           in 18.5 .. 24.9 -> normal
           in 25.0 .. 29.9 -> overweight
           in 30.0 .. 34.9 -> obesity1
           in 35.0 ..  39.9-> obesity2
            else -> obesity3
       }

        binding.category.text = category
        return binding.root
    }
    companion object{
        var underweight = "UNDERWEIGHT"
        var normal = "NORMAL"
        var overweight = "OVERWEIGHT"
        var obesity1 = "OBESITY CLASS 1"
        var obesity2 = "OBESITY CLASS 2"
        var obesity3 = "OBESITY CLASS 3"

    }
}