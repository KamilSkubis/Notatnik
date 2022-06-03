package skubis.kamil.notatnik.persistence;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import skubis.kamil.notatnik.model.Note;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM notes")
    List<Note> getAll();

    @Insert
    void insert(Note note);

    @Delete
    void delete(Note... note);

    @Delete
    void delete(Note note);

    @Update
    void update(Note note);


}
