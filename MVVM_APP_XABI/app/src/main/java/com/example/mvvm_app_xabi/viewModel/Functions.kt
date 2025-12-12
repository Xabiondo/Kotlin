package com.example.mvvm_app_xabi.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.mvvm_app_xabi.model.Constantes


class LoginViewModel : ViewModel(){

    var navegarInicio by mutableStateOf(false)
        private set

    

    fun probarLogin(usuario : String, contraseña : String ): Boolean {

        Constantes.usuarios.forEach { sujeto ->

            if (sujeto.nombre == usuario && sujeto.contraseña == contraseña){
                navegarInicio = true ;

            }

        }

        return navegarInicio ;
    }
    fun yaEntre(){
        navegarInicio = false
    }

}
