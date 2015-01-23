import java.util.*;

public class Horsea extends Water {

    public Horsea() {
	setName("HORSEA");
    }

    public String bubble(BaseChar opponent) {
	return moveMaker(opponent,"BUBBLE","Water",40,100);
    }

    public String brine(BaseChar opponent) {
	return moveMaker(opponent,"BRINE","Water",65,100);
    }

    public boolean useMove(String move, BaseChar opponent) {
	if (move.equals("bubble")) {
	    System.out.println("\n" + bubble(opponent));
	    return true;
	}
	if (move.equals("brine")) {
	    System.out.println("\n" + brine(opponent));
	    return true;
	}
	return false;
    }

    public void learnMoves(){
        moveLearner("BUBBLE",2,30);
	moveLearner("BRINE",6,10);
    }
    
}
