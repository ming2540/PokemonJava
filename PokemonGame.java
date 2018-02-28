import java.io.*;
import java.util.Scanner;

public class PokemonGame{
	public static void main(String[] args) {
		
		Bag bag = new Bag();
		PokemonFarm pokemonFarm = new PokemonFarm();
		CommandParser commandParser = new CommandParser(pokemonFarm ,bag);

		commandParser.run();


	}
}