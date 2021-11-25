package com.example.listadonumeros

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class NumberAdapter(private val contexto: Context, val datos: MutableList<Number>): BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(contexto)

    override fun getCount(): Int {
        return datos.size
    }

    override fun getItem(position: Int): Any {
        return datos[position]
    }

    override fun getItemId(position: Int): Long {
        return datos[position].id
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {

        val vista = inflater!!.inflate(R.layout.list_item, null)

        val tvNumber = vista.findViewById<TextView>(R.id.number)
        val tvHexValue = vista.findViewById<TextView>(R.id.hexValue)
        val tvCreationDate = vista.findViewById<TextView>(R.id.creationDate)

        tvNumber.text = datos[position].value
        tvHexValue.text = datos[position].hexValue
        tvCreationDate.text = datos[position].createdDate

        return vista
    }
}
