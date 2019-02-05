package com.example.user.simpletale;

public class Player {
    private int defence;
    private int hp;
    private int attack;
    private int heal;
    private int mercy;
    private int superpossibility;
    private int superattack;

    public Player() {}

    public Player(int defence, int hp, int attack, int heal, int mercy, int superpossibility, int superattack) {
        this.defence = defence;
        this.hp = hp;
        this.attack = attack;
        this.heal = heal;
        this.mercy = mercy;
        this.superpossibility = superpossibility;
        this.superattack = superattack;
    }
    public  int getSuperpossibility() {return  superpossibility;}

    public void setSuperpossibility(int superpossibility) {this.superpossibility = superpossibility;}
    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
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

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getMercy() {
        return mercy;
    }

    public void setMercy(int mercy) {
        this.mercy = mercy;
    }

    public int getSuperattack() {
        return superattack;
    }

    public void setSuperattack(int superattack) {
        this.superattack = superattack;
    }
}
