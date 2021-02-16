import java.util.*;
public class PROBLEMO1 {

	public static int max(int m, int n) { 
		if (m > n) {
			return m;
		}
		else {
			return n;
		}
		} 
	public static int ks(int W, int wi[], int vi[], int z) 
	{ 
		
		if (z == 0 || W == 0) 
			return 0; 

		
		if (wi[z - 1] > W) 
			return ks(W, wi, vi, z - 1); 

		
		else
			return max(vi[z - 1] + ks(W - wi[z - 1], wi, vi, z - 1), 
					ks(W, wi, vi, z - 1)); 
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner  (System.in);
		int N = scan.nextInt();
		int W = scan.nextInt();
		int wi[] = new int[N];
		int vi[] = new int[N];
		for(int i =0; i<N; i++) {
			wi[i]=scan.nextInt();
			vi[i]=scan.nextInt();
		}
		int z = vi.length; 
		System.out.println(ks(W, wi, vi, z)); 
	}
}