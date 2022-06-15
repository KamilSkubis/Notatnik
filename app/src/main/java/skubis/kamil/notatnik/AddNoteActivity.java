package skubis.kamil.notatnik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import skubis.kamil.notatnik.model.Note;
import skubis.kamil.notatnik.persistence.NotepadDb;

public class AddNoteActivity extends AppCompatActivity {
    private TextInputLayout titleInput;
    private TextInputEditText noteInput;
    private NotepadDb noteDatabase;
    private Note note;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_note_activity);

        titleInput = (TextInputLayout) findViewById(R.id.titleInputField);
        noteInput = (TextInputEditText) findViewById(R.id.noteInput);
        noteDatabase = NotepadDb.getInstance(AddNoteActivity.this);
        Button button = findViewById(R.id.button_save);



    }
}