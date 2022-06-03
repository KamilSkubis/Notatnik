package skubis.kamil.notatnik.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "notes")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int noteId;

    private String content;

    private String title;

//    public Note(int noteId, String content, String title) {
//        this.noteId = noteId;
//        this.content = content;
//        this.title = title;
//    }

    @Ignore
    public Note() {
    }

    public Note(String content, String title) {
        this.content = content;
        this.title = title;
    }




    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return noteId == note.noteId && Objects.equals(content, note.content) && Objects.equals(title, note.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noteId, content, title);
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
