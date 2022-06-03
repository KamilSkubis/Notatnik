package skubis.kamil.notatnik.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import skubis.kamil.notatnik.model.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class NotepadDb extends RoomDatabase {
    public static final String DB_NAME = "notepadDb.db";
    private static NotepadDb notepadDb;


    public abstract NoteDao getNoteDao();

    public static NotepadDb getInstance(Context context){
        if(notepadDb == null){
            notepadDb = Room.databaseBuilder(context,NotepadDb.class,DB_NAME)
                    .allowMainThreadQueries().
                    build();
        }
        return notepadDb;
    }




    public void cleanUp(){
        notepadDb = null;
    }



}
