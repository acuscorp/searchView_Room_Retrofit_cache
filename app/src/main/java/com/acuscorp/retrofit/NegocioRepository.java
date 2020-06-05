package com.acuscorp.retrofit;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * Created by Noé Adrian Acuna Prado on 12/02/2020.
 * Sistema BEA
 * acuscorp@gmail.com
 */
public class NoteRepository {
    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application){
        NoteDatabese databese = NoteDatabese.getInstance(application);
        noteDao = databese.noteDao();
        allNotes = noteDao.getAllNotes();
    }
    public  void insert(Note note){
        new InsertNoteAsynkTask(noteDao).execute(note);
    }
    public void update(Note note){
        new UpdateNoteAsynkTask(noteDao).equals(note);
    }

    public  void delete(Note note){
        new DeleteNoteAsynkTask(noteDao).execute(note);
    }
    public  void deleteAllNotes(){
        new DeleteAllNoteAsynkTask(noteDao).execute();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    public static class InsertNoteAsynkTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        public InsertNoteAsynkTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }
    public static class UpdateNoteAsynkTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        public UpdateNoteAsynkTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }
    public static class DeleteNoteAsynkTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        public DeleteNoteAsynkTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }
    public static class DeleteAllNoteAsynkTask extends AsyncTask<Void, Void, Void> {
        private NoteDao noteDao;

        public DeleteAllNoteAsynkTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllNotes( );
            return null;
        }
    }

}
