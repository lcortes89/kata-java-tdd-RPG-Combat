package com.luisa.kata;

public class Tree {

    private int health;
    private boolean destroyed = false;

    public Tree(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void receiveDamage(int amount) {
        if (amount >= health) {
            health = 0;
            destroyed = true;
        } else {
            health -= amount;
        }
    }
}