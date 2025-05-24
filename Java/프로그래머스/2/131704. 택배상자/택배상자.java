import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int idx = 1;
        
        Stack<Integer> stack = new Stack<>();
        for (int ord : order) {
            while (idx <= ord) {
                stack.push(idx++);
            }
            
            if ( !stack.isEmpty() && stack.peek() == ord ) {
                stack.pop();
                // System.out.println(stack);
                answer++;
            } else if (idx == ord) {
                idx++;
                answer++;
            } else {
                break;
            }
        }
        
        
        return answer;
    }
}