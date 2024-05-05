package com.alonsoms.appt1alonsoms

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alonsoms.appt1alonsoms.entities.Persona
import com.alonsoms.appt1alonsoms.entities.clasemodelos



class AdaptadorPersonalizado:RecyclerView.Adapter<AdaptadorPersonalizado.MiViewHolder>() {

    private var listarOfertas:ArrayList<clasemodelos> = ArrayList()
    private lateinit var context: Context

    fun agregarDatos(items: ArrayList<clasemodelos>) {
        this.listarOfertas = items
    }

    fun contexto(context: Context){
        this.context =context
    }
    class MiViewHolder(var view: View):RecyclerView.ViewHolder(view) {
        private var PrecioOferta = view.findViewById<TextView>(R.id.filaPrecioOferta)


        fun bindView(clasemodelos: clasemodelos.Oferta){
            PrecioOferta.text = clasemodelos.precioOferta.toFloat().toString()

        }

        fun bindView(clasemodelos: clasemodelos) {

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = MiViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.filaofertas,parent,false)
    )

    override fun onBindViewHolder(holder: AdaptadorPersonalizado.MiViewHolder, position: Int) {
       val ofertaItem = listarOfertas[position]
        holder.bindView(ofertaItem)
        
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}