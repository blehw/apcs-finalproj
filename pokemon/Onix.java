import java.util.*;

public class Onix extends Rock {

    public Onix() {
	setName("ONIX");
    }

    public String rocktomb(BaseChar opponent) {
	return moveMaker(opponent,"ROCK TOMB","Rock",60,95);
    }

    public String smackdown(BaseChar opponent) {
	return moveMaker(opponent,"SMACK DOWN","Rock",50,100);
    }

    public boolean useMove(String move, BaseChar opponent) {
	if (move.equals("rock tomb")) {
	    System.out.println("\n" + rocktomb(opponent));
	    return true;
	}
	if (move.equals("smack down")) {
	    System.out.println("\n" + smackdown(opponent));
	    return true;
	}
	return false;
    }

    public void learnMoves(){
        moveLearner("ROCK TOMB",3,15);
	moveLearner("SMACK DOWN",5,15);
    }

}

