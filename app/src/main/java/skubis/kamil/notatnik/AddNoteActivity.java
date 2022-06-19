package skubis.kamil.notatnik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import skubis.kamil.notatnik.model.Note;
import skubis.kamil.notatnik.persistence.NotepadDb;
import skubis.kamil.notatnik.persistence.ZarzadcaBazy;

public class AddNoteActivity extends AppCompatActivity {
    private TextInputEditText titleInput;
    private TextInputEditText noteInput;
    private NotepadDb noteDatabase;
    private Note note;
    private ZarzadcaBazy zb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_note_activity);

        titleInput = (TextInputEditText) findViewById(R.id.titleInput);
        noteInput = (TextInputEditText) findViewById(R.id.noteInput);
        noteDatabase = NotepadDb.getInstance(AddNoteActivity.this);
        Button button = findViewById(R.id.button_save);
        zb = new ZarzadcaBazy(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note = new Note();
                note.setTitle(titleInput.getText().toString());
                note.setContent(noteInput.getText().toString());

                zb.dodajNotatke(note);


                Intent back = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(back);
            }

        });
    }
}