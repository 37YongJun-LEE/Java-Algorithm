import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static int[] C;

    static int[] Dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        C = new int[N+1]; //

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            C[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(C));

        Dp = new int[K+1];
        Arrays.fill(Dp, Integer.MAX_VALUE);
        Dp[0] = 0;

        for (int i = 1; i <= N; i++) { // i는 커피 번호.
            for (int j = K; j >= 0; j--) { // 역순으로 해야 중복되는 값이 없게 DP 갱신이 이루어짐.
                if (j - C[i] >= 0 && Dp[j - C[i]] != Integer.MAX_VALUE) {
                    Dp[j] = Math.min(Dp[j], Dp[j - C[i]] + 1);
                }
            }
        }

//        System.out.println(Arrays.toString(Dp));
//        System.out.println(Dp[N]);
        System.out.println( Dp[K] == Integer.MAX_VALUE ? -1 : Dp[K] );
    }
}
