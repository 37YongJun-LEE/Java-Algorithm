import java.util.*;
import java.io.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 0;
        int idx = 0;
        int nowWeight = 0;
                
        Queue<int[]> queue = new ArrayDeque<>();
        
        while (idx < truck_weights.length || !queue.isEmpty()) {
            
            // 들어오기
            if (idx < truck_weights.length 
                   && queue.size() < bridge_length 
                   && nowWeight + truck_weights[idx] <= weight
                  ) {
                queue.offer(new int[] {truck_weights[idx], 0});
                nowWeight += truck_weights[idx];
                idx++;
            }
            // System.out.print(time + " 입장");
            // for (int[] q : queue) System.out.print(Arrays.toString(q));
            // System.out.println();

            
            
            for (int[] truck : queue) {
                truck[1] += 1;
            }
            
            
            // 나가기.
            while (!queue.isEmpty() && queue.peek()[1] == bridge_length) {
                int[] truck = queue.poll();
                nowWeight -= truck[0];
            }
            
            time++;
            
            
        }
        
        // System.out.println( queue);
        
        
        return time + 1;
        
    }
}