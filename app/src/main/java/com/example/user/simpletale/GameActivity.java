package com.example.user.simpletale;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    public Random r = new Random();
    public static Player player;
    public ArrayList<NPC> NPCs;
    final String names[] = {"Фроггит", "Темми", "Меттатон", "Папирус", "Чара", "Тоби Фокс"};
    final int    monsterID[] = {R.drawable.monster1,R.drawable.monster2,R.drawable.monster3,R.drawable.monster4,R.drawable.monster5,R.drawable.monster6};
    public static int stage = 1;

    final String replix[][] ={
            {"",""},
            {"Фроггит говорит: АЙ!","Фроггит говорит: Я сейчас тебя как муху съем!","Фроггит говорит: Брысь!","Фроггит чувствует себя нехорошо...","Фроггит зол на вас!","Фроггит готовит специальную атаку! (нет)","Фроггит говорит:...ТЫ СМЕРТНИК!"},
            {"Темми говорит: 4Й1 Т6| Ч3Г07!","Темми говорит: ХВ4ТNТ1","Темми говорит: П0JIYЧ4Й!","Темми говорит: YХ4ДN!","Темми взбешен.","Отстаньте от Темми.","Темми украл у вас 50 монет."},
            {"Меттатон говорит: ПОТАНЦУЕМ?","Меттатон говорит: ДИТЯ, ДУМАЕШЬ, ТЫ МЕНЯ ПОБЕДИШЬ?","Меттатон смотрит вам в душу.","Вам страшно.","Вы ослеплены блеском его брони.","Вы измучены его самовлюбленными репликами (что...?).","ХВАТИТ СВЕТИТЬ МНЕ В ГЛАЗ!"},
            {"Папирус говорит: Привет, будем друзьями?","Вы увидели Санса за деревом. Вам стало страшно.","Папирус говорит: За что...?","Вы задумались...откуда у него все эти кости...? Да неважно...","Вам обидно за старого друга.","Вас достала это СКЕЛЕТонна костей.","You feel your sins crawling on your back . . ."},
            {"Чара говорит: Мы же сестры! За что?","По вашей спине прошла дрожь...","Почему ее нож красный?","ПОЧЕМУ ЕЕ ГЛАЗА КРАСНЫЕ!!?","Вы сожалеете за совершенные грехи.","Чара говорит: Б3СП0JI3ЗН0.","Чара говорит: Ну ладно..."},
            {"гав","ваг","авг","гва","агв","вга","Просто собака."}};

    ImageView enemypicture;
    TextView lowerpicture, hpplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field);
        Button option1 = (Button) (findViewById(R.id.bt_option1));
        Button option2 = (Button) (findViewById(R.id.bt_option2));
        Button option3 = (Button) (findViewById(R.id.bt_option3));
        Button option4 = (Button) (findViewById(R.id.bt_option4));

          enemypicture = (ImageView) (findViewById(R.id.iv_image));
          lowerpicture = (TextView) (findViewById(R.id.tv_field_text));
          hpplayer = (TextView) (findViewById(R.id.tv_hp));


        player = new Player(10, 500, 30, 50, 0, 0, 150);
        fetchNPCs();
        newNPC();
        final Random r = new Random();
        option1.setOnClickListener(new View.OnClickListener() {     //attack
            @Override
            public void onClick(View v) {

                NPCs.get(stage).setHp(NPCs.get(stage).getHp() - player.getAttack());
                player.setHp(player.getHp() - (NPCs.get(stage).getAttack() - player.getDefence()));
                if (player.getHp() <= 0) {Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent); }
                if (NPCs.get(stage).getHp() <= 0 ) {NPCGone();
                    newLewel();}
                hpplayer.setText(String.valueOf(player.getHp()));
                lowerpicture.setText(replix[stage][r.nextInt(6)]);

            }
        });

        option2.setOnClickListener(new View.OnClickListener() {     //ability
            @Override
            public void onClick(View v) {
            player.setSuperpossibility(player.getSuperpossibility() + 1);
            if (player.getSuperpossibility() == 3){
                NPCs.get(stage - 1).setHp(NPCs.get(stage - 1).getHp() - player.getSuperattack());
                player.setSuperpossibility(0);
            }
                if (player.getHp() <= 0) {Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent); }
                player.setHp(player.getHp() - (NPCs.get(stage).getAttack() - player.getDefence()));
                if (NPCs.get(stage).getHp() <= 0 ) {NPCGone();
                newLewel();
                }
                hpplayer.setText(String.valueOf(player.getHp()));
                lowerpicture.setText(replix[stage][r.nextInt(6)]);
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {     //heal
            @Override
            public void onClick(View v) {
                player.setHp(player.getHp() + player.getHeal());
                if(player.getHp() > 5000) {
                    player.setHp(player.getHp() - player.getHeal());
                }
                if (player.getHp() <= 0) {Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent); }
                player.setHp(player.getHp() - (NPCs.get(stage).getAttack() - player.getDefence()));
                if (NPCs.get(stage).getHp() <= 0 ) {NPCGone();
                    newLewel();
                }
                hpplayer.setText(String.valueOf(player.getHp()));
                lowerpicture.setText(replix[stage][r.nextInt(6)]);
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {     //mercy
            @Override
            public void onClick(View v) {
            player.setMercy(player.getAttack() + 1);
            if (player.getMercy() == NPCs.get(stage).getScoreMercy()){
                NPCGone();

            }
                player.setHp(player.getHp() - (NPCs.get(stage).getAttack() - player.getDefence()));
                hpplayer.setText(String.valueOf(player.getHp()));
                lowerpicture.setText(replix[stage][r.nextInt(7)]);
            }
        });


    }
    public void fetchNPCs() {
        NPCs = new ArrayList<NPC>();
        for (int i = 1; i < 6; i++){

            NPC npc = new NPC(
                    names[i-1],
                    100*(i) ,
                    10*(i),
                    BitmapFactory.decodeResource(getResources(), monsterID[i-1]),
                    replix[i-1],
                    (i)*3);
        NPCs.add(npc);
        }
    }

    public void newNPC() {
        enemypicture.setImageBitmap(NPCs.get(stage - 1).getImage());
        lowerpicture.setText(NPCs.get(stage - 1).getReplics()[r.nextInt(1)]);

    }
    public void NPCGone() {
        stage++;
        if (stage > NPCs.size()) {
            Intent intent = new Intent(GameActivity.this, Developers.class );
            startActivity(intent);
            finish();
        }
        newNPC();
    }
    public void  newLewel(){
        player.setAttack(player.getAttack() + 100);
        player.setDefence(player.getDefence() + 10);
        player.setSuperattack(player.getSuperattack() + 50);
        player.setHeal(player.getHeal() + 50);}




    }

