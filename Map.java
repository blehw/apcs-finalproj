public class Map {

    private int[][] grid;

    public Map() {
	grid = new int[15][15];
    }

    public void toString() {
	for (int r=0;r<grid.length;r++) {
	    for (int c=0;c<grid[0].length;c++) {
		System.out.print(grid[r][c]);
	    }
	    System.out.print("\n");
	}
    }

    public static void main(String[] args) {
	grid g = new grid();
	System.out.println(g);
    }
}
