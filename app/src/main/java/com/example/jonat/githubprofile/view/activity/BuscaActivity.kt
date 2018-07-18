package com.example.jonat.githubprofile.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.jonat.githubprofile.R
import com.example.jonat.githubprofile.github.model.Usuario
import com.example.jonat.githubprofile.github.network.Network
import kotlinx.android.synthetic.main.activity_busca.*

class BuscaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busca)


        setBuscarButton()




    }


    fun setBuscarButton(){
        buscar.setOnClickListener{

            var usuario = usuario.text.toString()
            Network.checarRequisicao(usuario)

        }
    }




}
