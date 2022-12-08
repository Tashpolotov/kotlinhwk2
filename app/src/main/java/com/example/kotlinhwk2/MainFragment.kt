package com.example.kotlinhwk2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.kotlinhwk2.databinding.FragmentMainBinding

class MainFragment : Fragment(), onClick {


    lateinit var binding: FragmentMainBinding
    var name: ArrayList<Car> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_first, container, false)
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carsName()
        binding.textRv.adapter = TestAdapter(name,this)



    }

    override fun click(model: Car) {
        findNavController().navigate(R.id.secondFragment,  bundleOf("key" to model.info1))
    }

    fun carsName() {

        name.add(Car("tayota"))

    }
}