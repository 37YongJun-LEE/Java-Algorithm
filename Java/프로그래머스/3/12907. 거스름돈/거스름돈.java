import java.util.*;
class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        int[] dp = new int[n+1];
        
        for (int coin : money) {
            dp[coin] += 1;
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i - coin];
            }
            // System.out.println(Arrays.toString(dp));
        }
        
        return dp[n];
    }
}