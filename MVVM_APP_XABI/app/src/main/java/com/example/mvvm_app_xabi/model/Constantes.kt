package com.example.mvvm_app_xabi.model

import androidx.compose.runtime.mutableStateListOf


object Constantes {

    val usuarios = mutableStateListOf<Usuario>(
        Usuario("Admin" , 12 , "1234") ,
        Usuario("xabi" , 20 , "xabi")

    )

}

