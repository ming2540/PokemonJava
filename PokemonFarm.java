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
	
	public void feed(String nameInput){
		if(nameInput.equals("all")){
			for(Pokemon pokemonList : pokemons){
				pokemonList.eatFood(pokemonList.gainWeightStep);
			}
		}
		else for(Pokemon pokemonList : pokemons){
			if(nameInput.equals(pokemonList.getName())){
				pokemonList.eatFood(pokemonList.gainWeightStep);
			}
		}
	}
	
	
	public void rename(String nameInput, String pokemonInput){
		for(Pokemon pokemonList : pokemons){
			if(pokemonInput.equals(pokemonList.getName())){
				pokemonList.setName(nameInput);
			}
		}
		
	}
	
	
	
	
	
	
	
	
}
