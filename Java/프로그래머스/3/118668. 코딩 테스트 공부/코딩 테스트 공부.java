import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {

        int alpMax = 0;
        int copMax = 0;

        // 최대 요구치를 찾음
        for (int[] problem : problems) {
            alpMax = Math.max(alpMax, problem[0]);
            copMax = Math.max(copMax, problem[1]);
        }

        // 현재 능력치가 더 높을 경우 잘라내기
        alp = Math.min(alp, alpMax);
        cop = Math.min(cop, copMax);

        // DP 배열 생성 및 초기화
        int[][] dp = new int[alpMax + 2][copMax + 2];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[alp][cop] = 0;

        // 기본 문제 추가: 알고리즘 공부, 코딩 공부
        List<int[]> allProblems = new ArrayList<>(List.of(problems));
        allProblems.add(new int[]{0, 0, 1, 0, 1}); // 알고리즘 공부
        allProblems.add(new int[]{0, 0, 0, 1, 1}); // 코딩 공부

        for (int i = alp; i <= alpMax; i++) {
            for (int j = cop; j <= copMax; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;

                for (int[] p : allProblems) {
                    int reqAlp = p[0], reqCop = p[1], rwdAlp = p[2], rwdCop = p[3], cost = p[4];

                    if (i >= reqAlp && j >= reqCop) {
                        int nextAlp = Math.min(i + rwdAlp, alpMax);
                        int nextCop = Math.min(j + rwdCop, copMax);
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + cost);
                    }
                }
            }
        }

        return dp[alpMax][copMax];
    }
}
