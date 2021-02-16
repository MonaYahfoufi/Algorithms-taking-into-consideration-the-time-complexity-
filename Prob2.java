
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Prob2 {

	static boolean isPar(char v) 
	{ 
	    return ((v == '(') || (v == ')')); 
	} 
	  
	
	static boolean validS(String str) 
	{ 
	    int count = 0; 
	    for (int i = 0; i < str.length(); i++) 
	    { 
	        if (str.charAt(i) == '(') 
	            count++; 
	        else if (str.charAt(i) == ')') 
	            count--; 
	        if (count < 0) 
	            return false; 
	    } 
	    return (count == 0); 
	} 
	  
	static void removeinvalidparenthesis(String str) 
	{ 
	    if (str.isEmpty()) 
	        return; 
	  
	   ArrayList<String> visit = new ArrayList<String>(); 
	  
	    Queue<String> q = new LinkedList<>(); 
	    String temp; 
	    boolean level = false; 
	  
	    q.add(str); 
	    visit.add(str); 
	    while (!q.isEmpty()) 
	    { 
	        str = q.peek(); q.remove(); 
	        if (validS(str)) 
	        { 
	            System.out.println(str); 
	  
	            
	            level = true; 
	        } 
	        if (level) 
	            continue; 
	        for (int i = 0; i < str.length(); i++) 
	        { 
	            if (!isPar(str.charAt(i))) 
	                continue; 
	            
	            temp = str.substring(0, i) + str.substring(i + 1); 
	            if (!visit.contains(temp)) 
	            { 
	                q.add(temp); 
	                visit.add(temp); 
	            } 
	        } 
	    } 
	} 
	  

	public static void main(String[] args)  
	{ 
		Scanner scan=new Scanner(System.in);
	    String str = scan.nextLine();
	    removeinvalidparenthesis(str); 
	  
	} 
	}  
	


