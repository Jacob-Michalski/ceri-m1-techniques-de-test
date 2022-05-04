package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;

class IPokedexFactoryTest {

    @Mock
    PokemonMetadataProvider metadataProvider;

    @Mock
    PokemonFactory pokemonFactory;

    @Test
    void createPokedex() {
        IPokedexFactory pokedexFactory = new PokedexFactory();
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assert(pokedex != null);
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(42));
    }

}