import java.util.*;

public class Charmander extends Fire {
    
    private Random r = new Random();

    public Charmander() {
	setName("CHARMANDER");
    }

    public String ember(BaseChar opponent) {
	return moveMaker(opponent,"EMBER","Fire",100);
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
