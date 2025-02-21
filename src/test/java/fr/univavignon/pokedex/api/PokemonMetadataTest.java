package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokemonMetadataTest {

    PokemonMetadata bulbizzare;

    @BeforeEach
    public void setup() throws PokedexException {
        bulbizzare = PokemonMetadataProvider.getPokemonMetadataProvider().getPokemonMetadata(0);
    }

    @Test
    void getIndex() {
        assert(bulbizzare.getIndex() == 0);
    }

    @Test
    void getName() {
        assert(bulbizzare.getName().equals("Bulbizzare"));
    }

    @Test
    void getAttack() {
        assert(bulbizzare.getAttack() == 126);
    }

    @Test
    void getDefense() {
        assert(bulbizzare.getDefense() == 126);
    }

    @Test
    void getStamina() {
        assert(bulbizzare.getStamina() == 90);
    }
}