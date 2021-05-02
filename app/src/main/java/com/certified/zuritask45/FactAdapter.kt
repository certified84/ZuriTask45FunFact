package com.certified.zuritask45

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.certified.zuritask45.databinding.FactItemBinding

class FactAdapter(context: Context, facts: List<FactModel>) :
    ArrayAdapter<FactModel>(context, 0, facts) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val binding = FactItemBinding.inflate(LayoutInflater.from(context), parent, false)
        val fact = getItem(position)
        val view = binding.root

        binding.apply {
            Glide.with(view)
                .load(fact?.logo)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivLogo)
            tvName.text = fact?.name
        }

        view.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(IntentExtras.LANGUAGE_NAME, fact?.name)
            intent.putExtra(IntentExtras.LANGUAGE_LOGO, fact?.logo)
            intent.putExtra(IntentExtras.LANGUAGE_FACT, fact?.fact)
            parent.context.startActivity(intent)
        }

        return view
    }
}