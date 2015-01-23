import java.util.*;

public class Bulbasaur extends Grass {

    private Random r = new Random();

    public Bulbasaur() {
	setName("BULBASAUR");
    }

    public String vinewhip(BaseChar opponent){
	return moveMaker(opponent, "VINEWHIP", "Grass", 40, 100);
    }

    public String leafblade(BaseChar opponent){
	return moveMaker(opponent, "LEAF BLADE", "Grass", 80, 75);
    }

    public String frenzyplant(BaseChar opponent){
	return moveMaker(opponent, "FRENZY PLANT", "Grass", 120, 50);
    }

    public boolean useMove(String move, BaseChar opponent) {
	if (move.equals("vinewhip")) {
	    System.out.println("\n" + vinewhip(opponent));
	    return true;
	}
	if (move.equals("leaf blade")) {
	    System.out.println("\n" + leafblade(opponent));
	    return true;
	}
	if (move.equals("frenzy plant")) {
	    System.out.println("\n" + frenzyplant(opponent));
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
		System.out.println(this + " learned VINEWHIP!");
		setMove(n,"VINEWHIP");
		setPP(n,25);
		setMaxPP(n,25);
	    } else {
		System.out.println(this + " wants to learn VINEWHIP! However, " + this + " already knows four moves. Delete to a move to make room for VINEWHIP?");
	    }
	}
    }

    public void evolve(Player player) {
        if (getLevel() == 10) {
	    System.out.println("What? " + this + " is evolving!");
	    int a = 0;
	    while (a<player.getPokemon().length && 
		   !player.getPokemon()[a].toString().equals("BULBASAUR")) {
		a = a + 1;
	    }
	    Ivysaur ivysaur = new Ivysaur();
	    ivysaur.setMaxHealth(getMaxHealth());
	    ivysaur.setMaxSpeed(getMaxSpeed());
	    ivysaur.setMaxDefense(getMaxDefense());
	    ivysaur.setMaxAttack(getMaxAttack());
	    ivysaur.setHealth(getHealth());
	    ivysaur.setSpeed(getSpeed());
	    ivysaur.setDefense(getDefense());
	    ivysaur.setAttack(getAttack());
	    System.out.println("Congratulations! Your " + this + " evolved into " + ivysaur + "!");
	    player.setPokemon(ivysaur,a);
	}
    }
    

}      
