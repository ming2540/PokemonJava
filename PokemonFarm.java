import java.io.*;
import java.util.*;


public class PokemonFarm
{
	ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
	private Pokemon pokemon;
	
	public void add(String pokemonType , String pokemonName , Pokemon pokemonInput){
		
		if(pokemonType.isEmpty()){
			pokemons.add(pokemonInput);
		}
		else {
			if(pokemonType.equalsIgnoreCase("lizardon"))
				pokemon = new Lizardon(pokemonName);
			else if(pokemonType.equalsIgnoreCase("mew"))
				pokemon = new Mew(pokemonName);
			else if(pokemonType.equalsIgnoreCase("pidgey"))
				pokemon = new Pidgey(pokemonName);
			else if(pokemonType.equalsIgnoreCase("pigeon"))
				pokemon = new Pigeon(pokemonName);
			
			pokemons.add(pokemon);
		}
		
		System.out.println("Added");
		
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
	
	public void show(){
		for(Pokemon pokemonList : pokemons){
			System.out.println("This " + pokemonList.getName() + " say : " + pokemonList.makeSound() + " , weight = " + pokemonList.getWeight());
		}
	}
	
	public void feed(int index){
		pokemons.get(index).eatFood();
	}
	
	
	public void rename(int index , String input){
		pokemons.get(index).setName(input);	
	}

	public String getPokemonName( int index){
		return pokemons.get(index).getName();
	}

	public String getPokemonSpecie(int index){
		return pokemons.get(index).getSpecies();
	}

	public float getPokemonWeight(int index){
		return pokemons.get(index).getWeight();
	}
	
	public String getPokemonSound(int index){
		return "This " + pokemons.get(index).getName() + " Say " + pokemons.get(index).makeSound();
	}
	
	
	
	
}
