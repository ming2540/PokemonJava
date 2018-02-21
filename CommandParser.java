import java.io.*;
import java.util.*;

public class CommandParser {

	Scanner scanner = new Scanner(System.in);
	private PokemonFarm pokemonFarm = new PokemonFarm();
	private String command = "";
	private String nameInput = "";
	private String typeInput = "";

	public CommandParser(PokemonFarm pokemonFarm){
		this.pokemonFarm = pokemonFarm;
	}

	public void run(){

		System.out.println("Welcome to PokemonGame");

		while(!command.equals("exit")){
			System.out.println("input command : add  ,show , feed  ,delete , exit");
			command = scanner.nextLine();

			if(command.equals("add")){
				System.out.print("select your pokemon too add : 'lizardon' ,  'mew'  , 'pidgey'(bird) : ");
				typeInput = scanner.nextLine();
				System.out.print("Enter it's name : ");
				nameInput = scanner.nextLine();
				pokemonFarm.add(typeInput , nameInput);
			}

			else if(command.equals("delete")){
				System.out.print("Which one? : ");
				nameInput = scanner.nextLine();
				pokemonFarm.remove(nameInput);
			}

			else if(command.equals("show")){
				pokemonFarm.show();
			}

			else if(command.equals("feed")){
				System.out.print("which one? (type 'all' for all) : ");
				nameInput = scanner.nextLine();
				pokemonFarm.feed(nameInput);
			}

		}
	}








}
