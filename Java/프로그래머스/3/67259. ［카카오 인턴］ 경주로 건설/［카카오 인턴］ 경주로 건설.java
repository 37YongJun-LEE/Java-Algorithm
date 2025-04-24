import java.io.*;
import java.util.*;

class Solution {
    
    static int[][][] Visited;
    static int N;
    static int Answer;
    public int solution(int[][] board) {
        int answer = 0;
        
        N =board.length;
        Visited = new int[N][N][4];
        for (int i = 0 ; i< N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(Visited[i][j], Integer.MAX_VALUE);
            }
        }
        
        Answer = Integer.MAX_VALUE;
        bfs(0, 0, board);
        
        // for (int i = 0 ; i< N; i++) {
        //     System.out.println(Arrays.toString(Visited[i]));
        // }
        int Answer = Integer.MAX_VALUE;
        for (int d = 0 ; d < 4; d++ )
            Answer = Math.min(Answer, Visited[N-1][N-1][d]);
            
        return Answer;
    }
    
    // 0 1 2 3 : 상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static public void bfs(int r, int c, int[][] board) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> -a[0]));
        pq.offer(new int[] {0, r, c, -1});
        
        while(!pq.isEmpty()) {
            int[] v = pq.poll();
            int cost = v[0];
            r = v[1];
            c = v[2];
            int beforeD = v[3];
            
            for (int d = 0 ; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N || board[nr][nc] == 1) continue;
                // 방향 먼저 따지기
                if (beforeD == -1 || d == beforeD) {
                    if (Visited[nr][nc][d] > (cost + 100) ) {
                        pq.offer(new int[] {cost + 100, nr, nc, d});
                        Visited[nr][nc][d] = cost + 100;
                    }
                } else {
                    if (Visited[nr][nc][d] > (cost + 600)) {
                        pq.offer(new int[] {cost + 500 + 100, nr, nc, d});
                        Visited[nr][nc][d] = cost + 500 + 100;
                    }
                }
                
            }
            
        }
        
    }
}