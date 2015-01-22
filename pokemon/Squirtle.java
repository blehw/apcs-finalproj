import java.util.*;

public class Squirtle extends Water {

    private Random r = new Random();

    public Squirtle() {
	setName("SQUIRTLE");
    }

    public String watergun(BaseChar opponent) {
	return moveMaker(opponent, "WATER GUN", "Water", 40, 100);
    }

    public boolean useMove(String move, BaseChar opponent) {
	if (move.equals("water gun")) {
	    System.out.println("\n" + watergun(opponent));
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
		System.out.println(this + " learned WATER GUN!");
		setMove(n,"WATER GUN");
		setPP(n,25);
		setMaxPP(n,25);
	    } else {
		System.out.println(this + " wants to learn WATER GUN! However, " + this + " already knows four moves. Delete to a move to make room for WATER GUN?");
	    }
	}
    }


}
