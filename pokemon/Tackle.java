import java.util.*;

public class Tackle extends Move {

    private Random r = new Random();

    public String tackle(BaseChar opponent) {
	String s ="";
	if (r.nextInt(100) <= 95) {
	    int newHealth = opponent.getHealth() - opponent.damage(opponent,50);;
	    opponent.setHealth(newHealth);
	    s = this + " used TACKLE!";
	    
	} else {
	    s = this + " used TACKLE! But it missed!";
	}
	
	return s;
    }

}
