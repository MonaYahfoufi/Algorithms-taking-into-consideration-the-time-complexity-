
import java.util.*;
public class PROBL2 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int  N = scan.nextInt();
		int M = scan.nextInt();
		graph graph = new graph(N);
		for (int i = 0; i < M; i++) {
			int si = scan.nextInt();
			int ti = scan.nextInt();
			int wi = scan.nextInt();
			graph.addEdge(si, ti, wi);
		}
		graph.SearchForMin();
	}
	
	public static class edge {
		int src;
		int dst;
		int dist;

		public edge(int src, int dst, int dist) {
			this.src = src;
			this.dst = dst;
			this.dist = dist;
		}
	}

	public static class graph {
		int vertex;
		ArrayList<edge> edge = new ArrayList<>();

		graph(int vertices) {
			this.vertex = vertices;
		}

		public void addEdge(int src, int dst, int dist) {
			edge e = new edge(src, dst, dist);
			edge.add(e);
		}

		public void SearchForMin () {
			PriorityQueue<edge> priority = new PriorityQueue<>(edge.size(), Comparator.comparingInt(o -> o.dist));
			for (int i = 0; i < edge.size(); i++) {
				for (int j = 1; j < edge.size(); j++) {
					if (edge.get(i).dist == edge.get(j).dist) {
						priority.add(edge.get(j));
					} else {
						priority.add(edge.get(i));
					}
				}

			}
			int[] fathers = new int[vertex];
			FS(fathers);

			ArrayList<edge> mst = new ArrayList<>();
			int index = 0;
			while (index < vertex - 1) {
				edge edge = priority.remove();
				int x1 = SF(fathers, edge.src);
				int x2 = SF(fathers, edge.dst);

				if (x1 == x2) {
				} else {
					mst.add(edge);
					index++;
					comb(fathers, x1, x2);
				}
			}

			printweight(mst);
		}

		public void FS(int[] P) {
			for (int i = 0; i < vertex; i++) {
				P[i] = i;
			}
		}

		public int SF(int[] P, int vertex) {
			if (P[vertex] != vertex)
				return SF(P, P[vertex]);
			;
			return vertex;
		}

		public void comb(int[] P, int i1, int i2) {
			int x1p = SF(P, i1);
			int x2p = SF(P, i2);
			P[x2p] = x1p;
		}

		public void printweight(ArrayList<edge> ELIST) {
			int sum = 0;
			for (int i = 0; i < ELIST.size(); i++) {
				edge edge = ELIST.get(i);
				sum += edge.dist;
			}
			System.out.println(sum);
		}
	}

}