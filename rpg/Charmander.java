import java.util.*;

public class Charmander extends Fire {
    
    private Random r = new Random();

    public Charmander() {
	setName("CHARMANDER");
	setMoves0("TACKLE");
	setMoves1("RECOVER");
    }

     public String ember(BaseChar opponent) {
	String s = "";
	int modifier = 1;
	if (opponent.getWeakness() == "Fire") {
	    modifier = modifier * 2;
	}
	if (opponent.getResistance() == "Fire") {
	    modifier = modifier/2;
	}
	if (r.nextInt(100) <= 100) {
	    int newHealth = opponent.getHealth() -
		(super.damage(opponent,40)*modifier);
	    opponent.setHealth(newHealth);
	    s = this + " used EMBER!";
	}
	return s;
    }
	 
}
