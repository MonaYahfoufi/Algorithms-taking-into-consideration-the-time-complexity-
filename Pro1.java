
import java.util.*; 
	  
	public class Pro1 { 
	    Scanner scan=new Scanner(System.in);  
	    static int N = 3; 
	      
	    static int maxP(int triangle[][], int x, int y) 
	    { 
	        for (int m = x - 1; m >= 0; m--) 
	        { 
	            for (int n = 0; n <= m; n++) 
	            { 
	                
	                if (triangle[m + 1][n] > triangle[m + 1][n + 1]) 
	                    triangle[m][n] += triangle[m + 1][n]; 
	                else
	                    triangle[m][n] += triangle[m + 1][n + 1]; 
	            } 
	        } 
	      
	        return triangle[0][0]; 
	    } 
	      
	    
	    public static void main (String[] args) 
	    { 
	    	Scanner scan=new Scanner(System.in);
	    	int x=scan.nextInt();
	    	int triangle[][]=new int[x][x];
	    	for(int i=0;i<x;i++) {
	    		for(int j=0;j<i+1;j++) {
	    			triangle[i][j]=scan.nextInt();
	    		}
	    	}
	    	System.out.println(maxP(triangle, x-1, x-1));
	    } 
	}


