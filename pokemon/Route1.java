import java.util.*;
import java.io.*;

public class Route1 {
   
    private Scanner scan = new Scanner(System.in);
    private Random r = new Random();
    private Battle battle = new Battle();
    private int meters = 0;
    private String s;

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
	    int rand = r.nextInt(4);
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
	if (s.equals("pokemon")) {
	    System.out.println(player.getPokemonStatus());
	    routinePallet(player);
	} 
	if (s.equals("exit game")) {
		System.exit(0);
	} else {
	    System.out.println("You can't walk in a " + s + " direction!");
	    routinePallet(player);
	}
	return "";
    }

    public String routinePewter(Player player) {
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
	if (s.equals("pokemon")) {
	    System.out.println(player.getPokemonStatus());
	    routinePewter(player);
	} 
	if (s.equals("exit game")) {
		System.exit(0);
	} else {
	    System.out.println("You can't walk in a " + s + " direction!");
	    routinePewter(player);
	}
	return "";
    }
}
