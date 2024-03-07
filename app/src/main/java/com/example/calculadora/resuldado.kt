package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class resuldado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resuldado)
        setSupportActionBar(findViewById(R.id.toolbar))
        val montante = intent.getDoubleExtra("montante",0.0)
        val juros = intent.getDoubleExtra("juros",0.0)
        val parcela = intent.getDoubleExtra("parcela",0.0)
        val mudarmontante = findViewById<TextView>(R.id.montante)
        val mudarjuros = findViewById<TextView>(R.id.juros)
        val mudarparcela = findViewById<TextView>(R.id.parcela)
        mudarmontante.setText(montante.toString())
        mudarjuros.setText(juros.toString())
        mudarparcela.setText(parcela.toString())

    }


}