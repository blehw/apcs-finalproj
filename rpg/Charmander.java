import java.util.*;

public class Charmander extends Fire {

    private String[] moves = new String[4];
    private Random r = new Random();

    public Charmander() {
	setName("CHARMANDER");
	moves[0] = "TACKLE";
	moves[1] = "RECOVER";
    }

    public String getMoves0() {
	return moves[0];
    }

    public String getMoves1() {
	return moves[1];
    }
    
    public String getMoves2() {
	return moves[2];
    }

    public String getMoves3() {
	return moves[3];
    }

     public int ember(BaseChar opponent) {
	String s = "";
	int modifier = 1;
	if (opponent.getWeakness() == "Fire") {
	    modifier = modifier * 2;
	}
	if (opponent.getResistance() == "Fire") {
	    modifier = modifier/2;
	}
	if (r.nextInt(100) <= 100) {
	    int newHealth = opponent.getHealth() - super.damage(opponent,40);
	    opponent.setHealth(newHealth);
	    s = this + " used EMBER!";
	}
	return s;
    }
	 
}
