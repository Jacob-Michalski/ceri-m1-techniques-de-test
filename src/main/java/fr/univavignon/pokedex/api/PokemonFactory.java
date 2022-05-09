package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    public PokemonFactory() {}

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try {
            PokemonMetadata pokemonMetadata = PokemonMetadataProvider.getPokemonMetadataProvider().getPokemonMetadata(index);
            double iv = Math.random();
            int att = (int) (pokemonMetadata.getAttack()+pokemonMetadata.getAttack()*iv);
            int def = (int) (pokemonMetadata.getDefense()+pokemonMetadata.getDefense()*iv);
            int sta = (int) (pokemonMetadata.getStamina()+pokemonMetadata.getStamina()*iv);
            return new Pokemon(index, pokemonMetadata.getName(), att , def,
                    sta, cp, hp, dust, candy, iv);
        }
        catch (PokedexException pokedexException) {
            System.out.println(pokedexException.getMessage());
            return null;
        }
    }
}
