package dbaccess;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NotesDbHelper extends SQLiteOpenHelper {
   public static final String DB_NAME = "Notes";
   public static final int DB_VERSION = 2;
   public static String TABLE_NAME_NOTES = "Notes";
   public static String COLUMN_NAME_NOTES_ID = "id";
   public static String COLUMN_NAME_NOTES_TITLE = "title";
   public static String COLUMN_NAME_NOTES_NOTE = "note";
   public static String[] NOTES_COLUMNS = {COLUMN_NAME_NOTES_ID,
                                            COLUMN_NAME_NOTES_TITLE,
                                            COLUMN_NAME_NOTES_NOTE};
    public NotesDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME_NOTES +
                " ("+COLUMN_NAME_NOTES_ID +" integer PRIMARY KEY AUTOINCREMENT, " +
                     COLUMN_NAME_NOTES_TITLE + " TEXT NULL, " +
                COLUMN_NAME_NOTES_NOTE +" TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE " + TABLE_NAME_NOTES);
            onCreate(db);
    }
}
