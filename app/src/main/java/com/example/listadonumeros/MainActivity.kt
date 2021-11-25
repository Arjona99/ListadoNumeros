package com.example.listadonumeros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var etNumber: EditText? = null
    var btAdd: Button? = null
    var btOrder: Button? = null
    var btClear: Button? = null
    var adapter: NumberAdapter? = null

    var datos = mutableListOf<Number>()

    var currentOrderAsc = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature((Window.FEATURE_NO_TITLE))
        supportActionBar?.hide()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        setContentView(R.layout.activity_main)

        // Assign view elements
        etNumber = findViewById<EditText>(R.id.etNumber)
        btAdd = findViewById<Button>(R.id.btAdd)
        btOrder = findViewById<Button>(R.id.btOrder)
        btClear = findViewById<Button>(R.id.btClear)
        val lvNumbers = findViewById<ListView>(R.id.lvNumbers)

        btAdd?.setOnClickListener {
            addNumber()
        }

        btOrder?.setOnClickListener {
            changeOrder()
        }

        btClear?.setOnClickListener {
            clearList()
        }

        adapter = NumberAdapter(this, datos)
        lvNumbers.adapter =  adapter

    }

    fun addNumber() {
        val numberValue = etNumber?.text.toString()

        if (numberValue.isNotEmpty()) {
            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val newNumber = Number(
                adapter!!.count.toLong(),
                numberValue,
                numberValue.toInt().toString(16),
                sdf.format(Date())
            )

            datos.add(newNumber)
            etNumber?.text = null
            adapter!!.notifyDataSetChanged()
        } else {
            etNumber?.setError(getString((R.string.errorEmptyNumber)))
        }

    }

    fun changeOrder() {
        if (currentOrderAsc) {
            println("Ordenar descendente")
            datos.sortByDescending { it.value.toInt() }
            currentOrderAsc = false
        } else {
            println("Ordenar ascendente")
            datos.sortBy { it.value.toInt() }
            currentOrderAsc = true
        }
        adapter!!.notifyDataSetChanged()
    }

    fun clearList() {
        datos.clear()
        adapter!!.notifyDataSetChanged()
    }
}