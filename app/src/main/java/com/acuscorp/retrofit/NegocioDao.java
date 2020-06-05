package com.acuscorp.retrofit;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Created by Noé Adrian Acuna Prado on 24/01/2020.
 * Sistema BEA
 * acuscorp@gmail.com
 */
@Dao        // Data Access Object
public interface NoteDao {
    @Insert
    void insert(Note note);
    @Update
    void update(Note note);
    @Delete
    void delete(Note note);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Query("SELECT * FROM note_table  ORDER BY priority ")
    LiveData<List<Note>> getAllNotes();

}
