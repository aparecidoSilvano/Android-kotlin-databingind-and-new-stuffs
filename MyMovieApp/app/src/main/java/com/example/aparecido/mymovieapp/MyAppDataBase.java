package com.example.aparecido.mymovieapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.example.aparecido.mymovieapp.data.entries.MovieSearch;

@Database(entities = {MovieSearch.class}, version = 1)
public abstract class MyAppDataBase extends RoomDatabase {

    public abstract MovieDAO movieDAO();

    private static volatile MyAppDataBase INSTANCE;

    public static MyAppDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyAppDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MyAppDataBase.class, "movies-database").build();
                }
            }
        }

        return INSTANCE;

    }
}
