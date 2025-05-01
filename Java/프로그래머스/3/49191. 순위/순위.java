import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean[][] adjMatrix = new boolean[n+1][n+1];
        boolean[][] revMatrix = new boolean[n+1][n+1];
        
        for (int[] arr : results) {
            adjMatrix[arr[1]][arr[0]] = true; // 진 -> 이긴
            revMatrix[arr[0]][arr[1]] = true; // 이긴 -> 진
        }
        
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            cnt += bfs(i, n, adjMatrix); // int now, int n 
            cnt += bfs(i, n, revMatrix); // int now, int n 
            if (cnt == n-1) answer++;
        };
        
        return answer;
    }
    
    public static int bfs(int now, int n, boolean[][] matrix) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(now);
        visited[now] = true;
        
        int cnt = 0;
        while (!queue.isEmpty()) {
            now = queue.poll();
            // matrix[now]
            for (int i = 1; i <= n; i++) {
                if (matrix[now][i] && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
