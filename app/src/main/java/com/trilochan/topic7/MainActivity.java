package com.trilochan.topic7;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.io.IOException;
import java.io.PrintStream;

public class MainActivity extends AppCompatActivity {

    EditText etWord;
    Button btnAddWord;
    EditText etMeaning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWord = findViewById(R.id.etWord);
        etMeaning = findViewById(R.id.etMeaning);
        btnAddWord = findViewById(R.id.btnAddWord);

    }
    private void save(){
        try {
            PrintStream printStream = new PrintStream(openFileOutput("words.txt", MODE_PRIVATE | MODE_APPEND));
            printStream.println(etWord.getText().toString()+">>" + etMeaning.getText().toString());
            Toast.makeText(this,"Saved to"+ getFilesDir(),Toast.LENGTH_SHORT).show();
        }
        catch (IOException e) {
            Log.d("Dictionary app", "error" + e.toString());
            e.printStackTrace();
        }
        }
    }

