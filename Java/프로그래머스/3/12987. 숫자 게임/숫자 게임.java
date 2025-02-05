import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);

        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        
        for (int b : B) {
            pq.offer(b);
        }
        
        for (int i = 0 ; i < A.length; i++) {
            while(!pq.isEmpty()) {
                int b = pq.poll();
                if (A[i] < b) {
                    // System.out.println(A[i] + " < " + b);
                    answer++; 
                    break;
                }
            }
        }
        
        return answer;
        
    }
}