import java.io.*;
import java.util.Scanner;

public class PokemonGame{
	public static void main(String[] args) {
		
		PokemonFarm pokemonFarm = new PokemonFarm();
		CommandParser commandParser = new CommandParser(pokemonFarm);

		commandParser.run();


	}
}