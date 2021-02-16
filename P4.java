
  public class P4{
    static boolean shouldSwap(char str[], int s, int c) { 
        for (int i = s; i < c; i++) { 
            if (str[i] == str[c]) { 
                return false; 
            } 
        } 
        return true; 
    } 
  

    static void findPermutations(char str[], int index, int x) { 
        if (index >= x) { 
            System.out.println(str); 
            return; 
        } 
  
        for (int i = index; i < x; i++) { 
  
            
            boolean check = shouldSwap(str, index, i); 
            if (check) { 
                swap(str, index, i); 
                findPermutations(str, index + 1, x); 
                swap(str, index, i); 
            } 
        } 
    } 
  
    static void swap(char[] array, int i, int j) { 
        char c = array[i]; 
        array[i] = array[j]; 
        array[j] = c; 
    } 
  
  
    public static void main(String[] args) { 
  
        char str[] = {'A', 'B', 'C'}; 
        int size= str.length; 
        findPermutations(str, 0, size); 
    } 
  
}
