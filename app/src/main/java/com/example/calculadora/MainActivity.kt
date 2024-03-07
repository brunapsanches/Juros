package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import kotlin.math.pow


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(findViewById(R.id.toolbar2))
        setContentView(R.layout.activity_main)
    }

    fun simples(view: View) {
        val Botaoano = findViewById<RadioButton>(R.id.radioano)
        val Botaomes = findViewById<RadioButton>(R.id.radiomes)
        val valor = findViewById<EditText>(R.id.valorfinan)
        val taxa = findViewById<EditText>(R.id.taxa)
        val tempo = findViewById<EditText>(R.id.tempo)
        var nvalor = valor?.text.toString().toDouble()
        var ntaxa = taxa?.text.toString().toDouble()
        var ntempo = tempo?.text.toString().toDouble()
        if (Botaoano.isChecked) {
            var taxadeci = ntaxa/100.0
            var taxaAA= taxadeci/12
            var montante = nvalor + (nvalor * taxaAA * ntempo)
            var totaljuros = montante - nvalor
            var valorparcela = montante/ntempo
            Toast.makeText(this, "$montante", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, resuldado::class.java).apply {
                putExtra("montante", montante)
                putExtra("juros", totaljuros)
                putExtra("parcela", valorparcela)

            }
            startActivity(intent)
        }
        if (Botaomes.isChecked){
            var taxaAA= ntaxa/100
            var montante = nvalor + (nvalor * taxaAA * ntempo)
            var totaljuros = montante - nvalor
            var valorparcela = montante/ntempo

            val intent = Intent(this, resuldado::class.java).apply {
                putExtra("montante", montante)
                putExtra("juros", totaljuros)
                putExtra("parcela", valorparcela)

            }
            startActivity(intent)
        }

    }

    fun composto(view: View) {
        val Botaoano = findViewById<RadioButton>(R.id.radioano)
        val Botaomes = findViewById<RadioButton>(R.id.radiomes)
        val valor = findViewById<EditText>(R.id.valorfinan)
        val taxa = findViewById<EditText>(R.id.taxa)
        val tempo = findViewById<EditText>(R.id.tempo)
        var nvalor = valor?.text.toString().toDouble()
        var ntaxa = taxa?.text.toString().toDouble()
        var ntempo = tempo?.text.toString().toDouble()
        if (Botaoano.isChecked) {
            var taxadeci = ntaxa/100.0
            var taxaAA= Math.pow(1+taxadeci,(1 /12.0))-1
            var montante = nvalor * (1.0 + taxaAA).pow(ntempo)
            var totaljuros = montante - nvalor
            var valorparcela = montante/ntempo
            Toast.makeText(this, "$montante", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, resuldado::class.java).apply {
                putExtra("montante", montante)
                putExtra("juros", totaljuros)
                putExtra("parcela", valorparcela)

            }
            startActivity(intent)
        }
        if (Botaomes.isChecked){
            var montante = nvalor * (1.0+ntaxa).pow(ntempo)
            var totaljuros = montante - nvalor
            var valorparcela = montante/ntempo
            Toast.makeText(this, "$montante", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, resuldado::class.java).apply {
                putExtra("montante", montante)
                putExtra("juros", totaljuros)
                putExtra("parcela", valorparcela)

            }
            startActivity(intent)
        }
    }
}
