import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Brush {

    Scanner scanner = new Scanner(System.in);

    Random rand = new Random();
    private Pokemon wildPokemon;
    private double mood ;
    private String choice;
    private PokeBall pokeBall;

// constructor
    public Brush(){
    }

    public void brushEncounter(){
         int pokemonSpecies = rand.nextInt(4);

        if(pokemonSpecies == 0)
            wildPokemon = new Mew("Wild Mew");
        else if(pokemonSpecies == 1)
            wildPokemon = new Lizardon("Wild Lizardon");
        else if(pokemonSpecies == 2)
            wildPokemon = new Pidgey("Wild Pidgey");
        else if(pokemonSpecies == 3)
            wildPokemon = new Pigeon("Wild Pigeon");
        
        mood = (rand.nextInt(10)+1) /10.0; 

        System.out.println("You found "+ wildPokemon.getName() +"!");


    }

    public void catchPokemon(){
        mood += 0.05;
        pokeBall = new PokeBall(rand.nextInt(3));
        System.out.println("You throw " + pokeBall.getName() + "!");

        if(isCatchSuccess() == true){
            System.out.println("Gotcha! You got " + wildPokemon.getName());
           
        }
        else {
            System.out.println("It break free! try again");
        }
    }

    public boolean isCatchSuccess(){

        if((this.mood * (pokeBall.getChance())) > 0.5){
            return true;
        }

        else {
            return false;
        }
    }

    public Pokemon gotWildPokemon(){
        return wildPokemon;
    }

} 