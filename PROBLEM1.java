





import java.util.*;
public class PROBLEM1 {

		public static void main(String args[]) 
		{
			Scanner scan=new Scanner(System.in);
			int n = scan.nextInt();
			int e = scan.nextInt();
			
			
			ArrayList<Integer> array1[] = new ArrayList[n];
			ArrayList<Integer> array2[] = new ArrayList[n];

			for(int x = 0; x < n; x++)
			{
				array1[x] = new ArrayList<Integer>();
				array2[x] = new ArrayList<Integer>();
			}
			for(int x = 0; x < e; x++)
			{
				int u = scan.nextInt();
				int v = scan.nextInt();
				int d = scan.nextInt();

				array1[u].add(v);
				array2[u].add(d);
			}

			shortestpath(array1, array2, 0);
		}

		public static void shortestpath(ArrayList<Integer> array1[], ArrayList<Integer> array2[], int s)
		{
			int n = array1.length;

			int A1[] = new int[n];
			int A2[] = new int[n];
			int A3[] = new int[n];
			int A4[] = new int[n];

			PriorityQueue<Integer> priority = new PriorityQueue<Integer>();

			for(int x = 0; x < n; x++)
			{
				A1[x] = Integer.MAX_VALUE;
				A2[x] = -1;
			}

			A1[0] = 0;

			for(int x = 0; x < n; x++)
				priority .offer(A1[x]);

			while(priority .size() != 0)
			{
				int u = mindistance(priority, A1, A3);

				A4[u] = A1[u];

				for(int x = 0; x < array1[u].size(); x++)
				{
					int v = array1[u].get(x);

					if(A3[v] == 0 && A1[v] > A1[u] + array2[u].get(x))
					{
						A2[v] = u;
						A1[v] = A1[u] + array2[u].get(x);

						priority.clear();

						for(int j = 0; j < n; j++)
							if(A3[j] == 0)
								priority.offer(A1[j]);
					}
				}
			}
			for(int x = 1; x < n; x++)
				System.out.println(0+" -> "+x+": "+A1[x]);
		}

		public static int mindistance(PriorityQueue<Integer> priority, int A1[], int A2[])
		{
			int min = priority.poll();
			for(int x = 0; x < A1.length; x++)
				if(A2[x] == 0 && min == A1[x])
				{
					A2[x] = 1;
					return x;
				}
			return -1;
		}
	}