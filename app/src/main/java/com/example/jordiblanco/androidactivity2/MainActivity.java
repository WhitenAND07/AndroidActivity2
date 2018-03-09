package com.example.jordiblanco.androidactivity2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    EditText editText1, editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.message);
        textView1.setText(R.string.message);

        TextView textView2 = (TextView) findViewById(R.id.messagePrint);
        textView2.setText(R.string.messagePrint);
        TextView textView3 = (TextView) findViewById(R.id.messageR);
        textView3.setText(R.string.messageR);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = editText1.getText().toString();
                String num = editText2.getText().toString();
                if(msg.isEmpty() || num.isEmpty()){
                    Toast.makeText(getApplicationContext(),getString(R.string.Error),
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    String messageBye = constructMessageBye(msg, Integer.parseInt(num));
                    Intent intent1 = new Intent(MainActivity.this, Main2Activity.class);
                    intent1.putExtra("messageBye", messageBye);
                    startActivityForResult(intent1, 2);
                }
            }
        });
    }
    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        if(requestCode == 2){
            if(resultCode == RESULT_OK){
                textView1.setText(data.getStringExtra("message"));
            }
        }
    }
    public String constructMessageBye(String message, int num){
        String messageBye = "";
        for(int i =0; i< num; i++){
            messageBye += message + " ";
        }
        return messageBye;
    }
}
