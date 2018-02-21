import java.util.Random;


public class Pokemon{

	//attribute
	Random rand = new Random();
	private float weight;
	private String name;
	private String sound;

	public Pokemon(String name , String sound ,String species){
		weight = rand.nextInt(100)+1;
		this.name = name;
		this.sound = sound;
		this.species = species;
	}

	public void eatFood(float weightIncrease){
		weight +=  weightIncrease;
	}

	public String getName(){
		return name;
	}

	public String makeSound(){
		return sound;
	}

	public float getWeight(){
		return weight;
	}

}
