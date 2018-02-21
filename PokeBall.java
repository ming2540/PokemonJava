
public class PokeBall {

    private int typeOfPokeBall ;
    private String name  = "";
    private float chance  ;

    public PokeBall(int type){
        this.typeOfPokeBall = type;
        if(this.typeOfPokeBall ==1){
             this.name = "PokeBall";
             this.chance = 0.8;
        }
        else if(this.typeOfPokeBall == 2){
            this.name = "GreatBall";
            this.chance = 0.9;
        }
        else if(this.typeOfPokeBall == 3){
            this.name = "UltraBall";
            this.chance = 1.0;
        }

    }
}