import java.util.*;

public class Bulbasaur extends Grass {

    private Random r = new Random();

    public Bulbasaur() {
	setName("BULBASAUR");
    }

    public String vinewhip(BaseChar opponent){
	String s = "";
	int modifier = 1;
	if (opponent.getWeakness() == "Grass"){
	    modifier = modifier * 2;
	}
	if (opponent.getResistance() == "Grass"){
	    modifier = modifier / 2;
	}
	if (r.nextInt(100) <= 100) {
	    int newHealth = opponent.getHealth() -
		(super.damage(opponent, 40) * modifier);
	    opponent.setHealth(newHealth);
	    s = this + " used VINEWHIP!";
	}
	return s;
    }


}      
