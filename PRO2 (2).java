
import java.util.*; 
  
public class PRO2 
{ 
    static long cw(int S[], int m, int n) 
    { 
        
        long[] array = new long[n+1]; 
  
        Arrays.fill(array, 0);  
 
        array[0] = 1; 
 
        for (int i=0; i<m; i++) 
            for (int j=S[i]; j<=n; j++) 
                array[j] += array[j-S[i]]; 
  
        return array[n]; 
    } 
  
    public static void main(String args[]) 
    { 
    	Scanner scan=new Scanner(System.in);
    	int size=scan.nextInt();
    	 int n = scan.nextInt(); 
        int array[] = new int[size];
        for(int i=0;i<array.length;i++) {
        	array[i]=scan.nextInt();
        }
        int m = array.length; 
        System.out.println(cw(array, m, n)); 
    } 
} 