package com.certified.zuritask45

import android.content.Context

class DummyData(private val context: Context) {

    fun getFacts(): List<FactModel> = listOf(
        FactModel(
            name = context.getString(R.string.kotlin),
            logo = R.drawable.kotlin_logo,
            fact = context.getString(R.string.kotlin_fact)
        ),
        FactModel(
            name = context.getString(R.string.java),
            logo = R.drawable.java_logo,
            fact = context.getString(R.string.java_fact)
        ),
        FactModel(
            name = context.getString(R.string.python),
            logo = R.drawable.python_logo,
            fact = context.getString(R.string.python_fact)
        ),
        FactModel(
            name = context.getString(R.string.java_script),
            logo = R.drawable.java_script_logo,
            fact = context.getString(R.string.java_script_fact)
        ),
        FactModel(
            name = context.getString(R.string.swift),
            logo = R.drawable.swift_logo,
            fact = context.getString(R.string.swift_fact)
        )
    )
}