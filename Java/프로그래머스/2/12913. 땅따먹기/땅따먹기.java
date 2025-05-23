import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        
        int[][] dp = new int[land.length][4];
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        
        for (int r = 1 ; r < land.length; r++) {
            for (int c = 0; c < 4; c++) {
                // System.out.println(r + " " + c);
                for (int bc = 0; bc < 4; bc++) {
                    if (c == bc) continue;
                    dp[r][c] = Math.max(dp[r][c], land[r][c] + dp[r-1][bc]);
                    // System.out.println( dp[r-1][bc]);
                }
                
                // break;
            }
            // break;
        }
        
        // for (int r = 0 ; r < land.length; r++) {
        //     System.out.println(Arrays.toString(dp[r]));
        // }
        for (int c = 0; c < 4; c++) {
            answer = Math.max(answer, dp[land.length-1][c]);
        }
        
        
        return answer;
    }
}