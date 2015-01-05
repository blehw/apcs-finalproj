public class Pacman {

    private int[] location = new int[2];
    private int state;
    
    public Pacman() {
	location[0] = 7;
	location[1] = 7;
    }

    public String toString() {
	String s = "";
	for (int i=0;i<location.length;i++) {
	    s = s + location[i] + ", "; 
	}
	return s;
    }

    public String getLocation() {
	return location.toString();
    }

    public static void main(String[] args) {
	Pacman p = new Pacman();
	System.out.println(p.getLocation());
    }

}
