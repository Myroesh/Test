package com.example.recetas.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recetas.R
import com.example.recetas.model.Receta
import com.example.recetas.ui.DetalleActivity

class RVAdapter(activity: Activity, private val items: ArrayList<Receta>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    private val context: Context

    init {
        this.context = activity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val receta = items[position]
        holder.tvTitulo.text = receta.titulo
        holder.tvTiempo.text=receta.tiempo
        holder.ivImagen.setImageResource(receta.imagen)


    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView
        val tvTiempo: TextView
        val ivImagen: ImageView
        init {
            tvTitulo = itemView.findViewById(R.id.tvTitulo) as TextView
            tvTiempo = itemView.findViewById(R.id.tvTiempo) as TextView
            ivImagen = itemView.findViewById(R.id.ivImagen) as ImageView

            itemView.setOnClickListener {
                val intent = Intent(context, DetalleActivity::class.java)
                intent.putExtra("receta", items[adapterPosition])
                context.startActivity(intent)
            }
        }
    }
}