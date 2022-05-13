package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IPokemonFactoryTest {

    IPokemonFactory pokemonFactory;
    Pokemon bulbizzare;
    Pokemon aquali;

    @BeforeEach
    void setUp() {
        pokemonFactory = new PokemonFactory();
        bulbizzare = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        aquali = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
    }

    @Test
    void isIndexCorrect() {
        assertEquals(bulbizzare.getIndex(), 0);
        assertEquals(aquali.getIndex(), 133);
        assertNull(pokemonFactory.createPokemon(-1, 0, 0, 0, 0));
        assertNull(pokemonFactory.createPokemon(151, 0, 0, 0, 0));
    }

    @Test
    void isNameCorrect() {
        assertEquals(bulbizzare.getName(), "Bulbizzare");
        assertEquals(aquali.getName(), "Aquali");
    }

    @Test
    void isAttackCorrect() {
        assert(bulbizzare.getAttack() >= 126);
        assert(bulbizzare.getAttack() <= 126+15);
        assert(aquali.getAttack() >= 186);
        assert(aquali.getAttack() <= 186+15);
    }

    @Test
    void isDefenseCorrect() {
        assert(bulbizzare.getDefense() >= 126);
        assert(bulbizzare.getDefense() <= 126+15);
        assert(aquali.getDefense() >= 168);
        assert(aquali.getDefense() <= 168+15);
    }

    @Test
    void isStaminaCorrect() {
        assert(bulbizzare.getStamina() >= 90);
        assert(bulbizzare.getStamina() <= 90+15);
        assert(aquali.getStamina() >= 260);
        assert(aquali.getStamina() <= 260+15);
    }

    @Test
    void isCpCorrect() {
        assertEquals(bulbizzare.getCp(), 613);
        assertEquals(aquali.getCp(), 2729);
    }

    @Test
    void isHpCorrect() {
        assertEquals(bulbizzare.getHp(), 64);
        assertEquals(aquali.getHp(), 202);
    }

    @Test
    void isDustCorrect() {
        assertEquals(bulbizzare.getDust(), 4000);
        assertEquals(aquali.getDust(), 5000);
    }

    @Test
    void isCandyCorrect() {
        assertEquals(bulbizzare.getCandy(), 4);
        assertEquals(aquali.getCandy(), 4);
    }

    @Test
    void isIVCorrect() {
        assert(bulbizzare.getIv() >= 0.00);
        assert(bulbizzare.getIv() <= 1.00);
        assert(aquali.getIv() >= 0.00);
        assert(aquali.getIv() <= 1.00);
    }
}