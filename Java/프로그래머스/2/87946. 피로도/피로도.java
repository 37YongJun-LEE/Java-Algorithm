import java.util.*;

class Solution {
    
    static int[] Order;
    static boolean[] Visited;
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        
        Order = new int[dungeons.length];
        Visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0, dungeons.length); 
        
        
        return answer;
    }
    
    public static void dfs(int k, int[][] dungeons, int idx, int depth) {
        if (idx == depth) {
            // System.out.println(Arrays.toString(Order));
            // 방문 순서대로 가능 여부 계산하기.
            int cnt = 0;
            for (int num : Order) {
                int minimum = dungeons[num][0];
                int spend = dungeons[num][1];
                if (k >= minimum) {
                    k -= spend;
                    cnt++;
                }
            }
            
            answer = Math.max(answer, cnt);
            
            
            return;
        }
        
        for (int i = 0; i < depth; i++) {
            if (Visited[i]) continue;
            Visited[i] = true;
            Order[idx] = i;
            dfs(k, dungeons, idx + 1, depth);
            Visited[i] = false;
            
        }
        
    }
    
}