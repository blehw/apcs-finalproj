public class Map {

    private int[][] grid;

    public Map() {
	grid = new int[15][15];
	for (int r=0;r<grid.length;r++) {
	    for (int c=0;c<grid[0].length;c++) {
		grid[r][c] = 1;
	    }
	}
	for (int r=1;r<grid[0].length-1;r++) {
	    grid[r][7] = 2;
	}
	for (int c=1;c<grid[0].length-1;c++) {
	    grid[7][c] = 2;
	}
	for (int c=1;c<grid[0].length-1;c++) {
	    grid[3][c] = 2;
	}
	for (int c=1;c<grid[0].length-1;c++) {
	    grid[11][c] = 2;
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
