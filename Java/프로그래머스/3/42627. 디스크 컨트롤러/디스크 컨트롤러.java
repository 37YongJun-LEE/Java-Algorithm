import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs, (a, b) -> {
            return a[0] - b[0];
        });
        // for (int[] job : jobs) System.out.println(Arrays.toString(job));
        // int[] {요청시간, 소요시간};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });        
        
        int n = jobs.length;
        int time = 0;
        int idx = 0;
        
        while ( idx < n ) {
            
            while (idx < n && jobs[idx][0] <= time) {
                pq.offer(jobs[idx]);
                // System.out.println(idx);
                // System.out.println(Arrays.toString(jobs[idx]));
                idx++;
            }

            if (!pq.isEmpty()) {
                int[] v = pq.poll();
                time += v[1];
                answer += time - v[0];
            } else {
                time = jobs[idx][0];
            }
            
            
        }
        
        while (!pq.isEmpty()) {
            int[] v = pq.poll();
            time += v[1];
            answer += time - v[0];
        }
                
        return answer / n;
    }
    
}