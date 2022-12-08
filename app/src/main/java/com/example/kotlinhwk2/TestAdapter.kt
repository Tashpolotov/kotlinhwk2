package com.example.kotlinhwk2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinhwk2.databinding.ItemBinding

class TestAdapter(val name: ArrayList<Car>, private val onClick: onClick) :RecyclerView.Adapter<TestAdapter.TestViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.bind()
        holder.itemView.setOnClickListener(View.OnClickListener {
            onClick.click(name[position])
        })
    }

    override fun getItemCount(): Int {
        return name.size
    }

    inner class TestViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind() {

            binding.apply {
                val item = name[adapterPosition]
                binding.itemModelTv.text = item.toString()
            }
        }
    }
}