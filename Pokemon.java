import java.util.Random;


public class Pokemon{

	//attribute
	Random rand = new Random();
	private String type;
	private float weight;
	private String name;
	private String sound;
	protected float gainWeightStep;
	protected  String species;

	public Pokemon(String name , String species , String sound){
		weight = rand.nextInt(100)+1;
		this.name = name;
		this.sound = sound;
		this.species = species;
		this.gainWeightStep = 2;
	}

	public void eatFood(){
		weight +=  this.gainWeightStep;
	}

	public String getName(){
		return name;
	}

	public String getSpecies(){
		return species;
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
