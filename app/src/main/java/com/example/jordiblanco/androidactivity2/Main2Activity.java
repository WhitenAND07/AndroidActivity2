package com.example.jordiblanco.androidactivity2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final TextView textView = (TextView) findViewById(R.id.messageBye);
        textView.setText(getIntent().getStringExtra("messageBye"));

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Main2Activity.this, MainActivity.class);
                intent2.putExtra("message", textView.getText().toString());
                setResult(RESULT_OK, intent2);
                finish();
            }
        });
    }
}
