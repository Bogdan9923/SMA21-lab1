package intents;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.example.helloworld.R;

public class IntentFilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_filter);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(getIntent().getStringExtra("str").toString());

    }
}