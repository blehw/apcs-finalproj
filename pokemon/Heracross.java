import java.util.*;

public class Heracross extends Bug {

    public Heracross() {
	setName("HERACROSS");
    }

    public String hornattack(BaseChar opponent) {
	return moveMaker(opponent,"HORN ATTACK","Bug",65,100);
    }

    public String megahorn(BaseChar opponent) {
	return moveMaker(opponent, "MEGAHORN","Bug",120,85);
    }
    
    public boolean useMove(String move, BaseChar opponent) {
	if (move.equals("horn attack")) {
	    System.out.println("\n" + hornattack(opponent));
	    return true;
	}
	if (move.equals("megahorn")) {
	    System.out.println("\n" + megahorn(opponent));
	    return true;
	}
	return false;
    }

    public void learnMoves(){
        moveLearner("HORN ATTACK",8,25);
	moveLearner("MEGAHORN",18,10);
    }

}
