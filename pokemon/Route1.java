import java.util.*;
import java.io.*;

public class Route1 {
   
    private Scanner scan = new Scanner(System.in);
    private Random r = new Random();
    private Battle battle = new Battle();
    private int meters = 0;
    private String s;

    public boolean etc(Player player, String s) {
	if (s.equals("pokemon")) {
	    System.out.println(player.getPokemonStatus());
	    routinePallet(player);
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
	    routinePallet(player);
	    return true;
	}
	if (s.contains("switch") && s.length() == 10) {
	    String switch1 = s.substring(7,8);
	    String switch2 = s.substring(9,10);
	    int a = 1;
	    int b = 2;
	    try {
		a = Integer.parseInt(switch1);
		b = Integer.parseInt(switch2);
	    } catch (Exception e) {
		System.out.println("You can't switch those POKEMON!");
		routinePallet(player);
	    }
	    if (((switch1.equals("1") ||
		 switch1.equals("2") ||
		 switch1.equals("3") ||
		 switch1.equals("4") ||
		 switch1.equals("5") ||
		 switch1.equals("6") ||
		 switch2.equals("1")) &&
		 (switch2.equals("2") ||
		 switch2.equals("3") ||
		 switch2.equals("4") ||
		 switch2.equals("5") ||
		  switch2.equals("6"))) &&
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
		routinePallet(player);
		return true;
	    } else {
		System.out.println("You can't switch those POKEMON!");
	        routinePallet(player);
		return true;
	    }
	} else {
	    return false;
	}
    }

    public String routinePallet(Player player) {
	player.setLocation("Route 1");
	System.out.println("Do you want to WALK FORWARDS (to PEWTER CITY) or WALK BACKWARDS (to PALLET TOWN)?");
	s = scan.nextLine();
	s = s.toLowerCase();
	if (s.equals("walk forwards")) {
	    meters =  meters + 100;
	    System.out.println("You walked 100 meters.");
	    if (meters >= 1000) {
		meters = 1000;
		PewterCity pewtercity = new PewterCity();
		pewtercity.routine(player);
	    }
	    System.out.println("You are " + (1000 - meters) + " meters from PEWTER CITY. You are " + meters + " meters from PALLET TOWN.");
	    int rand = r.nextInt(2);
	    if (rand == 0) {
		Rattata rattata = new Rattata();
		battle.wildRoutine(player,rattata);	    
	    }
	    routinePallet(player);
	}
	if (s.equals("walk backwards")) {
	    meters = meters - 100;
	    System.out.println("You walked 100 meters.");
	    if (meters <= 0) {
		meters = 0;
		System.out.println("You have reached PALLET TOWN.");
		HomeTown hometown = new HomeTown();
		hometown.walk(player,"street");
	    }
	    System.out.println("You are " + meters + " meters from PALLET TOWN. You are " + (1000 -meters) + " meters from PEWTER CITY.");
	    int rand = r.nextInt(4);
	    if (rand == 0) {
		Rattata rattata = new Rattata();
		battle.wildRoutine(player,rattata);	    
	    }
	    routinePallet(player);
	} 
	if (etc(player,s)) {
	} else {
	    System.out.println("You can't walk in a " + s + " direction!");
	    routinePallet(player);
	}
	return "";
    }

    public String routinePewter(Player player) {
	player.setLocation("Pewter City");
	player.setLocation("Route 1");
	System.out.println("Do you want to WALK FORWARDS (to PALLET TOWN) or WALK BACKWARDS (to PEWTER CITY)?");
	s = scan.nextLine();
	s = s.toLowerCase();
	if (s.equals("walk forwards")) {
	    meters =  meters + 100;
	    System.out.println("You walked 100 meters.");
	    if (meters >= 1000) {
		meters = 1000;
		System.out.println("You have reached PALLET TOWN.");
		HomeTown hometown = new HomeTown();
		hometown.walk(player,"street");
	    }
	    System.out.println("You are " + (1000 - meters) + " meters from PALLET TOWN. You are " + meters + " meters from PEWTER CITY.");
	    int rand = r.nextInt(4);
	    if (rand == 0) {
		Rattata rattata = new Rattata();
		battle.wildRoutine(player,rattata);	    
	    }
	    routinePewter(player);
	}
	if (s.equals("walk backwards")) {
	    meters = meters - 100;
	    System.out.println("You walked 100 meters.");
	    if (meters <= 0) {
		meters = 0;
		PewterCity pewtercity = new PewterCity();
		pewtercity.routine(player);
	    }
	    System.out.println("You are " + meters + " meters from PEWTER CITY. You are " + (1000 -meters) + " meters from PALLET TOWN.");
	    int rand = r.nextInt(4);
	    if (rand == 0) {
		Rattata rattata = new Rattata();
		battle.wildRoutine(player,rattata);	    
	    }
	    routinePewter(player);
	} 
        if (etc(player,s)) {
	} else {
	    System.out.println("You can't walk in a " + s + " direction!");
	    routinePewter(player);
	}
	return "";
    }
}
