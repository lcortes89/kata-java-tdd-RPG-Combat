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
    public void dealDamageReducesTargetHealth(){
        Character attacker = new Character();
        Character target = new Character();

        attacker.dealDamage(target, 100);

        assertEquals(900, target.getHealth());
    }

    @Test
    public void characterDiesWhenDamageExceedsHealth(){
        Character attacker = new Character();
        Character target = new Character();

        attacker .dealDamage(target, 1500);

        assertEquals(0, target.getHealth());
        assertFalse(target.isAlive());
    }

    @Test
    public void deadCharacterCannotBeHealed(){
        Character attacker = new Character();
        Character target = new Character();
        attacker.dealDamage(target, 1500);

        Character healer = new Character();
        healer.heal(target, 100);

        assertEquals(0, target.getHealth());
    }

    @Test
    public void characterCannotDealDamageToItself(){
        Character character = new Character();

        character.dealDamage(character, 100);

        assertEquals(1000, character.getHealth());
    }

    @Test
    public void healIncreasesOwnHealth() {
        Character attacker = new Character();
        Character character = new Character();
        attacker.dealDamage(character, 300);

        character.heal(character, 100);

        assertEquals(800, character.getHealth());
    }

    @Test
    public void healCannotExceedMaxHealth() {
        Character character = new Character();

        character.heal(character, 500);

        assertEquals(1000, character.getHealth());
    }

    @Test
    public void deadCharacterCannotBeHaled() {
        Character attacker = new Character();
        Character character = new Character();
        attacker.dealDamage(character, 1500);

        character.heal(character, 100);

        assertEquals(0, character.getHealth());
    }

    @Test
    public void healingAnotherCharacterDoesNothing() {
        Character attacker = new Character();
        Character character = new Character();
        attacker.dealDamage(character, 300);
        
        attacker.heal(character, 100);

        assertEquals(700, character.getHealth());
    }
    }