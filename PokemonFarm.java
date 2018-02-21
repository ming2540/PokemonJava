import java.io.*;
import java.util.*;


public class PokemonFarm
{
	ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
	private Pokemon pokemon;

	public void add(String pokemonType , String pokemonName){

		if(pokemonType.equals("lizardon"))
				pokemon = new Lizardon(pokemonName);
		else if(pokemonType.equals("mew"))
				pokemon = new Mew(pokemonName);
		else if(pokemonType.equals("pidgey"))
				pokemon = new Pidgey(pokemonName);

		pokemons.add(pokemon);
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
				pokemonList.eatFood(2);
			}
		}
		else for(Pokemon pokemonList : pokemons){
			if(nameInput.equals(pokemonList.getName())){
				pokemonList.eatFood(2);
			}
		}

	}



}
