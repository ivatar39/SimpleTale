package com.example.user.simpletale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Name_Field extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_field);
        Button getText = (Button) (findViewById(R.id.get_text));
        final EditText namecharacter = (EditText) (findViewById(R.id.character_name));

        getText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String character_name = String.valueOf(namecharacter.getText());
                Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                startActivity(intent);

            }
        });

    }

}
