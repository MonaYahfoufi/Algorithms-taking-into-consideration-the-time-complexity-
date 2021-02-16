import java.util.Scanner;

public class Pro3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int Arr [] = new int[m];
		for (int i = 0; i < m; i++) {
			Arr[i] = scan.nextInt();
		}
		System.out.println(maxval(Arr, m));
	}
	
	public static int p(int Arr[], int x, int y, int z) {
		if (x == 0)
			return Math.abs((z - y) - y);
		return Math.max(p(Arr, x - 1, y + Arr[x - 1], z), p(Arr, x - 1, y, z));
	}

	public static int maxval(int Arr[], int j) {
		int sum = 0;
		for (int i = 0; i < j; i++)
			sum += Arr[i];
		return p(Arr, j, 0, sum);
	}

}