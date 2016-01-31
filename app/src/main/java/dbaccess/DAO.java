package dbaccess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import entities.Note;


public class DAO {
    //private instance
    private static DAO instance;
    private final Context context;
    private final SQLiteDatabase db;

    public static synchronized DAO getSharedInstance(Context context) {
        if (instance == null)
            instance = new DAO(context);
        return instance;
    }

    //private constructor
    private DAO(Context context) {
        this.context = context;
        NotesDbHelper helper = new NotesDbHelper(context);
        db = helper.getWritableDatabase();
    }


    public void createNote(String title, String content) {
        ContentValues values = new ContentValues();
        values.put(NotesDbHelper.COLUMN_NAME_NOTES_TITLE, title);
        values.put(NotesDbHelper.COLUMN_NAME_NOTES_NOTE, content);
        db.insert(NotesDbHelper.TABLE_NAME_NOTES, null, values);
    }

    public void updateNote(int id, String title, String note) {
        ContentValues values = new ContentValues();
        values.put(NotesDbHelper.COLUMN_NAME_NOTES_TITLE, title);
        values.put(NotesDbHelper.COLUMN_NAME_NOTES_NOTE, note);
        db.update(NotesDbHelper.TABLE_NAME_NOTES, values, "id=?", new String[]{String.valueOf(id)});
    }

    public void deleteNote(int id){
        db.delete(NotesDbHelper.TABLE_NAME_NOTES, "id=?", new String[]{String.valueOf(id)});
    }

    public ArrayList<Note> readAllNotes() {
        ArrayList<Note> notes = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + NotesDbHelper.TABLE_NAME_NOTES, null);

        db.query(
                NotesDbHelper.TABLE_NAME_NOTES/*Table*/,
                NotesDbHelper.NOTES_COLUMNS/*columns*/,
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            String note = cursor.getString(2);
            Note n = new Note(title, note, id);
            notes.add(n);
        }
        return notes;
    }
}
