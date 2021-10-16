package intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;

import lifecycle.ActivityA;

public class MainIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intent);

        Button Button_A,Button_B,Button_C,Button_D;

        Button_A = (Button) findViewById(R.id.button_A);
        Button_B = (Button) findViewById(R.id.button_B);
        Button_C = (Button) findViewById(R.id.button_C);
        Button_D = (Button) findViewById(R.id.button_D);

        Button_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(callIntent);
            }
        });

        Button_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:00401213456"));
                startActivity(callIntent);
            }
        });

        Button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainIntentActivity.this,IntentFilterActivity.class);
                intent.putExtra("str","http://www.google.com");
                startActivity(intent);
            }
        });

        Button_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainIntentActivity.this,IntentFilterActivity.class);
                intent.putExtra("str","tel:00401213456");
                startActivity(intent);
            }
        });
    }
}