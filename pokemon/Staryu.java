import java.util.*;

public class Staryu extends Water {

    public Staryu() {
	setName("STARYU");
    }

    public String watergun(BaseChar opponent) {
	return moveMaker(opponent,"WATER GUN","Water",40,100);
    }

    public String gyroball(BaseChar opponent) {
	return moveMaker(opponent,"GYRO BALL","Steel",55,10);
    }

    public String bubblebeam(BaseChar opponent) {
	return moveMaker(opponent,"BUBBLE BEAM","Water",65,100);
    }

    public boolean useMove(String move, BaseChar opponent) {
	if (move.equals("watergun")) {
	    System.out.println("\n" + watergun(opponent));
	    return true;
	}
	if (move.equals("gyro ball")) {
	    System.out.println("\n" + gyroball(opponent));
	    return true;
	}
	if (move.equals("bubble beam")) {
	    System.out.println("\n" + bubblebeam(opponent));
	    return true;
	}
	return false;
    }

    public void learnMoves(){
        moveLearner("WATER GUN",2,25);
	moveLearner("GYRO BALL",4,20);
	moveLearner("BUBBLE BEAM",8,20);
    }

}
