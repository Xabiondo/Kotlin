package com.example.proyectokotlin.model

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase


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


@Database(entities = [Trabajo::class], version = 1, exportSchema = false)
abstract class TrabajoDatabase : RoomDatabase() {

    abstract fun trabajoDao(): TrabajoDao

    companion object {
        @Volatile
        private var INSTANCE: TrabajoDatabase? = null

        //Patrón singleton para usar siempre la misma instancia
        // para conectarse a la base de datos

        fun getDatabase(context: Context): TrabajoDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TrabajoDatabase::class.java,
                    "trabajos_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}