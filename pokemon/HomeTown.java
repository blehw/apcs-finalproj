import java.io.*;
import java.util.*;

public class HomeTown {

    private String s; 
    private Battle battle = new Battle();;
    Scanner scan = new Scanner(System.in);

    public String go(Player player, Player rival) {
	System.out.println("Where do you want to go?\nPROF. OAK'S LAB");
	s = scan.nextLine();
	s = s.toLowerCase();
	if (s.equals("prof. oak's lab")) {
	    System.out.println("PROF. OAK: Hello," + player + "! I heard you're going out! Well, you'll need to protect yourself. There are 3 POKEMON here! Haha! They are inside the POKE BALLS. When I was young, I was a serious POKEMON trainer. In my old age, I have only 3 left, but you can have one! Choose!");
	    System.out.println(rival+ ": Hey! Gramps! What about me?");
	    System.out.println("OAK: Be patient! " + rival + ", you can have one too!");
	    choose(player,rival);
	} else {
	    System.out.println("You can't go there!");
	    go(player,rival);
	}
	return "";
    }

    public String choose(Player player, Player rival) {
	System.out.println("Which POKEMON do you want?\nBULBASAUR   CHARMANDER   SQUIRTLE");
	s = scan.nextLine();
	s = s.toLowerCase();
	if (s.equals("bulbasaur")) {
	    confirm(player,rival,"bulbasaur");
	} 
	if (s.equals("charmander")) {
	    confirm(player,rival,"charmander");
	} 
	if (s.equals("squirtle")) {
	    confirm(player,rival,"squirtle");
	} else {
	    System.out.println("That POKEMON isn't there!");
	    choose(player,rival);
	}
	return "";
    }

    public String confirm(Player player, Player rival,String pokemon) {
	if (pokemon.equals("bulbasaur")) {
	    System.out.println("So you want the GRASS POKEMON, BULBASAUR?");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("yes")) {
		System.out.println("OAK: Alright then!");
		Bulbasaur bulbasaur = new Bulbasaur();
		player.setPokemon(bulbasaur,0);
		System.out.println(rival + ": I'll take this one then!");
		Charmander charmander = new Charmander();
		rival.setPokemon(charmander,0);
		leave(player,rival);
	    } else {
		choose(player,rival);
	    }	
	}
	else {
	    if (pokemon.equals("charmander")) {
		System.out.println("So you want the FIRE POKEMON, CHARMANDER?");
		s = scan.nextLine();
		s = s.toLowerCase();
		if (s.equals("yes")) {
		    System.out.println("OAK: Alright then!");
		    Charmander charmander = new Charmander();
		    player.setPokemon(charmander,0);
		    System.out.println(rival + ": I'll take this one then!");
		    Squirtle squirtle = new Squirtle();
		    rival.setPokemon(squirtle,0);
		    leave(player,rival);
		} else {
		    choose(player,rival);
		}	
	    }
	    else {
		if (pokemon.equals("squirtle")) {
		    System.out.println("So you want the WATER POKEMON, SQUIRTLE?");
		    s = scan.nextLine();
		    s = s.toLowerCase();
		    if (s.equals("yes")) {
			System.out.println("OAK: Alright then!");
			Squirtle squirtle = new Squirtle();
			player.setPokemon(squirtle,0);
			System.out.println(rival + ": I'll take this one then!");
		        Bulbasaur bulbasaur = new Bulbasaur();
			rival.setPokemon(bulbasaur,0);
			leave(player,rival);
		    } else {
			choose(player,rival);
		    }	
		}
	    }
	}
	return "";
    }

    public String leave(Player player, Player rival) {
	System.out.println(rival + ": Let's check out our POKEMON, " + player + "! Come on, I'll take you on!");
	System.out.println(battle.trainerRoutine(player,rival));
	if (player.getPokemon()[0].getHealth() == 0) {
	    System.out.print(rival + ": Yeah! I won!");
	} else {
	    System.out.print(rival + ": Aw, I lost.");
	}
	System.out.println(" Alright, I'll keep training with my POKEMON to get better. " + player + "! Gramps! See you later!");
	System.out.println("OAK: " + player + ", raise your POKEMON by training them! You can even catch POKEMON if you buy some POKEBALLS!");
        walk(player,"prof. oak's lab");
	return "";
    }

    public String home(Player player) {
	System.out.println("MOM: Hello, dear. You look tired. Why don't you take a rest?");
	for (int i=0;i<player.getPokemon().length &&
		 player.getPokemon()[i] != null;i++) {
	    player.getPokemon()[i].setHealth(player.getPokemon()[i].getMaxHealth());
	    for (int k=0;i<player.getPokemon()[k].getMaxPP().length &&
		     player.getPokemon()[k].getMaxPP() != null;i++) {
		player.getPokemon()[k].setPP(k,player.getPokemon()[k].getMaxPP()[k]);
	    }
	}
	System.out.println("MOM: There you go. All rested up.");
	walk(player,"home");
	return "";
    }

    public String lab(Player player) {
	System.out.println("OAK: Hello, " + player + ". I see your " + player.getPokemon()[0] + " is getting stronger. I wish you the best of luck in your journey!");
	walk(player,"prof. oak's lab");
	return "";
    }

    public String walk(Player player, String source) {
	if (source.equals("home")) {
	    System.out.println("Where do you want to go?");
	    System.out.println("PROF. OAK'S LAB   PEWTER CITY");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("prof. oak's lab")) {
		lab(player);
	    } 
	    if (s.equals("pewter city")) {
		Route1 route1 = new Route1();
		route1.routine(player);
	    } else {
		System.out.println("You can't go there!");
		walk(player,source);
	    }
	}
	if (source.equals("prof. oak's lab")) {
	    System.out.println("Where do you want to go?");
	    System.out.println("HOME   PEWTER CITY");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("home")) {
		home(player);
	    }
	    if (s.equals("pewter city")) {
		if (player.getPokemon()[0].getHealth() != 0) {
		    Route1 route1 = new Route1();
		    route1.routine(player);
		} else {
		    System.out.println("Your POKEMON has no health left! Go home to rest up first.");
		    walk(player,source);
		}
	    } else {
		System.out.println("You can't go there!");
		walk(player,source);
	    }
	}
	return "";
    }
	
    public String routine(Player player, Player rival) {

	Scanner scan = new Scanner(System.in);

	System.out.println("MOM: Good morning, " + player + ". Well, all children leave home some day. It said so on TV. PROF.OAK, next door, is looking for you.");
	System.out.println(go(player,rival));
	
	return "";
	
    }

}


