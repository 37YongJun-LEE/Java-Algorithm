import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
        
        for (int work : works) {
            pq.offer(work);
        }
        
        for (int i = 0; i < n; i++) {
            int a = pq.poll();
            if ( a > 0 ) {
                a = a - 1;                
            }
            // System.out.println(a);
            pq.offer(a);
            
        }
        // System.out.println(pq);

        while (!pq.isEmpty()) {
            long num = pq.poll();
            answer += num * num;
        }
        
        return answer;
    }
}