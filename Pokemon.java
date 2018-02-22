import java.util.Random;


public class Pokemon{

	//attribute
	Random rand = new Random();
	private float weight;
	private String name;
	private String sound;
	// private float gainWeightStep;

	public Pokemon(String name , String sound ){
		weight = rand.nextInt(100)+1;
		this.name = name;
		this.sound = sound;
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
	
	public void setName(String nameInput){
		this.name = nameInput;
	}
	

}
