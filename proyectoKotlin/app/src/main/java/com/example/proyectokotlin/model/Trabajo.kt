package com.example.proyectokotlin.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
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
    val urlFoto: String?,

    @SerializedName("jobExcerpt")
    val descripcion: String?,


    @SerializedName("salaryMin")
    val salaryMin: Int?,

    @SerializedName("salaryMax")
    val salaryMax: Int?,

    @SerializedName("salaryCurrency")
    val moneda: String?,

    @ColumnInfo(name = "es_favorito")
    var esFavorito: Boolean = false
) {

    val salario: String
        get() {
            return if (salaryMin != null && salaryMax != null) {
                "${'$'}salaryMin - ${'$'}salaryMax ${'$'}moneda"
            } else if (salaryMin != null) {
                "${'$'}salaryMin ${'$'}moneda"
            } else {
                "Consultar"
            }
        }
}