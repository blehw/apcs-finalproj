import java.io.*;
import java.util.*;

public class AzaleaTown {

    private String s;
    int meters = 0;
    private Battle battle = new Battle();
    Scanner scan = new Scanner(System.in);
    Random r = new Random();

    //Checks whether you can buy this many items/ whether it's a number  
    public boolean canBuy(String str){
      return str.matches("-?\\d");
      
    }

    public String routine(Player player) {
	player.setLocation("Azalea Town");	
	System.out.println("You have reached AZALEA TOWN.");
	walk(player,"street");
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
	System.out.println("CASHIER: Welcome to the POKEMART! We sell all kinds of goods here. What would you like to purchase?");
	System.out.println(player + "'s money: $" + player.getMoney());  
	System.out.println("POKEBALL $50");
	s = scan.nextLine();
	s = s.toLowerCase();
	if (s.equals("pokeball")) {
	    System.out.println("And how many POKEBALLS would you like to purchase?");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    while(canBuy(s) != true){
		System.out.println("CASHIER: You can't buy " + s + " items." +
				   "\n" + "How many POKEBALLS would you like to purchase?");
		s = scan.nextLine();
		s = s.toLowerCase();
	    }
	    int p = Integer.parseInt(s);
	    if (player.getMoney() >= 50 * p) {
		//add confirmation
		player.setBag("POKEBALL",0);
		player.setBagNum(player.getBagNum()[0] + p,0);
		player.setMoney(player.getMoney() - (p * 50));
		System.out.println("CASHIER: Thank you for your purchase!");
	    }
	}
	walk(player,"pokemart");
	return "";
    }

    public String training(Player player) {
	System.out.println("Do you want to WALK FORWARDS or WALK BACKWARDS (to AZALEA TOWN)?");
	s = scan.nextLine();
	s = s.toLowerCase();
	if (s.equals("walk forwards")) {
	    if (meters >= 300) {
		System.out.println("There's a big 'ol swamp. A. BIG. 'OL. SWAMP.");
	    } else {
		meters = meters + 50;
		System.out.println("You walked 50 meters.");
		System.out.println("You are " + meters + " meters from AZALEA TOWN.");
		int rand = r.nextInt(6);
		if (rand == 0) {
		    Scyther scyther = new Scyther();
		    battle.wildRoutine(player,scyther);
		}
		if (rand == 1) {
		    Heracross heracross = new Heracross();
		    battle.wildRoutine(player,heracross);
		}
		if (rand == 2 || rand == 3) {
		    Player bugcatcher = new Player("RANDOM WEIRDO BUG CATCHER");
		    Rattata rattata = new Rattata();
		    Scyther scyther = new Scyther();
		    //Stats for Rattata
		    rattata.setLevel(11);
		    rattata.setMaxHealth(27 + r.nextInt(10));
		    rattata.setHealth(rattata.getMaxHealth());
		    rattata.setMaxSpeed(27 + r.nextInt(10));
		    rattata.setSpeed(rattata.getMaxSpeed());
		    rattata.setMaxDefense(27 + r.nextInt(10));
		    rattata.setDefense(rattata.getMaxDefense());
		    rattata.setMaxAttack(27 + r.nextInt(10));
		    rattata.setAttack(rattata.getMaxAttack());
		    scyther.setLevel(12);
		    scyther.setMaxHealth(35 + r.nextInt(5));
		    scyther.setHealth(scyther.getMaxHealth());
		    scyther.setMaxSpeed(25 + r.nextInt(5));
		    scyther.setSpeed(scyther.getMaxSpeed());
		    scyther.setMaxDefense(25 + r.nextInt(5));
		    scyther.setDefense(scyther.getMaxDefense());
		    scyther.setMaxAttack(25 + r.nextInt(5));
		    scyther.setAttack(scyther.getMaxAttack());
		    bugcatcher.setPokemon(rattata,0);
		    bugcatcher.setPokemon(scyther,1);
		    System.out.println(bugcatcher + ": Boy I sure like catching bugs. And being weird. And battling.");
		    battle.trainerRoutine(player,bugcatcher);
		    if (player.getPokemon()[0].getHealth() > 0) {
			System.out.println(bugcatcher + ": My bug life betrayed me...");
			player.setMoney(player.getMoney() + 250);
		    }
		}
	    }
	    training(player);
	}
	if (s.equals("walk backwards")) {
	    meters = meters - 50;
	    System.out.println("You walked 50 meters.");
	    if (meters <= 0) {
		System.out.println("You have reached AZALEA TOWN.");
		walk(player,"street");
	    } else {
		System.out.println("You are " + meters + " meters from AZALEA TOWN.");
		int rand = r.nextInt(6);
		if (rand == 0) {
		    Scyther scyther = new Scyther();
		    scyther.setLevel(10);
		    scyther.setMaxHealth(30 + r.nextInt(5));
		    scyther.setHealth(scyther.getMaxHealth());
		    scyther.setMaxSpeed(20 + r.nextInt(5));
		    scyther.setSpeed(scyther.getMaxSpeed());
		    scyther.setMaxDefense(20 + r.nextInt(5));
		    scyther.setDefense(scyther.getMaxDefense());
		    scyther.setMaxAttack(20 + r.nextInt(5));
		    scyther.setMove(1,"FURY CUTTER");
		    scyther.setPP(1,20);
		    scyther.setMaxPP(1,20);
		    battle.wildRoutine(player,scyther);
		}
		if (rand == 1) {
		    Heracross heracross = new Heracross();
		    heracross.setLevel(10);
		    heracross.setMaxHealth(31 + r.nextInt(5));
		    heracross.setHealth(heracross.getMaxHealth());
		    heracross.setMaxSpeed(21 + r.nextInt(5));
		    heracross.setSpeed(heracross.getMaxSpeed());
		    heracross.setMaxDefense(21 + r.nextInt(5));
		    heracross.setDefense(heracross.getMaxDefense());
		    heracross.setMaxAttack(2 + r.nextInt(5));
		    heracross.setMove(1,"HORN ATTACK");
		    heracross.setPP(1,25);
		    heracross.setMaxPP(1,25);
		    battle.wildRoutine(player,heracross);
		}
		if (rand == 2 || rand == 3) {
		    Player bugcatcher = new Player("RANDOM WEIRDO BUG CATCHER");
		    Rattata rattata = new Rattata();
		    Scyther scyther = new Scyther();
		    //Stats for Rattata
		    rattata.setLevel(11);
		    rattata.setMaxHealth(27 + r.nextInt(10));
		    rattata.setHealth(rattata.getMaxHealth());
		    rattata.setMaxSpeed(27 + r.nextInt(10));
		    rattata.setSpeed(rattata.getMaxSpeed());
		    rattata.setMaxDefense(27 + r.nextInt(10));
		    rattata.setDefense(rattata.getMaxDefense());
		    rattata.setMaxAttack(27 + r.nextInt(10));
		    rattata.setAttack(rattata.getMaxAttack());
		    scyther.setLevel(12);
		    scyther.setMaxHealth(35 + r.nextInt(5));
		    scyther.setHealth(scyther.getMaxHealth());
		    scyther.setMaxSpeed(25 + r.nextInt(5));
		    scyther.setSpeed(scyther.getMaxSpeed());
		    scyther.setMaxDefense(25 + r.nextInt(5));
		    scyther.setDefense(scyther.getMaxDefense());
		    scyther.setMaxAttack(25 + r.nextInt(5));
		    scyther.setAttack(scyther.getMaxAttack());
		    scyther.setMove(1,"FURY CUTTER");
		    scyther.setPP(1,20);
		    scyther.setMaxPP(1,20);
		    bugcatcher.setPokemon(rattata,0);
		    bugcatcher.setPokemon(scyther,1);
		    System.out.println(bugcatcher + ": Boy I sure like catching bugs. And being weird. And battling.");
		    battle.trainerRoutine(player,bugcatcher);
		    if (player.getPokemon()[0].getHealth() > 0) {
			System.out.println(bugcatcher + ": My bug life betrayed me...");
			player.setMoney(player.getMoney() + 250);
		    }
		}
		training(player);
	    }
	}
        if (s.equals("pokemon")) {
	    System.out.println(player.getPokemonStatus());
	    training(player);
	}
	if (s.equals("exit game")) {
	    System.exit(0);
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
	    training(player);
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
	        training(player);
	    }
	    if (((switch1.equals("1") ||
		 switch1.equals("2") ||
		 switch1.equals("3") ||
		 switch1.equals("4") ||
		 switch1.equals("5") ||
		 switch1.equals("6")) &&
		 (switch2.equals("1") ||
		 switch2.equals("2") ||
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
	        training(player);
	    } else {
		System.out.println("You can't switch those POKEMON!");
	        training(player);
	    }
	} else {
	    System.out.println("You can't walk in a " + s + " direction!");
	    training(player);
	}
	return "";
    }

    public String gym(Player player) {
	if (player.getBadges()[2] != null) {
	    System.out.println("BUGSY: Be agile, be quick, and you will always be successful, " + player + "." );
	    walk(player,"bugsy's gym");
	} else {
	    System.out.println("BUGSY: I am BUGSY, leader of the gym of AZALEA TOWN.");
	    System.out.println("BUGSY: BUG POKEMON are extremely misunderstood. They are not vermin, but strong, helpful, resourceful creatures. We have much to learn from them.");
	    System.out.println("BUGSY: Hmm? You want the HIVE BADGE? Are you ready to take on the cunning of my BUG POKEMON?");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("yes")) {
		System.out.println("BUGSY: Then let us commence.");
		Player bugsy = new Player("BUGSY");
		Scyther scyther = new Scyther();
		Heracross heracross = new Heracross();
		scyther.setLevel(18);
		scyther.setMaxHealth(58);
		scyther.setHealth(scyther.getMaxHealth());
		scyther.setMaxSpeed(48);
		scyther.setSpeed(scyther.getMaxSpeed());
		scyther.setMaxDefense(44);
		scyther.setDefense(scyther.getMaxDefense());
		scyther.setMaxAttack(44);
		scyther.setMove(1,"FURY CUTTER");
		scyther.setPP(1,20);
		scyther.setMaxPP(1,20);
		scyther.setMove(2,"X-SCISSOR");
		scyther.setPP(2,15);
		scyther.setMaxPP(2,15);
		heracross.setLevel(21);
		heracross.setMaxHealth(65);
		heracross.setHealth(heracross.getMaxHealth());
		heracross.setMaxSpeed(59);
		heracross.setSpeed(heracross.getMaxSpeed());
		heracross.setMaxDefense(56);
		heracross.setDefense(heracross.getMaxDefense());
		heracross.setMaxAttack(58);
		heracross.setMove(1,"HORN ATTACK");
		heracross.setPP(1,25);
		heracross.setMaxPP(1,25);
		heracross.setMove(2,"MEGAHORN");
		heracross.setPP(2,10);
		heracross.setMaxPP(2,10);
		bugsy.setPokemon(scyther,0);
		bugsy.setPokemon(heracross,1);
		battle.trainerRoutine(player,bugsy);
		if (player.getPokemon()[0].getHealth() > 0) {
		    player.setMoney(player.getMoney() + 1000);
		    System.out.println(player + " got $1000 for winning!");
		    System.out.println("BUGSY: You have proven yourself even more clever than my BUG POKEMON. You have earned the HIVE BADGE");
		    player.setBadges("HIVE BADGE",2);
		    System.out.println("BUGSY: As long as you continue on your path, you can only get stronger.");
		}
		walk(player,"bugsy's gym");
	    } else {
		System.out.println("BUGSY: Very well then.");
		walk(player,"bugsy's gym");
	    }
	}
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
	    int a = 1;
	    int b = 2;
	    try {
		a = Integer.parseInt(switch1);
		b = Integer.parseInt(switch2);
	    } catch (Exception e) {
		System.out.println("You can't switch those POKEMON!");
	        walk(player,source);
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
	    System.out.println("Where do you want to go?");
	    System.out.println("POKEMON CENTER   POKEMART   BUGSY'S GYM   CERULEAN CITY   SWAMPGROUND");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("pokemon center")) {
		pokemoncenter(player);
	    }
	    if (s.equals("pokemart")) {
		pokemart(player);
	    }
	    if (s.equals("bugsy's gym")) {
		gym(player);
	    }
	    if (s.equals("cerulean city")) {
		Route3 route3 = new Route3();
		route3.routineAzalea(player);
	    }
	    if (s.equals("swampground")) {
		System.out.println("You enter the SWAMPGROUND, a damp, dark place.");
		training(player);
	    }
	    if (etc(player,source,s)) {
	    } else {
	    System.out.println("You can't go there!");
	    walk(player,source);
	    }
	}
	if (source.equals("bugsy's gym")) {
	    System.out.println("Where do you want to go?");
	    System.out.println("POKEMON CENTER   POKEMART   CERULEAN CITY   SWAMPGROUND");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("pokemon center")) {
		pokemoncenter(player);
	    }
	    if (s.equals("pokemart")) {
		pokemart(player);
	    } 
	    if (s.equals("cerulean city")) {
		Route3 route3 = new Route3();
		route3.routineAzalea(player);
	    }
	    if (s.equals("swampground")) {
		System.out.println("You enter the SWAMPGROUND, a damp, dark place.");
		training(player);
	    }
	    if (etc(player,source,s)) {
	    } else {
	    System.out.println("You can't go there!");
	    walk(player,source);
	    }
	}
	if (source.equals("pokemon center")) {
	    System.out.println("Where do you want to go?");
	    System.out.println("PC   POKEMART   BUGSY'S GYM   CERULEAN CITY   SWAMPGROUND   SAVE");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("pc")) {
		if (player.getPCPokemonStatus().equals("")) {
		    System.out.println("There are no POKEMON in the PC!");
		    walk(player,source);
		} else {
		    System.out.println(player.getPCPokemonStatus());
		    walk(player,source);
		}
	    }
	    if (s.equals("pokemart")) {
		pokemart(player);
	    }
	    if (s.equals("bugsy's gym")) {
		gym(player);
	    }
	    if (s.equals("cerulean city")) {
		Route3 route3 = new Route3();
		route3.routineAzalea(player);
	    }
	    if (s.equals("swampground")) {
		System.out.println("You enter the SWAMPGROUND, a damp, dark place.");
		training(player);
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
	    if (s.contains("pc switch") && s.length() == 13) {
		String switch1 = s.substring(10,11);
		String switch2 = s.substring(12,13);
		int a = 1;
		int b = 2;
		try { 
		    a = Integer.parseInt(switch1);
		    b = Integer.parseInt(switch2);
		} catch (Exception e) {
		    System.out.println("You can't switch those POKEMON!");
		    walk(player,source);
		}
		if (player.getPC().size() >= b) {
		    if ((switch1.equals("1") ||
			 switch1.equals("2") ||
			 switch1.equals("3") ||
			 switch1.equals("4") ||
			 switch1.equals("5") ||
			 switch1.equals("6")) &&
			!(player.getPokemon()[a-1] == null) &&
			!(player.getPC().get(b-1) == null) &&
			player.getPC().size()>=b) {  
			int s1 = Integer.parseInt(switch1) - 1;
			int s2 = Integer.parseInt(switch2) - 1;
			BaseChar poke1 = player.getPokemon()[s1];
			BaseChar poke2 = player.getPC().get(s2);
			player.setPokemon(poke2,s1);
			player.setPC(poke1,s2);
			System.out.println(player.getPokemonStatus());
			walk(player,source);
		    } else {
			System.out.println("You can't switch those POKEMON!");
			walk(player,source);
		    }
		} else {
		    System.out.println("You can't switch those POKEMON!");
		    walk(player,source);	  
		}
	    }
	    if (etc(player,source,s)) {
	    } else {
		System.out.println("You can't go there!");
		walk(player,source);
	    }
	}
	if (source.equals("pokemart")) {
	    System.out.println("Where do you want to go?");
	    System.out.println("POKEMON CENTER   BUGSY'S GYM   CERULEAN CITY   SWAMPGROUND");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("pokemon center")) {
		pokemoncenter(player);
	    }
	    if (s.equals("bugsy's gym")) {
		gym(player);
	    }
	    if (s.equals("cerulean city")) {
		Route3 route3 = new Route3();
		route3.routineAzalea(player);
	    }
	    if (s.equals("swampground")) {
		System.out.println("You enter the SWAMPGROUND, a damp, dark place.");
		training(player);
	    }
	    if (etc(player,source,s)) {
	    } else {
		System.out.println("You can't go there!");
		walk(player,source);
	    }
	}
	return "";
    }

}
