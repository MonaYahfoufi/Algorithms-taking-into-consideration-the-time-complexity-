
	public class Problem3 {

	static int N;

	void print(int sol[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(" " + sol[i][j] + " ");
			System.out.println();
		}
	}

	boolean isSafe(int maze[][], int a, int b) {

		return (a >= 0 && a < N && b >= 0 && b < N && maze[a][b] == 1);
	}

	boolean solveMaze(int maze[][]) {
		int sol[][] = new int[N][N];

		if (solved(maze, 0, 0, sol) == false) {
	
		}

		print(sol);
		return true;
	}

	boolean solved(int maze[][], int a, int b, int sol[][]) {

		if (a == N - 1 && b == N - 1) {
			sol[a][b] = 1;
			return true;
		}

		if (isSafe(maze, a, b) == true) {

			sol[a][b] = 1;

			if (solved(maze, a + 1, b, sol))
				return true;

			if (solved(maze, a, b + 1, sol))
				return true;

			sol[a][b] = 0;
			return false;
		}

		return false;
	}

	public static void main(String args[]) {
		Problem3 M = new Problem3();
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };

		N = maze.length;
		M.solveMaze(maze);
	}
}