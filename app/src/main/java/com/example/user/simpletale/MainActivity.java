package com.example.user.simpletale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Button btStart = (Button) (findViewById(R.id.btStart));
    Button btDevelop = (Button) (findViewById(R.id.btDevelop));
    Button btExit = (Button) (findViewById(R.id.btExit));
    btStart.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(),GameActivity.class);
            startActivity(intent);

        }


    });
    btExit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View m) {
            finish();
        }
    });
        btDevelop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View h) {
                Intent intent = new Intent(getApplicationContext(),Developers.class);
                startActivity(intent);

            }


        });

    }
}
