import java.util.*;

public class Geodude extends Rock {

    public Geodude() {
	setName("GEODUDE");
    }

    public String rockthrow(BaseChar opponent) {
	return moveMaker(opponent,"ROCK THROW","Rock",50,90);
    }

    public boolean useMove(String move, BaseChar opponent) {
	if (move.equals("rock throw")) {
	    System.out.println("\n" + rockthrow(opponent));
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
		System.out.println(this + " learned ROCK THROW!");
		setMove(n,"ROCK THROW");
		setPP(n,15);
		setMaxPP(n,15);
	    } else {
		System.out.println(this + " wants to learn ROCK THROW! However, " + this + " already knows four moves. Delete to a move to make room for ROCK THROW?");
	    }
	}
    }
}
