public class Pokemon {

    public static void main(String[] args) {
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
	

    }
    
}
