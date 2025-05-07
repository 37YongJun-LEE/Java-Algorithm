import java.util.*;
import java.io.*;

class Solution {
    
    static boolean[][] Disable;
    static int[][] VisitedCnt;
    static int sr, sc, er, ec;
    public int solution(String[] board) {
        int answer = 0;
        sr = 0;
        sc = 0;
        er = 0;
        ec = 0;
        
        Disable = new boolean[board.length][board[0].length()];
        VisitedCnt = new int[board.length][board[0].length()];
        for (int i = 0 ; i< board.length; i++) {
            Arrays.fill(VisitedCnt[i], Integer.MAX_VALUE);
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'D') {
                    Disable[i][j] = true;
                } else if (board[i].charAt(j) == 'R') {
                    sr = i;
                    sc = j;
                    
                } else if (board[i].charAt(j) == 'G') {
                    er = i;
                    ec = j;
                }
            }
        } 
        
        bfs(sr, sc, 0); // int 시작r, int 시작c, int cnt = 0
        return VisitedCnt[er][ec] == Integer.MAX_VALUE ? -1 : VisitedCnt[er][ec];
    }
    
    static int[] dr = new int[] {-1, 1, 0, 0};
    static int[] dc = new int[] {0, 0, -1 ,1};
    public static void bfs(int r, int c, int cnt) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        pq.offer(new int[] {r, c, cnt});
        VisitedCnt[r][c] = cnt;
    
        while (!pq.isEmpty()) {
            int[] v = pq.poll();
            r = v[0];
            c = v[1];
            cnt = v[2];
            
            if (r == er && c == ec) return;
            
            for (int d = 0; d < 4; d++) {
                int nr = r;
                int nc = c;

                while (true) {
                    nr += dr[d];
                    nc += dc[d];
                    if (nr < 0 || nr >= Disable.length 
                       || nc < 0 || nc >= Disable[0].length
                       || Disable[nr][nc]) {
                        nr -= dr[d];
                        nc -= dc[d];
                        break;
                    }
                }
                
                if (VisitedCnt[nr][nc] < cnt + 1) continue;
                pq.offer(new int[] {nr, nc, cnt + 1});
                VisitedCnt[nr][nc] = cnt + 1;
            }
            
        }
    }
    
    
}

/** 

bfs로 풀어야한다고 생각한다.

하나의 정점에서 출발해서 
정점에서 진행할 수 있는 방향을 탐색하고 멈춘 정점을 큐에 집어넣는다
이때의 큐에서 최소 방문 횟수를 탐헐할 수 있는 일종의 다익스트라 방문맵으로 저장한다.

>> 큐의 좌표 r, c, 와 이동횟수 cnt.로 전달해서 큐에넣는다.
>> 큐에서 꺼내서 좌표 확인하고 도착 좌표면 return;

>> 아니면 4방향 탐색과 미끄러짐 구현 탐색으로 탐색하여 다음 정점 확인
>> 최소 이동 횟수 갱신하는 정점으로만 진행.



**/