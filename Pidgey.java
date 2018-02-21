public class Pidgey extends Pokemon{
	private int form = 1;

	public Pidgey(String name , int form){
		if(form == 1)
			super (name , "Caw!" , "Pidgey");
		else if(form ==2)
			super (name , "Caw Caw !" , "Pigeon");
	}

}