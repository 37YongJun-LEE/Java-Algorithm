import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        double sum = 0;
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // 요청 시각 기준 작업 정렬.
        
        // 여기서부터 작업을 기준으로 순차적으로 진행하돼 우선순위에따라서 작업처리가 진행되어야함.
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        int time = 0;
        int idx = 0;
        int count = 0;
        
        while (count < jobs.length) { // 딱 작업 개수만큼 프로그램 처리할 것.
            
            // pq에 넣는 부분 : 동시간대 처리가 필요.
            while ( idx < jobs.length && jobs[idx][0] <= time ) { // 현재시각보다 요청시각이 같거나 작으면 넣기 + null 접근 방지.
                // System.out.println(Arrays.toString(jobs[idx]));
                pq.offer(new int[] {jobs[idx][0], jobs[idx][1]});
                idx++;
            }
            
            // 작업을 처리하는 부분
            if (!pq.isEmpty()) {
                int[] nowJob = pq.poll(); //[요청시각, 소요시간.]
                time += nowJob[1];
                sum += time - nowJob[0];
                count++;
            } else {
                time = jobs[idx][0];
            }
            
        }
        answer = (int)(sum / jobs.length);
            
        return answer;
    }
}