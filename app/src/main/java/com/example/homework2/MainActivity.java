package com.example.homework2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
}
