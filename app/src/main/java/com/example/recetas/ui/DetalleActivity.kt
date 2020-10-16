package com.example.recetas.ui

import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recetas.R
import com.example.recetas.model.Receta
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.card_item.*

class DetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val receta = intent.getSerializableExtra("receta") as Receta

        tvTituloDetail.text = receta.titulo
        tvTiempoDetail.text = receta.tiempo
        tvLikes.text = receta.likes
        tvReceta.text = receta.detalle
        ivImagenDetail.setImageResource(receta.imagen)
        tvIngredientes.text=receta.ingredientes


    }
}