import java.io.*;
import java.util.*;

public class PewterCity {

    private String s;
    private Battle battle = new Battle();
    Scanner scan = new Scanner(System.in);
    Random r = new Random();

    public String routine(Player player) {
	player.setLocation("Pewter City");	
	System.out.println("You have reached PEWTER CITY");
	pokemoncenter(player);
	return "";
    }

    public String pokemoncenter(Player player) {
	System.out.println("NURSE: Hello! Welcome to the POKEMON CENTER. We restore your POKEMON to full health, free of charge. Our health care system sure is great. Here, let me take care of your POKEMON.");
	for (int i=0;i<player.getPokemon().length &&
		 player.getPokemon()[i] != null;i++) {
	    player.getPokemon()[i].setHealth(player.getPokemon()[i].getMaxHealth());
	    player.getPokemon()[i].setPP(0,player.getPokemon()[i].getMaxPP()[0]);
	    if (player.getPokemon()[i].getMaxPP()[1] != 0) {
		player.getPokemon()[i].setPP(1,player.getPokemon()[i].getMaxPP()[1]);
	    }
	    if (player.getPokemon()[i].getMaxPP()[2] != 0) {
		player.getPokemon()[i].setPP(1,player.getPokemon()[i].getMaxPP()[2]);
	    }
	    if (player.getPokemon()[i].getMaxPP()[3] != 0) {
		player.getPokemon()[i].setPP(1,player.getPokemon()[i].getMaxPP()[3]);
	    }
	}
	System.out.println("~healing music~");
	System.out.println("NURSE: All healed up!");
	walk(player,"pokemon center");
	return "";
    }

    public String pokemart(Player player) {
	System.out.println("CASHIER: TAKE DIS POKEBALL N CATCH POKEMANS WID IT");
	player.setBag("POKEBALL",0);
	player.setBagNum(1,0);
	return "";
    }

    public String training(Player player) {
	int meters = 0;
	System.out.println("You enter the ROCKY ROCK TRAINING PLACE, an area with rocky terrain. A sign reads, ROCKY ROCK TRAINING PLACE: THE 72ND TOUGHEST PLACE ON EARTH.");
	System.out.println("Do you want to WALK FORWARDS or WALK BACKWARDS (to PEWTER CITY)?");
	s = scan.nextLine();
	s = s.toLowerCase();
	if (meters >= 300) {
	    System.out.println("OUCH. There is a large, rocky mountain in your way. How did you miss that?");
	}
	if (s.equals("walk forwards") && meters < 300) {
	    meters =  meters + 50;
	    System.out.println("You walked 50 meters.");
	    System.out.println("You are " + meters + " meters from PEWTER CITY.");
	    int rand = r.nextInt(4);
	    if (rand == 0) {
		//BLAH BLAH BLAH 
	    }
	    training(player);
	}
	if (s.equals("walk backwards")) {
	    meters = meters - 50;
	    System.out.println("You walked 50 meters.");
	    if (meters <= 0) {
		System.out.println("You have reached PEWTER CITY.");
		//STUFF 
		walk(player,"BLAH BLAH BLAH");
	    }
	    System.out.println("You are " + meters + " meters from PEWTER CITY.");
	    int rand = r.nextInt(4);
	    if (rand == 0) {
		//BLAH BLAH BLAH
	    }
	    training(player);;
	}
        if (s.equals("pokemon")) {
	    System.out.println(player.getPokemonStatus());
	    routine(player);
	} 
	if (s.equals("exit game")) {
		System.exit(0);
	} else {
	    System.out.println("You can't walk in a " + s + " direction!");
	    routine(player);
	}
	return "";
    }
    public String walk(Player player, String source) {
	if (source.equals("pokemon center")) {
	    System.out.println("Where do you want to go?");
	    System.out.println("POKEMART   BROCK'S GYM   PALLET TOWN   ROCKY ROCK TRAINING PLACE   CERULEAN CITY   SAVE");
	}
	if (s.equals("pokemon")) {
	    System.out.println(player.getPokemonStatus());
	    routine(player);
	} 
	if (s.equals("exit game")) {
		System.exit(0);
	} else {
	    System.out.println("You can't go there!");
	    walk(player,source);
	}
	return "";
    }

}
