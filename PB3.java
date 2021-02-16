

import java.util.LinkedList;
import java.util.Scanner;

public class PB3 {
	static int MAX = 100;

	static int[] store = new int[MAX];
	static int n;

	static int[][] G = new int[MAX][MAX];

	static int[] d = new int[MAX];

	static boolean is_clique(int b) {

		for (int i = 1; i < b; i++) {
			for (int j = i + 1; j < b; j++)

				if (G[store[i]][store[j]] == 0)
					return false;
		}
		return true;
	}

	static void print(int n) {
		for (int i = 1; i < n; i++)
			System.out.print(store[i] + " ");
		System.out.print(", ");
	}

	static void findCliques(int i, int l, int s) {

		for (int j = i + 1; j <= n - (s - l); j++)

			if (d[j] >= s - 1) {

				store[l] = j;

				if (is_clique(l + 1))

					if (l < s)

						findCliques(j, l + 1, s);

					else
						print(l + 1);
			}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		int v = scan.nextInt();
		int e = scan.nextInt();
		int v1, v2;
		int edges[][] = new int[e][2];
		for (int i = 0; i < e; i++) {
			for (int j = 0; j < 2; j++) {
				edges[i][j] = scan.nextInt();
			}
		}

		for (int i = 0; i < edges.length; i++) {
			G[edges[i][0]][edges[i][1]] = 1;
			G[edges[i][1]][edges[i][0]] = 1;
			d[edges[i][0]]++;
			d[edges[i][1]]++;
		}

		findCliques(0, 1, k);
	}
}