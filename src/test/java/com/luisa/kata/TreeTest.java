package com.luisa.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class TreeTest {

    @Test
    public void newTreeHasGivenHealth() {
        Tree tree = new Tree(2000);

        assertEquals(2000, tree.getHealth());
    }

    @Test
    public void newTreeIsNotDestroyed() {
        Tree tree = new Tree(2000);

        assertFalse(tree.isDestroyed());
    }

    @Test
    public void characterCanDealDamageToTree() {
        Character character = new Character();
        Tree tree = new Tree(2000);

        character.dealDamage(tree, 300, 1);

        assertEquals(1700, tree.getHealth());
    }

    @Test
    public void treeIsDestroyedWhenDamageExceedsHealth() {
        Character character = new Character();
        Tree tree = new Tree(2000);

        character.dealDamage(tree, 2500, 1);

        assertEquals(0, tree.getHealth());
        assertTrue(tree.isDestroyed());
    }

    @Test
    public void dealDamageFailsWhenTreeOutOfRange() {
        Character character = new Character();
        Tree tree = new Tree(2000);

        character.dealDamage(tree, 300, 3);

        assertEquals(2000, tree.getHealth());
    }
}