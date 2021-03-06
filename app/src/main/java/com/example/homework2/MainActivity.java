package com.example.homework2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLookUp(View view) {
        EditText word = (EditText) findViewById(R.id.word);
        String theword = word.getText().toString();

        String definition = findDefinition(theword);
        TextView thedef = (TextView) findViewById(R.id.def);
        if (definition!=null)
            thedef.setText(definition);
        else
            thedef.setText("Word not found");
    }

    private String findDefinition(String theword) {
        InputStream input = getResources().openRawResource(R.raw.myvocabulary);

        Scanner scan = new Scanner(input);
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            String [] pieces = line.split("=");
            if (pieces[0].equalsIgnoreCase(theword.trim())){
                return pieces[1];
            }
        }
        return null;
    }
}
