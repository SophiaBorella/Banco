package com.example.banco

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class DepositarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_depositar)
        setSupportActionBar(findViewById(R.id.toolbar4))
        val saldo = intent.getStringExtra("sSaldo")
        val txtSaldo = findViewById<TextView>(R.id.txtsaldo3)
        txtSaldo.setText(saldo.toString())
        var nsaldo = saldo.toString().toDouble()
        val btConf = findViewById<Button>(R.id.edtConfirma6)

        /*--------------------------------------------------------------------------------------*/

        btConf.setOnClickListener {
            val data = Intent()
            val valorDeposit = findViewById<EditText>(R.id.edtValorDeposit)
            var nvalor = valorDeposit.text.toString().toDouble()
            if (nvalor > nsaldo) {
                Toast.makeText(this, "Saldo de $nsaldo é insuficiente para $nvalor",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                nsaldo += nvalor
            }
            val txtSaldo = nsaldo.toString()
            data.putExtra("sSaldo", txtSaldo)
            setResult(Activity.RESULT_OK, data)
            Toast.makeText(this, "$nsaldo", Toast.LENGTH_SHORT).show()
            valorDeposit.setText("".toString())
            finish()

            /*--------------------------------------------------------------------------------------*/

        }
    }
}