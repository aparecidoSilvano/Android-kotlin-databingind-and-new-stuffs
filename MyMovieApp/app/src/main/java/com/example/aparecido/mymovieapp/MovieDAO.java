package com.example.aparecido.mymovieapp;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.example.aparecido.mymovieapp.data.entries.MovieSearch;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface MovieDAO {

    @Insert(onConflict = REPLACE)
    void insertAll(List<MovieSearch> movies);

    @Query("SELECT * FROM MovieSearch")
    LiveData<List<MovieSearch>> getAll();
}
