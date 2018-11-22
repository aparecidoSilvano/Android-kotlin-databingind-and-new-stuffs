package com.example.aparecido.mymovieapp

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.aparecido.mymovieapp.data.entries.MovieDAOKT
import com.example.aparecido.mymovieapp.data.entries.MovieSearch

//@Database(entities = [MovieSearch::class], version = 1)
abstract class AppDatabase : RoomDatabase(), MovieDAOKT {
    abstract fun movieDao(): MovieDAOKT
}