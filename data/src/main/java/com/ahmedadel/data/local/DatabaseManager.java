package com.ahmedadel.data.local;

import android.content.Context;

import com.ahmedadel.data.local.dao.MovieDao;
import com.ahmedadel.data.local.dao.PersonDao;
import com.ahmedadel.data.local.dao.TVDao;
import com.ahmedadel.data.local.model.MovieLocal;
import com.ahmedadel.data.local.model.PersonLocal;
import com.ahmedadel.data.local.model.TVLocal;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MovieLocal.class, PersonLocal.class, TVLocal.class}, version = 1, exportSchema = false)
public abstract class DatabaseManager extends RoomDatabase {

    private static DatabaseManager databaseManager;

    public abstract MovieDao movieDao();

    public abstract PersonDao personDao();

    public abstract TVDao tvDao();

    public static synchronized DatabaseManager getInstance(Context context) {
        if (databaseManager == null)
            databaseManager = Room.databaseBuilder(
                    context.getApplicationContext(),
                    DatabaseManager.class, "movie-app").build();
        return databaseManager;
    }

}
