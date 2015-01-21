import java.util.*;

public class Charmander extends Fire {
    
    private Random r = new Random();

    public Charmander() {
	setName("CHARMANDER");
    }

    public String ember(BaseChar opponent) {
	//locating PP to attack
	int n = 0;
	while (n < nummoves() && !getMoves()[n].equals("EMBER")) {
	    n = n + 1;
	}
	//the attack
	String s = "";
	if (r.nextInt(100) <= 100 && getPP()[n] > 0) {
	    int modifier = 1;
	    int crit = r.nextInt(10);
	    if (crit == 0) {
		modifier = modifier * 2;
	    }
	    if (opponent.getWeakness().equals("Fire")) {
		modifier = modifier * 2;
	    }
	    if (opponent.getResistance().equals("Fire")) {
		modifier = modifier/2;
	    }
	    if (this.getType().equals("Fire")) {
		modifier = modifier * 2;
	    }
	    int newHealth = opponent.getHealth() -
		(super.damage(opponent,40)* modifier);
	    opponent.setHealth(newHealth);
	    s = this + " used EMBER!";
	    if (opponent.getWeakness() == "Fire") {
		 s = s + "\nIt's super effective!";
	    }
	    if (opponent.getResistance() == "Fire") {
	         s = s + "\nIt's super effective!";
	    }
	    if (crit == 0) {
		s = s + "\nIt's a critical hit!";
	    }   
	} else {
	    if (getPP()[n] == 0) {
		s = this + " has no more PP for EMBER!";
	    } else {
		s = this + " used EMBER! But it missed!";
	    }
	}
	//subtracting PP
	if (this.getPP()[n] > 0) {
	    int newPP = this.getPP()[n] - 1;
	    this.setPP(n,newPP);
	}
	return s;
    }

    public boolean useMove(String move, BaseChar opponent) {
	if (move.equals("ember")) {
	    System.out.println("\n" + ember(opponent));
	    return true;
	}
	return false;
    }
    
    public void learnMoves(){
	if (getLevel() == 2){
	    int n = 0;
	    while (n < nummoves() && getMoves()[n] != null) {
		n = n + 1;
	    }
	    if (n <= 4) {
		System.out.println(this + " learned EMBER!");
		setMove(n,"EMBER");
		setPP(n,25);
		setMaxPP(n,25);
	    } else {
		System.out.println(this + " wants to learn EMBER! However, " + this + " already knows four moves. Delete to a move to make room for EMBER?");
	    }
	}
    }
    
	 
}
