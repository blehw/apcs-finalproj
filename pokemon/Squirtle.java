import java.util.*;

public class Squirtle extends Water {

    private Random r = new Random();

    public Squirtle() {
	setName("SQUIRTLE");
    }

    public String watergun(BaseChar opponent) {
	String s = "";
	int modifier = 1;
	if (opponent.getWeakness() == "Water"){
	    modifier = modifier * 2;
	}
	if (opponent.getResistance() == "Water"){
	    modifier = modifier / 2;
	}
	if (r.nextInt(100) <= 100) {
	    int newHealth = opponent.getHealth() -
		(super.damage(opponent, 40) * modifier);
	    opponent.setHealth(newHealth);
	    s = this + " used WATERGUN!";
	}
	return s;
    }


}
