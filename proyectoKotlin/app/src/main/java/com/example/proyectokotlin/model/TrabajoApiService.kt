package com.example.proyectokotlin.data.remote

import com.example.proyectokotlin.data.model.Trabajo
import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Query

interface TrabajoApi {


    @GET("v2/remote-jobs")
    suspend fun obtenerOfertas(
        @Query("geo") pais: String = "spain",
        @Query("count") cantidad: Int = 10
    ): RespuestaApi
}


data class RespuestaApi(
    @SerializedName("jobs") val trabajos: List<Trabajo>
)