package skubis.kamil.notatnik.persistence;

/**
 * Created by barte on 09.01.2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

import skubis.kamil.notatnik.model.Note;

public class ZarzadcaBazy extends SQLiteOpenHelper {

    public ZarzadcaBazy(Context context) {
        super(context, "notes.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "CREATE TABLE Notatki(" +
                        "NR INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "Tytul TEXT(50)," +
                        "Notatka TEXT(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


    public void dodajNotatke(Note notatka){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues wartosci = new ContentValues();
        wartosci.put("Tytul", notatka.getTitle());
        wartosci.put("Notatka",notatka.getContent());
        db.insertOrThrow("Notatki",null, wartosci);
    }


    public List<Note> dajWszystkie(){
        List<Note> notes = new LinkedList<Note>();
        String[] kolumny={"nr","Tytul","Notatka"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor kursor =db.query("Notatki",kolumny,null,null,null,null,null);
        while(kursor.moveToNext()){
            Note note = new Note();
            note.setNoteId(kursor.getInt(0));
            note.setTitle(kursor.getString(1));
            note.setContent(kursor.getString(2));
            notes.add(note);
        }
        return notes;
    }

//    public void usunWszystko(){
//        SQLiteDatabase db = getReadableDatabase();
//        db.execSQL("DELETE FROM Notatki");
//    }

}
