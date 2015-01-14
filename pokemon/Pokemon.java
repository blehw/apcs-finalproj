public class Pokemon {

    public static void main(String[] args) {
<<<<<<< HEAD:rpg/Pokemon.java
	Charmander opponent = new Charmander();
	Squirtle player = new Squirtle();
	


	boolean fight = true;
	System.out.println("Foe " + opponent + " wants to battle!");
	//BASIC fight sequence 
	
	while (fight){
	    System.out.println("What do you want to do? \n" +
			       player.getMoves0() + "     " +
			       player.getMoves1() + "\n" +
			       player.getMoves2() + "     " +
			       player.getMoves3()
			       );
	}
	
	//Selection of PLAYER's move		      
	String move = scan.nextLine();
	move = move.toLowerCase();
	move = move.replaceAll("\\s+","");
	if (move.equals("tackle")) {
	    player.tackle();
	}
	if (move.equals("recover")) {
	    player.recover();
	}

	int opponentHP = opponent.getHealth();

	//Selection of OPPONENT's move
	

=======
	Charmander c1 = new Charmander();
	Charmander c2 = new Charmander();
	System.out.println(c2.getHealth());
	System.out.println(c1.tackle(c2));
	System.out.println(c2.getHealth());
	System.out.println(c1.moveset());
>>>>>>> 2c10593c464d32ebab41ff7cfa7616632af4b82b:pokemon/Pokemon.java
    }
    
}
