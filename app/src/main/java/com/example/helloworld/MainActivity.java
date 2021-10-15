package com.example.helloworld;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    String name;
    Button s_button;
    EditText nameInput;
    TextView text;
    Map<String,String> colorMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorMap.put("White","#ffffff");
        colorMap.put("Green","#00ff00");
        colorMap.put("Red","#ff0000");
        colorMap.put("Blue","#0000ff");

        nameInput = (EditText) findViewById(R.id.nameInput);
        s_button = (Button) findViewById(R.id.submit_button);
        text = (TextView) findViewById(R.id.welcometext);


        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.colors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        s_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                name = nameInput.getText().toString();
                text.setText("Welcome, " + name + "!");
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Greetings Dialog")
                        .setMessage("Welcome, " + name + "!")
                        .setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Positive", Toast.LENGTH_SHORT).show();
                            }
                        })

                        .setNegativeButton("Negative", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Negative", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();

            }
        });





    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        s_button.setTextColor(Color.parseColor(colorMap.get(text)));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


