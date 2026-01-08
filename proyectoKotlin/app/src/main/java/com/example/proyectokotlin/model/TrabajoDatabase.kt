package com.example.proyectokotlin.data.local

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomDatabase
import com.example.proyectokotlin.data.model.Trabajo


@Dao
interface TrabajoDao {


    @Query("SELECT * FROM tabla_favoritos")
    suspend fun obtenerFavoritos(): List<Trabajo>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardarFavorito(trabajo: Trabajo)


    @Delete
    suspend fun borrarFavorito(trabajo: Trabajo)


    @Query("SELECT EXISTS(SELECT 1 FROM tabla_favoritos WHERE id = :id)")
    suspend fun esFavorito(id: Long): Boolean
}


@Database(entities = [Trabajo::class], version = 1)
abstract class TrabajoDatabase : RoomDatabase() {
    abstract fun trabajoDao(): TrabajoDao
}