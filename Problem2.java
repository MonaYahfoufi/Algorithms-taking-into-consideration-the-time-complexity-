

	import java.util.Scanner;

	public class Problem2 {

		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			int size = scan.nextInt();
			int[] A = new int[size];
			binaryEnumeration(size, A, 0);

		}

		static void binaryEnumeration(int y, int arr[], int i) {
			if (i == y) {
				print(arr, y);
				return;
			}
			arr[i] = 0;
			binaryEnumeration(y, arr, i + 1);
			arr[i] = 1;
			binaryEnumeration(y, arr, i + 1);
		}

		static void print(int arr[], int m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}

	}

