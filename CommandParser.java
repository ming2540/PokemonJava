import java.io.*;
import java.util.*;



public class CommandParser {

	Scanner scanner = new Scanner(System.in);
	private PokemonFarm pokemonFarm = new PokemonFarm();
	private String command = "";
	private String nameInput = "";
	private String typeInput = "";
	private Brush brush;  
	private Bag bag = new Bag();



	public CommandParser(PokemonFarm pokemonFarm, Bag bag){
		this.pokemonFarm = pokemonFarm;
		this.bag = bag;
	}

	public void run(){

		System.out.println("Welcome to PokemonGame");

		while(!command.equalsIgnoreCase("exit")){
			System.out.println("input command : \n1.add \n2.show\n3.feed\n4.delete\n5.find (find new pokemon)\n6.rename\n7.exit ");

			command = scanner.nextLine();

			if(command.equalsIgnoreCase("add")){
				System.out.print("select your pokemon too add : 'lizardon' ,  'mew'  , 'pidgey'(bird) : ");
				typeInput = scanner.nextLine();
				System.out.print("Enter it's name : ");
				nameInput = scanner.nextLine();
				pokemonFarm.add(typeInput , nameInput , null);
			}

			else if(command.equalsIgnoreCase("delete")){
				System.out.print("Which one? : ");
				nameInput = scanner.nextLine();
				pokemonFarm.remove(nameInput);
			}

			else if(command.equalsIgnoreCase("show")){
				pokemonFarm.show();
			}

			else if(command.equalsIgnoreCase("feed")){
				System.out.print("which one? (type 'all' for all) : ");
				nameInput = scanner.nextLine();
				pokemonFarm.feed(nameInput);
			}

			else if(command.equalsIgnoreCase("find")){
				brush = new Brush();
				brush.brushEncounter();
				while(!command.equalsIgnoreCase("run")){
					System.out.println("What is your choice?");
					System.out.print("catch - run : ");
					command = scanner.nextLine();

					if(command.equalsIgnoreCase("catch")){
						brush.catchPokemon();
						if(brush.isCatchSuccess()==true){
							System.out.print("It will go to your farm :");
							bag.add(brush.gotWildPokemon());
							break;
						}
					}
					if(command.equalsIgnoreCase("run")){
						System.out.println("You ran away!");
					}
				}
				
			}

			else if(command.equalsIgnoreCase("rename")){
				System.out.print("Which Pokemon? :");
				typeInput = scanner.nextLine();
				System.out.print("Inputname : ");
				nameInput = scanner.nextLine();
				pokemonFarm.rename(nameInput , typeInput);

			}

			else if(command.equalsIgnoreCase("put")){
				
			}

		}
	}








}
