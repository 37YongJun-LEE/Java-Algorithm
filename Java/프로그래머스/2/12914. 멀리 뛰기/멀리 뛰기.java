class Solution {
    public long solution(int n) {
        long[] dp = new long[n + 2]; // n+2로 넉넉히
        dp[0] = 1; // 0칸은 1가지 방법
        dp[1] = 1; // 1칸도 1가지 방법

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }

        return dp[n];
    }
}
