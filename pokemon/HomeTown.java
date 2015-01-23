import java.io.*;
import java.util.*;

public class HomeTown {

    private String s; 
    private Battle battle = new Battle();
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
	System.out.println("OAK: " + player + ", raise your POKEMON by training them! You can check on them at any time by typing 'POKEMON'.");
	System.out.println("GOD-LIKE VOICE: And you can exit the game by typing 'EXIT GAME'.");
	System.out.println("OAK: Hmm, did you hear something, " + player + "?");
        System.out.println("GOD-LIKE VOICE: Well, while we're info dumping:\nTHROW POKEBALL: 'POKEBALL'\nSEE MONEY, BADGES, AND ITEMS: <PLAYER NAME>\nSWITCH POKEMON IN PARTY: 'SWITCH <# OF POKEMON TO BE SWITCHED> <#NUMBER OF POKEMON TO BE SWITCHED>'\nTAKE POKEMON OUT OF PC: 'PC SWITCH <# OF PARTY POKEMON> <# OF PC POKEMON>'");
	walk(player,"prof. oak's lab");
	return "";
    }

    public String home(Player player) {
	System.out.println("MOM: Hello, dear. You look tired. Why don't you take a rest?");
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
	System.out.println("MOM: There you go. All rested up.");
	walk(player,"home");
	return "";
    }

    public String lab(Player player) {
	System.out.println("OAK: Hello, " + player + ". I see your " + player.getPokemon()[0] + " is getting stronger. I wish you the best of luck in your journey!");
	walk(player,"prof. oak's lab");
	return "";
    }

    public boolean etc(Player player, String source, String s) {
	if (s.equals("pokemon")) {
	    System.out.println(player.getPokemonStatus());
	    walk(player,source);
	    return true;
	}
	if (s.equals("exit game")) {
	    System.exit(0);
	    return true;
	}
	if (s.equals(player.toString().toLowerCase())) {
	    System.out.println("MONEY: $" + player.getMoney() + "\n");
	    System.out.println(player.seeBadges());
	    System.out.println("BAG: ");
	    for (int i=0;i<player.getBag().length &&
		     player.getBag()[i] != null;i++) {
		System.out.println(player.getBag()[i] + " " + 
				   player.getBagNum()[i]);
	    }
	    if (player.getBag()[0] == null) {
		System.out.println("Your bag is empty!");
	    }
	    walk(player,source);
	    return true;
	}
	if (s.contains("switch") && s.length() == 10) {
	    String switch1 = s.substring(7,8);
	    String switch2 = s.substring(9,10);
	    int a = Integer.parseInt(switch1);
	    int b = Integer.parseInt(switch2);
	    if ((switch1.equals("1") ||
		 switch1.equals("2") ||
		 switch1.equals("3") ||
		 switch1.equals("4") ||
		 switch1.equals("5") ||
		 switch1.equals("6") ||
		 switch2.equals("1") ||
		 switch2.equals("2") ||
		 switch2.equals("3") ||
		 switch2.equals("4") ||
		 switch2.equals("5") ||
		 switch2.equals("6")) &&
		!(switch1.equals(switch2)) &&
		!(player.getPokemon()[a-1] == null) &&
		!(player.getPokemon()[b-1] == null)) {  
		int s1 = Integer.parseInt(switch1) - 1;
		int s2 = Integer.parseInt(switch2) - 1;
		BaseChar poke1 = player.getPokemon()[s1];
		BaseChar poke2 = player.getPokemon()[s2];
		player.setPokemon(poke1,s2);
		player.setPokemon(poke2,s1);
		System.out.println(player.getPokemonStatus());
		walk(player,source);
		return true;
	    } else {
		System.out.println("You can't switch those POKEMON!");
		walk(player,source);
		return true;
	    }
	} else {
	    return false;
	}
    }

    public String walk(Player player, String source) {
	if (source.equals("street")) {
	    player.setLocation("Pallet Town");
	    System.out.println("Where do you want to go?");
	    System.out.println("HOME   PROF. OAK'S LAB   PEWTER CITY");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("home")) {
		home(player);
	    }
	    if (s.equals("prof. oak's lab")) {
		lab(player);
	    } 
	    if (s.equals("pewter city")) {
		Route1 route1 = new Route1();
		route1.routinePallet(player);
	    }  
	    if (etc(player,source,s)) {
	    }else {
		System.out.println("You can't go there!");
		walk(player,source);
	    }
	}
	if (source.equals("home")) {
	    System.out.println("Where do you want to go?");
	    System.out.println("PROF. OAK'S LAB   PEWTER CITY   SAVE");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("prof. oak's lab")) {
		lab(player);
	    } 
	    if (s.equals("pewter city")) {
		Route1 route1 = new Route1();
		route1.routinePallet(player);
	    } 
	    if (s.equals("save")) {
		try {
		    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save.dat"));
		    oos.writeObject(player);
		    oos.close();
		    System.out.println("GAME SAVED");
		    walk(player,source);
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
	    } 
	    if (etc(player,source,s)) {
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
		    route1.routinePallet(player);
		} else {
		    System.out.println("Your POKEMON has no health left! Go home to rest up first.");
		    walk(player,source);
		}
	    } 
	    if (etc(player,source,s)) {
	    } else {
		System.out.println("You can't go there!");
		walk(player,source);
	    }
	}
	return "";
    }
	
    public String routine(Player player, Player rival) {

	System.out.println("MOM: Good morning, " + player + ". Well, all children leave home some day. It said so on TV. Well, here's some money for your travels. Oh, and PROF.OAK, next door, is looking for you.");
	player.setMoney(player.getMoney() + 500);
	System.out.println(go(player,rival));
	
	return "";
	
    }

}


