import java.io.*;
import java.util.*;

public class PewterCity {

    private String s;
    private Battle battle = new Battle();
    Scanner scan = new Scanner(System.in);

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
	    for (int k=0;i<player.getPokemon()[k].getMaxPP().length &&
		     player.getPokemon()[k].getMaxPP() != null;i++) {
		player.getPokemon()[k].setPP(k,player.getPokemon()[k].getMaxPP()[k]);
	    }
	}
	System.out.println("~healing music~");
	System.out.println("NURSE: All healed up!");
	return "";
    }

    public String walk(Player player, String source) {
	if (source.equals("pokemon center")) {
	    System.out.println("Where do you want to go?");
	    System.out.println("BROCK'S GYM   PALLET TOWN   ROCKY ROCK TRAINING PLACE   CERULEAN CITY   SAVE");
	}
	return "";
    }

}
