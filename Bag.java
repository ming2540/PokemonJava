import java.io.*;
import java.util.*;


public class Bag
{
	ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
	ArrayList<PokeBall> pokeBalls = new ArrayList<PokeBall>();
    
    
	public void add(Pokemon pokemonInput){
		pokemons.add(pokemonInput);
		System.out.println("Added to bag");
		
	}
	
	public void remove(String nameInput){
		for(Pokemon pokemonList : pokemons){
			if(nameInput.equals(pokemonList.getName())){
				pokemons.remove(pokemonList);
				break;
			}
		}
		
		System.out.println("Deleted");
	}
	
    public Pokemon toFarm(){
        Pokemon pokeBuffer;

        return 
    }
	
}
