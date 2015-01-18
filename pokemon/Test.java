public class Test {

    public static void main(String[] args) {
        Bulbasaur b = new Bulbasaur();
	Charmander c = new Charmander();
	Battle battle = new Battle();
	System.out.println(battle.routine(b,c));
    }

}
