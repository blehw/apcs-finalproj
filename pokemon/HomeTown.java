import java.io.*;
import java.util.*;

public class HomeTown {

    private String s; 

    public String go(Scanner scan, Player player, Player rival) {
	System.out.println("Where do you want to go?\nPROF. OAK'S LAB");
	s = scan.nextLine();
	s = s.toLowerCase();
	if (s.equals("prof. oak's lab")) {
	    System.out.println("PROF. OAK: Hello," + player + "! I heard you're going out! Well, you'll need to protect yourself. There are 3 POKEMON here! Haha! They are inside the POKE BALLS. When I was young, I was a serious POKEMON trainer. In my old age, I have only 3 left, but you can have one! Choose!");
	    System.out.println(rival+ ": Hey! Gramps! What about me?");
	    System.out.println("OAK: Be patient! " + rival + ", you can have one too!");
	    choose(scan,player,rival);
	} else {
	    System.out.println("You can't go there!");
	    go(scan,player,rival);
	}
	return "";
    }

    public String choose(Scanner scan, Player player, Player rival) {
	System.out.println("Which POKEMON do you want?\nBULBASAUR   CHARMANDER   SQUIRTLE");
	s = scan.nextLine();
	s = s.toLowerCase();
	if (s.equals("bulbasaur")) {
	    confirm(scan,player,rival);
	} else {
	    System.out.println("That POKEMON isn't there!");
	    choose(scan,player,rival);
	}
	return "";
    }

    public String confirm(Scanner scan, Player player, Player rival) {
	System.out.println("So you want the GRASS POKEMON, BULBASAUR?");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("yes")) {
		Bulbasaur bulbasaur = new Bulbasaur();
		System.out.println("Alright then!");
		player.setPokemon(bulbasaur,0);
	    } else {
		choose(scan,player,rival);
	    }
	return "";
    }
    
    public String routine(Player player, Player rival) {

	Scanner scan = new Scanner(System.in);

	System.out.println("MOM: Good morning," + player + ". Well, all children leave home some day. It said so on TV. PROF.OAK, next door, is looking for you.");
	System.out.println(go(scan,player,rival));
	
	return "";
	
    }

}


