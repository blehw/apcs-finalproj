public class Map {

    private int[][] grid;

    public Map() {
	grid = new int[15][15];
	for (int r=0;r<grid.length;r++) {
	    for (int c=0;c<grid[0].length;c++) {
		grid[r][c] = 1;
	    }
	}
    }

    public String toString() {
	String s = "";
	for (int r=0;r<grid.length;r++) {
	    for (int c=0;c<grid[0].length;c++) {
		s = s + grid[r][c];
	    }
	    s = s + "\n";
	}
	return s;
    }

    public static void main(String[] args) {
	Map m = new Map();
	System.out.println(m);
    }
}
