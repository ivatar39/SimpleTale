package com.example.user.simpletale;

import android.graphics.Bitmap;

public class NPC {
    private String name;
    private int hp;
    private int attack;
    private Bitmap image;
    private String replics[];
    private int scoreMercy;

    public NPC(String name, int hp, int attack, Bitmap image, String[] replics, int scoreMercy) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.image = image;
        this.replics = replics;
        this.scoreMercy = scoreMercy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String[] getReplics() {
        return replics;
    }

    public void setReplics(String[] replics) {
        this.replics = replics;
    }

    public int getScoreMercy() {
        return scoreMercy;
    }

    public void setScoreMercy(int scoreMercy) {
        this.scoreMercy = scoreMercy;
    }
}
