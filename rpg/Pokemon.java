public class Pokemon {

    public static void main(String[] args) {
	Charmander c1 = new Charmander();
	Charmander c2 = new Charmander();
	System.out.println(c2.getHealth());
	System.out.println(c1.tackle(c2));
	System.out.println(c2.getHealth());
	System.out.println(c1.moveset());
    }
    
}
