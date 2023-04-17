package main.app.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import main.app.R;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
    }
}