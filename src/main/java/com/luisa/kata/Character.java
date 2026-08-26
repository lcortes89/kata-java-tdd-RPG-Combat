package com.luisa.kata;

import java.util.HashSet;
import java.util.Set;

public class Character {

    private int health = 1000;
    private boolean alive = true;
    private int level = 1;
    private int attackRange = 2;
    private Set<String> factions = new HashSet<>();

    public Character() {
    }

    public Character(int level) {
    this.level = level;
    }

    public Character(int level, int attackRange) {
        this.level = level;
        this.attackRange = attackRange;
    }

    public int getAttackRange() {
        return attackRange;
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

    public void dealDamage(Character target, int amount, int distance) {
        if (this == target) {
            return;
        }

        if (distance > this.attackRange) {
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

    public boolean isInFaction(String faction) {
        return factions.contains(faction);
    }

    public void joinFaction(String faction) {
        factions.add(faction);
    }

    public void leaveFaction(String faction) {
        factions.remove(faction);
    }
}
