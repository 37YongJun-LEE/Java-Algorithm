import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        // 위 아래 우 좌
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{ 0, 0, 1, -1};
        
        int r = 0;
        int c = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < dirs.length(); i++) {
            int nr, nc;
            
            if (dirs.charAt(i) == 'U') {
                nr = r + dr[0];
                nc = c + dc[0];
            } else if (dirs.charAt(i) == 'D'){
                nr = r + dr[1];
                nc = c + dc[1];
            }else if (dirs.charAt(i) == 'R'){
                nr = r + dr[2];
                nc = c + dc[2];
            }else {
                nr = r + dr[3];
                nc = c + dc[3];
            }
            
            if (nr <= -6 || nc <= -6 || nr >= 6 || nc >= 6) {
                // nr = r;
                // nc = c;
                continue;
            }
            
            // System.out.println(r +"," + c + " >> " + nr + "," + nc);
            map.put(r + " " + c + " " + nr + " " + nc, 1);
            map.put(nr + " " + nc + " " + r + " " + c, 1);
            
            
            r = nr;
            c = nc;
        }
        
        // System.out.println(map.size());
        
        return map.size() / 2;
    }
}