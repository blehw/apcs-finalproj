import java.util.*;

public class Bulbasaur extends Grass {

    private Random r = new Random();

    public Bulbasaur() {
	setName("BULBASAUR");
    }

    public String vinewhip(BaseChar opponent){
	return moveMaker(opponent, "VINEWHIP", "Grass", 40, 100);
    }

    public String leafblade(BaseChar opponent){
	return moveMaker(opponent, "LEAFBLADE", "Grass", 80, 75);
    }

    public String frenzyplant(BaseChar opponent){
	return moveMaker(opponent, "FRENZYPLANT", "Grass", 120, 50);
    }

    public boolean useMove(String move, BaseChar opponent) {
	if (move.equals("vinewhip")) {
	    System.out.println("\n" + vinewhip(opponent));
	    return true;
	}
	if (move.equals("leafblade")) {
	    System.out.println("\n" + leafblade(opponent));
	    return true;
	}
	if (move.equals("frenzyplant")) {
	    System.out.println("\n" + frenzyplant(opponent));
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
