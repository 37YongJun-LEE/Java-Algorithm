import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        
        int sr = 0, sc = 0;
        int lr = 0, lc = 0;
        int er = 0, ec = 0;
        
        int[][] Map = new int[maps.length][maps[0].length()];
        boolean[][] Visited = new boolean[maps.length][maps[0].length()];
        
        for (int i =0 ; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                    Map[i][j] = 0; // 0은 접근 가능.
                    
                } else if (maps[i].charAt(j) == 'E') {
                    er = i;
                    ec = j;
                    Map[i][j] = 0; // 0은 접근 가능.
                    
                } else if (maps[i].charAt(j) == 'L') {
                    lr = i;
                    lc = j;
                    Map[i][j] = 0; // 0은 접근 가능.
                    
                } else if (maps[i].charAt(j) == 'O') {
                    Map[i][j] = 0; // 0은 접근 가능.
                } else if (maps[i].charAt(j) == 'X') {
                    Map[i][j] = 1; // 1은 벽 접근 불가능.
                }
            }
        }
        
        // for (int i = 0 ; i < Map.length; i++) {
        //     System.out.println(Arrays.toString(Map[i]));
        // }
        
        // System.out.println(sr + " " + sc);
        // System.out.println(lr + " " + lc);
        // System.out.println(er + " " + ec);
        
        // 레버 bfs와
        int time= bfs(sr, sc, lr, lc, Map);
        if( time == -1) {
            return -1;
        } else {
            answer += time;
        }
        
        // 레버 이후 bfs로
        // Visited = new boolean[maps.length][maps[0].length()];
        time = bfs(lr, lc, er, ec, Map);        
        if( time == -1) {
            return -1;
        } else {
            answer += time;
        }
        
        return answer;
    }
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static int bfs(int sr, int sc, int er, int ec, int[][] map) {
        // System.out.println("시작(" + sr + "," + sc + ")" + " > 끝(" + er + "," + ec + ")");
        
        int time = -1;
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sr, sc, 0});
        visited[sr][sc] = true;
        
        while(!queue.isEmpty()) {
            int[] v = queue.poll();
            int r = v[0];
            int c = v[1];
            int t = v[2];
            
            if (r == er && c == ec) {
                time = t;
                break;
            }
            
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length 
                    || visited[nr][nc] || map[nr][nc] == 1) continue;
                queue.offer(new int[] {nr, nc, t + 1} );
                visited[nr][nc] = true;
                
            }
            
        }
        
        return time;
    }
}