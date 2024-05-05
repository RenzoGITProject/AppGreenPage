package com.alonsoms.appt1alonsoms

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdaptadorPersonalizado:RecyclerView.Adapter<AdaptadorPersonalizado.MiViewHolder>() {
    class MiViewHolder(var view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdaptadorPersonalizado.MiViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: AdaptadorPersonalizado.MiViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}