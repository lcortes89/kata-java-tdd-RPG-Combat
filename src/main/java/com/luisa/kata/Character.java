package com.luisa.kata;

public class Character {

    private int health = 1000;
    private boolean alive = true;
    private int level = 1;

    public int getHealth(){
        return health;
    }

    public  boolean isAlive(){
        return alive;
    }
    
    public int getLevel(){
        return level;
    }

    public void dealDamage(Character target, int amount){
        int newHealth = target.health - amount;

        if(newHealth <= 0) {
            target.health = 0;
            target.alive = false;
        } else{
            target.health = newHealth;
        }
    }
}
