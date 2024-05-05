package com.alonsoms.appt1alonsoms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alonsoms.appt1alonsoms.entities.Persona
import com.alonsoms.appt1alonsoms.entities.clasemodelos


private var listarOfertasActivity:ArrayList<Persona> = ArrayList()

fun agregarDatos(item: ArrayList<Persona>){


}
class AdaptadorPersonalizado:RecyclerView.Adapter<AdaptadorPersonalizado.MiViewHolder>() {
    class MiViewHolder(var view: View):RecyclerView.ViewHolder(view) {
        private var PrecioOferta = view.findViewById<TextView>(R.id.filaPrecioOferta)


        fun bindView(clasemodelos: clasemodelos.Oferta){
            PrecioOferta.text = clasemodelos.precioOferta.toString()

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = MiViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.filaofertas,parent,false)
    )

    override fun onBindViewHolder(holder: AdaptadorPersonalizado.MiViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}