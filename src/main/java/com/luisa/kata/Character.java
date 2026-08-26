package com.luisa.kata;

public class Character {

    private int health = 1000;
    private boolean alive = true;
    private int level = 1;

    public Character() {
    }

    public Character(int level) {
        this.level = level;
    }

    public int getHealth(){
        return health;
    }

    public  boolean isAlive(){
        return alive;
    }
    
    public int getLevel(){
        return level;
    }

    public void dealDamage(Character target, int amount) {
        if (this == target) {
            return;
        }

        int modifiedAmount = amount;

        if (target.level - this.level >= 5) {
            modifiedAmount = (int) (amount * 0.5);
        } else if (this.level - target.level >= 5) {
            modifiedAmount = (int) (amount * 1.5);
        }

        int newHealth = target.health - modifiedAmount;

        if (newHealth <= 0) {
            target.health =0;
            target.alive = false;
        } else {
            target.health = newHealth;
        }
    }

    public void heal(Character target, int amount) {
        if(this != target) {
            return;
        }

        if (!target.alive) {
            return;
        }

        int newHealth = target.health + amount;
        if (newHealth > 1000) {
            target.health = 1000;
        } else {
            target.health = newHealth;
        }
    }
}
