import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 요청 시간 기준으로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 소요시간 기준 정렬

        int time = 0;
        int jobIndex = 0;
        int totalTime = 0;
        int count = 0;

        while (count < jobs.length) {
            // 현재 시간까지 들어온 작업 pq에 넣기
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= time) {
                pq.offer(new int[]{jobs[jobIndex][0], jobs[jobIndex][1]});
                jobIndex++;
            }

            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                time += job[1]; // 소요시간만큼 진행
                totalTime += time - job[0]; // 대기 시간 + 실행 시간
                count++;
            } else {
                // 대기 중인 작업이 없으면 시간 이동
                time = jobs[jobIndex][0];
            }
        }

        return totalTime / jobs.length;
    }
}
