import java.util.*;

public class Squirtle extends Water {

    public Squirtle() {
	setName("SQUIRTLE");
    }

    public String watergun(BaseChar opponent) {
	return moveMaker(opponent, "WATER GUN", "Water", 40, 100);
    }
    
    public String surf(BaseChar opponent) {
	return moveMaker(opponent, "SURF", "Water", 80, 75);
    }

    public String hydrocannon(BaseChar opponent) {
	return moveMaker(opponent, "HYDRO CANNON", "Water", 120, 75);
    }

    public boolean useMove(String move, BaseChar opponent) {
	if (move.equals("water gun")) {
	    System.out.println("\n" + watergun(opponent));
	    return true;
	}
	if (move.equals("surf")) {
	    System.out.println("\n" + surf(opponent));
	    return true;
	}
	if (move.equals("hydro cannon")) {
	    System.out.println("\n" + hydrocannon(opponent));
	    return true;
	}
	return false;
    }
    
    public void learnMoves(){
        moveLearner("WATER GUN",2,25);
	moveLearner("SURF",6,15);
	moveLearner("HYDRO CANNON",14,5);
    }

    public void evolve(Player player) {
        if (getLevel() == 10) {
	    System.out.println("What? " + this + " is evolving!");
	    int a = 0;
	    while (a<player.getPokemon().length && 
		   !player.getPokemon()[a].toString().equals("SQUIRTLE")) {
		a = a + 1;
	    }
	    Wartortle wartortle = new Wartortle();
	    wartortle.setMaxHealth(getMaxHealth());
	    wartortle.setMaxSpeed(getMaxSpeed());
	    wartortle.setMaxDefense(getMaxDefense());
	    wartortle.setMaxAttack(getMaxAttack());
	    wartortle.setHealth(getHealth());
	    wartortle.setSpeed(getSpeed());
	    wartortle.setDefense(getDefense());
	    wartortle.setAttack(getAttack());
	    System.out.println("Congratulations! Your " + this + " evolved into " + wartortle + "!");
	    player.setPokemon(wartortle,a);
	}
    }


}
