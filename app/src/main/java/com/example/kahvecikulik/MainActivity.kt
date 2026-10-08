package com.example.kahvecikulik

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val kahvefiyat = 60
    private val kremafiyat = 10
    private val kulikfiyat = 100
    private var kahveadet = 0

    private lateinit var edtad: EditText
    private lateinit var txtadet: TextView
    private lateinit var chkKrema: CheckBox
    private lateinit var chkKulik: CheckBox
    private lateinit var btnSiparis: Button
    private lateinit var txtSonuc: TextView
    private lateinit var btnekle: Button
    private lateinit var btncikar: Button
    private lateinit var btnSifirla: Button





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        edtad = findViewById(R.id.edtad)
        txtadet = findViewById(R.id.txtadet)
        chkKrema = findViewById(R.id.chkKrema)
        chkKulik = findViewById(R.id.chkKulik)
        btnSiparis = findViewById(R.id.btnSiparis)
        txtSonuc = findViewById(R.id.txtSonuc)
        btnekle = findViewById(R.id.btnekle)
        btncikar = findViewById(R.id.btncikar)
        btnSifirla = findViewById(R.id.btnSifirla)

        btnSiparis.setOnClickListener {
            val ad = edtad.text.toString()
            val adet = txtadet.text.toString().toIntOrNull() ?: 0
            val krema = chkKrema.isChecked
            val kulik = chkKulik.isChecked

            var toplamFiyat = adet * kahvefiyat
            if (krema) toplamFiyat += adet * kremafiyat
            if (kulik) toplamFiyat += adet * kulikfiyat
            if (adet == 0) {
                txtSonuc.text = "Lütfen en az bir kahve siparişi verin."
                return@setOnClickListener
            }
            if(ad.isEmpty()) {
                txtSonuc.text = "Lütfen adınızı girin."
                return@setOnClickListener
            }
            val sonuc = "Ad: $ad\nAdet: $adet\nKrema: ${if (krema) "Evet" else "Hayır"}\nKulik: ${if (kulik) "Evet" else "Hayır"}\nToplam Fiyat: $toplamFiyat TL"
            txtSonuc.text = sonuc
        }
        btnekle.setOnClickListener {
            kahveadet++
            txtadet.text = kahveadet.toString()
        }
        btncikar.setOnClickListener {
            if (kahveadet > 0) {
                kahveadet--
                txtadet.text = kahveadet.toString()
            }
        }
        btnSifirla.setOnClickListener {
            kahveadet = 0
            txtadet.text = kahveadet.toString()
            txtSonuc.text = ""
            edtad.text.clear()

        }

    }

}