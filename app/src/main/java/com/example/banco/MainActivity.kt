package com.example.banco

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val COD_TELA = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /*PIX-----------------------------------------------------------------------------------*/

    fun btnPix(view: View) {
        val txtSaldo = findViewById<EditText>(R.id.txtSaldo)
        val saldo = txtSaldo.text.toString()
        val intent = Intent(this, PixActivity::class.java).apply {
            putExtra("sSaldo", saldo)
        }
        startActivityForResult(intent, COD_TELA)
    }

    /*RESULTADO-----------------------------------------------------------------------------*/

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == COD_TELA && resultCode == Activity.RESULT_OK) {
            val txtSaldo = findViewById<TextView>(R.id.txtSaldo)
            val sSaldo = data!!.getStringExtra("sSaldo")
            txtSaldo.setText(sSaldo)
        }
    }

    /*PAGAR---------------------------------------------------------------------------------*/

    fun btnPagar(view: View) {
        val txtSaldo = findViewById<TextView>(R.id.txtSaldo)
        val saldo = txtSaldo.text.toString()
        val intent = Intent (this,PagarActivity::class.java).apply {
            putExtra("sSaldo", saldo)
        }
        startActivityForResult(intent,COD_TELA)
    }

    /*DEPOSITAR-----------------------------------------------------------------------------*/

    fun btnDeposit(view: View) {
        val txtSaldo = findViewById<TextView>(R.id.txtSaldo)
        val saldo = txtSaldo.text.toString()
        val intent = Intent (this,DepositarActivity::class.java).apply {
            putExtra("sSaldo", saldo)
        }
        startActivityForResult(intent,COD_TELA)
    }

    /*TRANSFERIR----------------------------------------------------------------------------*/

    fun btnTransf(view: View) {
        val txtSaldo = findViewById<TextView>(R.id.txtSaldo)
        val saldo = txtSaldo.text.toString()
        val intent = Intent (this,TransferirActivity::class.java).apply {
            putExtra("sSaldo", saldo)
        }
        startActivityForResult(intent,COD_TELA)

        /*--------------------------------------------------------------------------------------*/
    }
}



