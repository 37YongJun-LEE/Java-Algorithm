import java.util.*;

class Solution {
    static int N, M;
    static boolean[][] visited;
    static int[] ColOilSum;
    
    public int solution(int[][] land) {
        int answer = 0;
        // for (int[] oil: land) {
        //     System.out.println(Arrays.toString(oil));
        // }
        
        
        N = land.length;
        M = land[0].length;
        ColOilSum = new int[M];
        
        visited = new boolean[N][M];
        for (int c = 0; c < M; c++ ) {
            int sum = 0;
            for (int r = 0; r < N; r++) {
                if (land[r][c] == 1 && !visited[r][c]) {
                    // bfs(r, c, land);
                    // sum += bfs(r, c, int[][] land);
                    sum += bfs(r, c, land);
                }
            }
            // System.out.println((c+1) + "번: " + sum + "개"  );
            // answer = Math.max(answer, sum);
        }
        
        // System.out.println(Arrays.toString(ColOilSum));
        for (int sum : ColOilSum) answer = Math.max(answer, sum);
        
        return answer;
    }
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static int bfs(int r, int c, int[][] land) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c});
        visited[r][c] = true;
        int sum = 1;
        
        HashSet<Integer> colSet = new HashSet<>();
        
        while(!queue.isEmpty()) {
            int[] v = queue.poll();
            r = v[0];
            c = v[1];
            colSet.add(c);
            
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || land[nr][nc]== 0) continue;
                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc});
                sum++;
            }
        }
        
        for (int col : colSet) {
            ColOilSum[col] += sum;
        }
        
        return sum;
    }
}