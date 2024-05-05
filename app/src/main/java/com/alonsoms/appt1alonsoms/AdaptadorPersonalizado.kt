package com.alonsoms.appt1alonsoms

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alonsoms.appt1alonsoms.entities.clasemodelos

class AdaptadorPersonalizado:RecyclerView.Adapter<AdaptadorPersonalizado.MiViewHolder>() {

    private var listaOfertas:ArrayList<clasemodelos.Oferta> = ArrayList()
    private lateinit var context: Context
    fun agregarDatos(items: ArrayList<clasemodelos.Oferta>) {
        this.listaOfertas = items
    }

    fun contexto(context: Context){
        this.context =context
    }
    class MiViewHolder(var view: View):RecyclerView.ViewHolder(view) {
        private var PrecioOferta = view.findViewById<TextView>(R.id.filaPrecioOferta)

        fun bindView( oferta: clasemodelos.Oferta){
            PrecioOferta.text = oferta.precioOferta.toString()
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
       val ofertaItem = listaOfertas[position]
        holder.bindView(ofertaItem)
        
    }
    override fun getItemCount(): Int {
        return listaOfertas.size
    }

}