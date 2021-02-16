import java.util.*;
public class PB1 {
	static int Ver;
	static LinkedList<Integer> A[];

	PB1(int V) {
		this.Ver = V;
		A = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			A[i] = new LinkedList();
		}
	}

	static void addEdge(int V, int E) {
		A[V].add(E);
		A[E].add(V);
	}

	static void printMinVC() {
		boolean passedby[] = new boolean[Ver];
		for (int i = 0; i < Ver; i++)
			passedby[i] = false;
		Iterator<Integer> iter;
		for (int i = 0; i < Ver; i++) {
			if (passedby[i] == false) {
				iter = A[i].iterator();
				while (iter.hasNext()) {
					int v = iter.next();
					if (passedby[v] == false) {
						passedby[v] = true;
						passedby[i] = true;
						break;
					}
				}
			}
		}
		for (int i = 0; i < Ver; i++)
			if (passedby[i])
				System.out.print(i + " ");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int vertex = scan.nextInt();
		int edge = scan.nextInt();
		int v1, v2;
		PB1 graph = new PB1(vertex);
		for (int i = 0; i < edge; i++) {
			v1 = scan.nextInt();
			v2 = scan.nextInt();
			graph.addEdge(v1, v2);
		}
		graph.printMinVC();
	}
}
