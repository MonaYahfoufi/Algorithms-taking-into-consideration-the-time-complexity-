
	import java.util.Scanner;
	import java.util.Vector;

	public class Probelm4 { 
	  
	static long []colorcounter = new long[2]; 
	  
		public static void dfs(Vector<Integer> adjacent[], int node, int p, boolean col) 
		{ 
			colorcounter[col == false ? 0 : 1]++; 
	    
			for (int i = 0; i < adjacent[node].size(); i++)  
			{ 
	  
				if (adjacent[node].get(i) != p) 
					dfs(adjacent, adjacent[node].get(i), node, !col); 
			} 
		} 
		public static int fMaxEdges(Vector<Integer> adjacent[], int t) 
		{ 
			dfs(adjacent, 1, 0, false); 
			return (int) (colorcounter[0] * colorcounter[1] - (t - 1)); 
		} 
	  
		public static void main(String[] args) 
		{ 
			Scanner scan = new Scanner(System.in);
			int v = scan.nextInt();
			int E = scan.nextInt();

			Vector<Integer>[] adj = new Vector[v + 1]; 
	    	for (int i = 0; i < v + 1; i++)  
	    		adj[i] = new Vector<Integer>(); 
			
			for(int i=0; i<E; i++)
			{
				int m=scan.nextInt();
				int n=scan.nextInt();
				
				adj[m].add(n);
				
			}
	    	System.out.println(fMaxEdges(adj, v)); 
	} 
	}

