package com.luisa.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class CombatRulesTest {

    @Test
    public void dealDamageReducesTargetHealth(){
        Character attacker = new Character();
        Character target = new Character();

        attacker.dealDamage(target, 100, 1);

        assertEquals(900, target.getHealth());
    }

    @Test
    public void characterDiesWhenDamageExceedsHealth(){
        Character attacker = new Character();
        Character target = new Character();

        attacker.dealDamage(target, 1500, 1);

        assertEquals(0, target.getHealth());
        assertFalse(target.isAlive());
    }

    @Test
    public void characterCannotDealDamageToItself(){
        Character character = new Character();

        character.dealDamage(character, 100, 1);

        assertEquals(1000, character.getHealth());
    }

    @Test
    public void healIncreasesOwnHealth() {
        Character attacker = new Character();
        Character character = new Character();
        attacker.dealDamage(character, 300, 1);

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
    public void deadCharacterCannotBeHealed() {
        Character attacker = new Character();
        Character character = new Character();
        attacker.dealDamage(character, 1500, 1);

        character.heal(character, 100);

        assertEquals(0, character.getHealth());
    }

    @Test
    public void healingAnotherCharacterDoesNothing() {
        Character attacker = new Character();
        Character character = new Character();
        attacker.dealDamage(character, 300, 1);

        attacker.heal(character, 100);

        assertEquals(700, character.getHealth());
    }

    @Test
    public void damageIsReducedWhenTargetIsFiveOrMoreLevelsAbove(){
        Character attacker = new Character(1);
        Character target = new Character(6);

        attacker.dealDamage(target, 100, 1);

        assertEquals(950, target.getHealth());
    }

    @Test
    public void damageIsIncreasedWhenAttackerIsFiveOrMoreLevelsAbove() {
        Character attacker = new Character(6);
        Character target = new Character(1);

        attacker.dealDamage(target, 100, 1);

        assertEquals(850, target.getHealth());
    }

    @Test
    public void dealDamageSucceedsWhenTargetInRange() {
        Character attacker = new Character(1, 2);
        Character target = new Character(1, 2);

        attacker.dealDamage(target, 100, 2);

        assertEquals(900, target.getHealth());
    }

    @Test
    public void dealDamageFailsWhenTargetOutOfRange() {
        Character attacker = new Character(1, 2);
        Character target = new Character(1, 2);

        attacker.dealDamage(target, 100, 3);

        assertEquals(1000, target.getHealth());
    }

    @Test
    public void characterCanJoinFaction() {
        Character character = new Character();

        character.joinFaction("Elfos");

        assertTrue(character.isInFaction("Elfos"));
    }

    @Test
    public void characterCanLeaveFaction() {
        Character character = new Character();
        character.joinFaction("Elfos");

        character.leaveFaction("Elfos");

        assertFalse(character.isInFaction("Elfos"));
    }

    @Test
    public void charactersInSameFactionAreAllies() {
        Character character = new Character();
        Character other = new Character();
        character.joinFaction("Elfos");
        other.joinFaction("Elfos");

        assertTrue(character.isAllyOf(other));
    }

    @Test
    public void charactersInDifferentFactionsAreNotAllies() {
        Character character = new Character();
        Character other = new Character();
        character.joinFaction("Elfos");
        other.joinFaction("Piratas");

        assertFalse(character.isAllyOf(other));
    }

    @Test
    public void alliesCannotDealDamageToEachOther() {
        Character attacker = new Character();
        Character target = new Character();
        attacker.joinFaction("Elfos");
        target.joinFaction("Elfos");

        attacker.dealDamage(target, 100, 1);

        assertEquals(1000, target.getHealth());
    }

    @Test
    public void alliesCanHealEachOther() {
        Character attacker = new Character();
        Character character = new Character();
        Character healer = new Character();
        character.joinFaction("Elfos");
        healer.joinFaction("Elfos");

        attacker.dealDamage(character, 300, 1);
        healer.heal(character, 100);

        assertEquals(800, character.getHealth());
    }
}