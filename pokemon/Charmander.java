import java.util.*;

public class Charmander extends Fire {
    
    private Random r = new Random();

    public Charmander() {
	setName("CHARMANDER");
    }

    public String ember(BaseChar opponent) {
	return moveMaker(opponent,"EMBER","Fire",40,100);
    }

    public String flamethrower(BaseChar opponent){
	return moveMaker(opponent,"FLAMETHROWER","Fire", 80,75);
    }

    public String blastburn(BaseChar opponent){
	return moveMaker(opponent, "BLAST BURN", "Fire", 120, 75);
    }

    public boolean useMove(String move, BaseChar opponent) {
	if (move.equals("ember")) {
	    System.out.println("\n" + ember(opponent));
	    return true;
	}
	if (move.equals("flamethrower")) {
	    System.out.println("\n" + flamethrower(opponent));
	    return true;
	}
	if (move.equals("blast burn")) {
	    System.out.println("\n" + blastburn(opponent));
	    return true;
	}
	return false;
    }
    
    public void learnMoves(){
	moveLearner("EMBER",2,25);
	moveLearner("FLAMETHROWER",8,15);
	moveLearner("BLAST BURN",12,5);
    }

    public void evolve(Player player) {
        if (getLevel() == 10) {
	    System.out.println("What? " + this + " is evolving!");
	    int a = 0;
	    while (a<player.getPokemon().length && 
		   !player.getPokemon()[a].toString().equals("CHARMANDER")) {
		a = a + 1;
	    }
	    Charmander charmander = new Charmander();
	    charmander.setMaxHealth(getMaxHealth());
	    charmander.setMaxSpeed(getMaxSpeed());
	    charmander.setMaxDefense(getMaxDefense());
	    charmander.setMaxAttack(getMaxAttack());
	    charmander.setHealth(getHealth());
	    charmander.setSpeed(getSpeed());
	    charmander.setDefense(getDefense());
	    charmander.setAttack(getAttack());
	    System.out.println("Congratulations! Your " + this + " evolved into " + charmander + "!");
	    player.setPokemon(charmander,a);
	}
    }

	 
}
