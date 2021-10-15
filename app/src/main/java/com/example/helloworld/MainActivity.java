package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    String name;
    Button s_button;
    EditText nameInput;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = (EditText) findViewById(R.id.nameInput);
        s_button = (Button) findViewById(R.id.submit_button);
        text = (TextView) findViewById(R.id.welcometext);

        s_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                name = nameInput.getText().toString();
                text.setText("Welcome, " + name + "!");
            }
        });

    }


}


