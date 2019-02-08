package com.example.user.simpletale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Username extends AppCompatActivity{



Button option_, back_;
EditText username;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.name_field);
            option_ = (Button) (findViewById(R.id.get_text));
            username = (EditText) (findViewById(R.id.character_name));

            option_.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   String username_1;
                   Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                   intent.putExtra("name", String.valueOf(username.getText()));
                    startActivity(intent);
                }
            });

        }
    }


