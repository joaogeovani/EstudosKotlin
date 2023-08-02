package com.example.estudoskotlin

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class Main : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "Bem vindo(a)", Toast.LENGTH_SHORT).show()
    }
}