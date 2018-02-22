import java.util.Random;
import java.util.Scanner;


public class Brush {

    Scanner scanner = new Scanner(System.in);

    Random rand = new Random();
    private Pokemon wildPokemon;
    private double mood ;
    private String choice;

// constructor
    public Brush(){
       
    }

    public void brushEncounter(){
         int pokemonSpecies = rand.nextInt(3);

        if(pokemonSpecies == 0)
            wildPokemon = new Mew("Wild Mew");
        else if(pokemonSpecies == 1)
            wildPokemon = new Lizardon("Wild Lizardon");
        else if(pokemonSpecies == 2)
            wildPokemon = new Pidgey("Wild Pidgey");
        
        mood = (rand.nextInt(10)+1) /10.0; 

        System.out.println("You found "+ wildPokemon.getName() +"!");

        System.out.println("What is your choice?");
        System.out.print("catch - run : ");
        choice = scanner.nextLine();

        if(choice.equals("chatch")){
            //catching
        }
        else if(choice.equals("run")){
            System.out.println("You run away from " + wildPokemon.getName());
            return ;
        }

    }


} 