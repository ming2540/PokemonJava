import java.util.Random;

public class Brush {

    Random rand = new Random();
    private Pokemon wildPokemon;
    private float mood ;

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
        
        mood = rand.nextFloat() * (1.0 - 0.0); 

        System.out.println("You found "+ wildPokemon.getName +"!");

    }


} 