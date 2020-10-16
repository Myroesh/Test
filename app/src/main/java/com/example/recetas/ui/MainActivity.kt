package com.example.recetas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recetas.R
import com.example.recetas.adapter.RVAdapter
import com.example.recetas.model.Receta
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var datos:ArrayList<Receta>
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adaptador:RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llenarRecetas()
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvContenido.layoutManager = layoutManager

        adaptador = RVAdapter(this, datos)
        rvContenido.adapter = adaptador

    }
    private fun llenarRecetas(){
        datos= ArrayList()
        val arrayTitulos=resources.getStringArray(R.array.titulos)
        val arrayTiempos=resources.getStringArray(R.array.tiempos)
        val arrayImagenes=resources.obtainTypedArray(R.array.imagenes)
        val arrayDetalles=resources.getStringArray(R.array.detalles)
        val arrayLikes=resources.getStringArray(R.array.likes)
        val arratIngredientes=resources.getStringArray(R.array.ingredientes)
        for (i in arrayTitulos.indices){
            val receta=Receta()
            receta.titulo=arrayTitulos[i]
            receta.tiempo=arrayTiempos[i]
            receta.imagen=arrayImagenes.getResourceId(i, -1)
            receta.detalle=arrayDetalles[i]
            receta.likes=arrayLikes[i]
            receta.ingredientes=arratIngredientes[i]
            datos.add(receta)
        }
    }
}