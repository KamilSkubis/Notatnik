package skubis.kamil.notatnik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Node;

import java.util.List;

import skubis.kamil.notatnik.model.Note;
import skubis.kamil.notatnik.persistence.ZarzadcaBazy;

public class MainActivity extends AppCompatActivity {
    ZarzadcaBazy zb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        FloatingActionButton floatingButton = (FloatingActionButton) findViewById(R.id.floatingButton);
        floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToAddNote();
            }
        });

        zb = new ZarzadcaBazy(this);


        List<Note> nList = zb.dajWszystkie();
        ListView lv = (ListView) findViewById(R.id.listView);
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,nList);
        lv.setAdapter(adapter);
    }

    private void switchToAddNote() {
        Intent addNoteIntent = new Intent(this,AddNoteActivity.class);
        startActivity(addNoteIntent);
    }



    @Override
    protected void onResume() {
        super.onResume();

        List<Note> nList = zb.dajWszystkie();
        ListView lv = (ListView) findViewById(R.id.listView);
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,nList);
        lv.setAdapter(adapter);
    }

}