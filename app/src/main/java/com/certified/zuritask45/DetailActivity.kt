package com.certified.zuritask45

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.certified.zuritask45.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private var binding: ActivityDetailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setupFactDetail(this)
    }

    private fun setupFactDetail(context: Context) {
        val intent = intent.extras
        binding?.apply{
            if (intent != null) {
                Glide.with(context)
                    .load(intent.getInt(IntentExtras.LANGUAGE_LOGO))
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(ivLogo)
                tvDetail.text = intent.getString(IntentExtras.LANGUAGE_FACT)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}