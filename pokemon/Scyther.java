import java.util.*;

public class Scyther extends Bug {
    
    public Scyther() {
	setName("SCYTHER");
    }

    public String furrycutter(BaseChar opponent) {
	return moveMaker(opponent,"FURY CUTTER","Bug",40,95);
    }

    public String xscissor(BaseChar opponent) {
	return moveMaker(opponent,"X-SCISSOR","Bug",80,100);
    }

    public boolean useMove(String move, BaseChar opponent) {
	if (move.equals("furry cutter")) {
	    System.out.println("\n" + furrycutter(opponent));
	    return true;
	}
	if (move.equals("x-scissor")) {
	    System.out.println("\n" + xscissor(opponent));
	    return true;
	}
	return false;
    }

    public void learnMoves(){
        moveLearner("FURRY CUTTER",8,20);
	moveLearner("X-SCISSOR",16,15);
    }

}
