package com.example.user.simpletale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Finish_Win extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish_win);

        Button game_again = (Button) (findViewById(R.id.again_bt));
        Button finish_please_i_dont_want_to_play_in_this_shit_i_seriously = (Button) (findViewById(R.id.exit_bt));
        Button btExit = (Button) (findViewById(R.id.btExit));
        game_again.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Username.class);
                startActivity(intent);

            }


        });
        finish_please_i_dont_want_to_play_in_this_shit_i_seriously.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View m) {
                finish();
            }
        });

    }
}
