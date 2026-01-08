package com.example.proyectokotlin.data.model // Ajusta el paquete si es necesario

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "tabla_favoritos")
data class Trabajo(
    @PrimaryKey
    @SerializedName("id")
    val id: Long,

    @SerializedName("jobTitle")
    val titulo: String,

    @SerializedName("companyName")
    val empresa: String,

    @SerializedName("companyLogo")
    val urlFoto: String?, // Puede venir vacío

    @SerializedName("jobExcerpt")
    val descripcion: String?, // El resumen

    @SerializedName("annualSalaryMin")
    val salario: String? // El salario
)