package com.luisa.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
}