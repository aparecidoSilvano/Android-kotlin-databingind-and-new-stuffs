package com.example.aparecido.mymovieapp.data.entries

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

//@Dao
interface MovieDAOKT {

    @Insert(onConflict = REPLACE)
    fun insertAll(vararg movies: Array<List<MovieSearch>?>)

    @Query("SELECT * FROM MovieSearch")
    fun getAll(): List<MovieSearch>
}