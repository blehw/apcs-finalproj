import java.util.*;

public class Bulbasaur extends Grass {

    private Random r = new Random();
1
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
	return moveMaker(opponent, "FRENZY PLANT", "Grass", 120, 75);
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
	moveLearner("VINEWHIP",2,25);
	moveLearner("LEAF BLADE",7,15);
	moveLearner("FRENZY PLANT",13,5);
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
	    ivysaur.setLevel(getLevel());
	    ivysaur.setMaxHealth(getMaxHealth());
	    ivysaur.setMaxSpeed(getMaxSpeed());
	    ivysaur.setMaxDefense(getMaxDefense());
	    ivysaur.setMaxAttack(getMaxAttack());
	    ivysaur.setHealth(getHealth());
	    ivysaur.setSpeed(getSpeed());
	    ivysaur.setDefense(getDefense());
	    ivysaur.setAttack(getAttack());
	    ivysaur.setMove(1,"VINEWHIP");
	    ivysaur.setPP(1,25);
	    ivysaur.setMaxPP(1,25);
	    ivysaur.setMove(1,"LEAF BLADE");
	    ivysaur.setPP(2,15);
	    ivysaur.setMaxPP(2,15);
	    System.out.println("Congratulations! Your " + this + " evolved into " + ivysaur + "!");
	    player.setPokemon(ivysaur,a);
	}
    }
    

}      
