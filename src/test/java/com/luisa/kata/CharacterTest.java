package com.luisa.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class CharacterTest {

    @Test
    public void newCharacterHasInitialHealth(){
        Character character = new Character();

        assertEquals(1000, character.getHealth());
    }

    @Test
    public void newCharacterIsAlive(){
        Character character = new Character();

        assertTrue(character.isAlive());
    }

    @Test
    public void newCharacterHasInitialLevel(){
        Character character = new Character();

        assertEquals(1, character.getLevel());
    }

    @Test
    public void characterHasGivenAttackRange() {
        Character character = new Character(1, 2);

        assertEquals(2, character.getAttackRange());
    }

    @Test
    public void newCharacterBelongsToNoFaction() {
        Character character = new Character();

        assertFalse(character.isInFaction("Elfos"));
    }

    @Test
    public void meleeCharacterHasRangeOfTwo() {
        Character character = new Warrior();

        assertEquals(2, character.getAttackRange());
    }

    @Test
    public void rangedCharacterHasRangeOfTwenty() {
        Character character = new Archer();

        assertEquals(20, character.getAttackRange());
    }
}