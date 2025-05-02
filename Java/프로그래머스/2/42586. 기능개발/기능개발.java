import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        // for (int i = progresses.length-1; i >= 0; i--) {
        //     queue.offer(new int[] {progresses[i], speeds[i]});
        // }
        for (int i = 0; i < progresses.length; i++) {
            queue.offer(new int[] {progresses[i], speeds[i]});
        }
        
        // System.out.println(Arrays.toString(queue.poll())) ;

        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            for (int[] v : queue) {
                v[0] += v[1];
            }
            
            // for (int[] v : queue) System.out.print(Arrays.toString(v));
            // System.out.println();
            int cnt = 0;
            while (!queue.isEmpty() && queue.peek()[0] >= 100) {
                queue.poll();
                cnt++;
            }
            if (cnt != 0) list.add(cnt);
            // break;
        }
        answer = new int[list.size()];   
        for (int i = 0 ; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}