import java.util.*;

public class Squirtle extends Water {

    private Random r = new Random();

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
	return moveMaker(opponent, "HYDROCANNON", "Water", 120, 50);
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
	if (move.equals("hydrocannon")) {
	    System.out.println("\n" + hydrocannon(opponent));
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
