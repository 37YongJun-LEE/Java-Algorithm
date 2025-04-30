import java.util.*;


class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a, b) -> {
            return a[0] - b[0];
        });
        
        // for (int[] job : jobs) {
        //     System.out.println(Arrays.toString(job));
        // }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        int time = 0;
        int idx = 0;            
        int N = jobs.length;
        
        while (idx < N) {
            while (idx < N && jobs[idx][0] <= time) {
                pq.offer(new int[] {jobs[idx][0], jobs[idx][1]});
                idx++;
            }
            
            // for (int[] arr : pq) {
            //     System.out.print(Arrays.toString(arr));
            // }
            // System.out.println();
            
            if (!pq.isEmpty()) {
                int[] v = pq.poll();
                time += v[1];
                answer += time - v[0];
                
                // System.out.println(time + "-" + v[0] + "=" + (time-v[0]));
                // System.out.println(answer);
            } else {
                if (idx < N) {
                    time = jobs[idx][0];
                    //idx++;                    
                }
            }
        }
        
        while (!pq.isEmpty()) {
            int[] v = pq.poll();
            time += v[1];
            answer += time - v[0];

            // System.out.println(time + "-" + v[0] + "=" + (time-v[0]));
            // System.out.println(answer);
        }
            
        
           
        return answer / jobs.length;
    }
}