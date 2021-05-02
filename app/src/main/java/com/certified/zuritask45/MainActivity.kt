package com.certified.zuritask45

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.certified.zuritask45.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setUpFact(this)
    }

    private fun setUpFact(context: Context) {
        val dummyData = DummyData(context)
        val adapter = FactAdapter(this, dummyData.getFacts())
        binding?.lvFact?.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}