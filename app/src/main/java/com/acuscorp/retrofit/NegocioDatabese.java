package com.acuscorp.retrofit;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by Noé Adrian Acuna Prado on 24/01/2020.
 * Sistema BEA
 * acuscorp@gmail.com
 */
@Database(entities = {Note.class},version = 1)
public abstract class NoteDatabese extends RoomDatabase {

    public static volatile NoteDatabese instance;
    public abstract NoteDao noteDao();m
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public static synchronized NoteDatabese getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabese.class, "note_database").build();
        }
        return instance;
    }
    private static Callback roomCallback  = new Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);


        }
    };
    private static class PopulateDbAsynkTask extends AsyncTask<Void, Void, Void> {
        private NoteDao noteDao;
        private PopulateDbAsynkTask(NoteDatabese db){
            noteDao = db.noteDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }

}
