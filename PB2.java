
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
public class PB2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt(); 
		LinkedList<Integer> G[] = new LinkedList[num];
		int e = scan.nextInt();
		for(int i = 0; i < num; i++) {
			G[i] = new LinkedList();
		}
		for(int i = 0; i < e; i++) {
			int vertex = scan.nextInt();
			int edge = scan.nextInt();
			G[vertex].add(edge);
			G[edge].add(vertex);
		}
		VC(G, num);
	}
	
	public static void VC(LinkedList<Integer>[] G, int n) {
		int c = 0;
		int[] visit = new int[n];
		
		Iterator<Integer> i;	
		
		for(int j = 0; j < n; j++) {
			if(visit[j] == 0) {
				i = G[j].iterator();
				while(i.hasNext()) {
					int v = i.next();
					if(visit[v] == 0) {
						visit[v] = 1;
						visit[j] = 1;
						break;
					}
				}
			}
		}
		
		for(int k = 0; k < n; k++) {
			if(visit[k] == 1)
				c++;
		}
		
		if(c >= 4)
			System.out.println("No");
		else
			System.out.println("Yes");
		
	} 
}