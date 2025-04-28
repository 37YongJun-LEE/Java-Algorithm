import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int len = 1; len <= elements.length; len++ ){
            // System.out.println( "길이 " + len);
            
            for (int s = 0; s < elements.length; s++) {
                int sum = 0;
                for (int i = s; i < len + s; i++) {
                    // System.out.print(i % elements.length);
                    sum += elements[i % elements.length];
                }
                set.add(sum);
                // System.out.println( ": " + sum);
                // System.out.println();
            }
        }
    
        return set.size();
    }
}