package com.luisa.kata;

import java.util.HashSet;
import java.util.Set;

public class Character {

    private static final int MAX_HEALTH = 1000;
    private static final int DEFAULT_LEVEL = 1;
    private static final int DEFAULT_ATTACK_RANGE = 2;
    private static final int LEVEL_DIFFERENCE_THRESHOLD = 5;
    private static final double DAMAGE_REDUCTION_MULTIPLIER = 0.5;
    private static final double DAMAGE_INCREASE_MULTIPLIER = 1.5;

    private int health = MAX_HEALTH;
    private boolean alive = true;
    private int level = DEFAULT_LEVEL;
    private int attackRange = DEFAULT_ATTACK_RANGE;
    private Set<String> factions = new HashSet<>();

    public Character() {
        this(DEFAULT_LEVEL, DEFAULT_ATTACK_RANGE);
    }

    public Character(int level) {
        this(level, DEFAULT_ATTACK_RANGE);
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

    public boolean isAlive(){
        return alive;
    }

    public int getLevel(){
        return level;
    }

    public void dealDamage(Character target, int amount, int distance) {
        if (this == target) {
            return;
        }

        if (this.isAllyOf(target)) {
            return;
        }

        if (isOutOfRange(distance)) {
            return;
        }

        int modifiedAmount = amount;

        if (target.level - this.level >= LEVEL_DIFFERENCE_THRESHOLD) {
            modifiedAmount = (int) (amount * DAMAGE_REDUCTION_MULTIPLIER);
        } else if (this.level - target.level >= LEVEL_DIFFERENCE_THRESHOLD) {
            modifiedAmount = (int) (amount * DAMAGE_INCREASE_MULTIPLIER);
        }

        target.receiveDamage(modifiedAmount);
    }

    private void receiveDamage(int amount) {
        int newHealth = health - amount;

        if (newHealth <= 0) {
            health = 0;
            alive = false;
        } else {
            health = newHealth;
        }
    }

    public void dealDamage(Tree target, int amount, int distance) {
        if (isOutOfRange(distance)) {
            return;
        }

        target.receiveDamage(amount);
    }

    private boolean isOutOfRange(int distance) {
        return distance > this.attackRange;
    }

    public void heal(Character target, int amount) {
        if (this != target && !this.isAllyOf(target)) {
            return;
        }

        target.receiveHealing(amount);
    }

    private void receiveHealing(int amount) {
        if (!alive) {
            return;
        }

        int newHealth = health + amount;
        if (newHealth > MAX_HEALTH) {
            health = MAX_HEALTH;
        } else {
            health = newHealth;
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

    public boolean isAllyOf(Character other) {
        for (String faction : this.factions) {
            if (other.factions.contains(faction)) {
                return true;
            }
        }
        return false;
    }
}