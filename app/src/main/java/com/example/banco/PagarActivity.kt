package com.example.banco

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class PagarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagar)
        setSupportActionBar(findViewById(R.id.toobar2))
        val saldo = intent.getStringExtra("sSaldo")
        val txtSaldo = findViewById<TextView>(R.id.txtsaldo1)
        txtSaldo.setText(saldo.toString())
        var nsaldo = saldo.toString().toDouble()
        val btConf = findViewById<Button>(R.id.btnConfirma1)

        /*--------------------------------------------------------------------------------------*/

        btConf.setOnClickListener {
            val data = Intent()
            val valorPagar = findViewById<EditText>(R.id.edtValorPagar)
            var nvalor = valorPagar.text.toString().toDouble()
            if (nvalor > nsaldo) {
                Toast.makeText(this, "Saldo de $nsaldo é insuficiente para $nvalor",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                nsaldo -= nvalor
            }
            val txtSaldo = nsaldo.toString()
            data.putExtra("sSaldo", txtSaldo)
            setResult(Activity.RESULT_OK, data)
            Toast.makeText(this, "$nsaldo", Toast.LENGTH_SHORT).show()
            valorPagar.setText("".toString())
            finish()

            /*--------------------------------------------------------------------------------------*/

        }
    }
}