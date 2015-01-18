import java.util.*;
import java.io.*;

public class Route1 {
   
    private Scanner scan = new Scanner(System.in);
    private Random r = new Random();
    private Battle battle = new Battle();
    private int meters = 0;
    private String s;

    public String routine(Player player) {
	player.setLocation("Route 1");
	while (meters != 1000) {
	    System.out.println("Do you want to WALK FORWARD (to PEWTER CITY) or WALK BACKWARDS (to PALLET TOWN)?");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("walk forward")) {
		meters =  meters + 100;
		System.out.println("You walked 100  meters.");
		System.out.println("You are " + meters + " meters from PALLET TOWN. You are " + (1000 - meters) + " meters from PEWTER CITY");
		int rand = r.nextInt(4);
		if (rand == 0) {
		    Rattata rattata = new Rattata();
		    battle.wildRoutine(player,rattata);	    
		}
	    }
	}
	System.out.println("You have reached PEWTER CITY.");
	return "";
    }
}
