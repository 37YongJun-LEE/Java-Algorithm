import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[1000001];

        dp[0] = 0;
        dp[1] = 0; // dp[2] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = (i-1) * (dp[i-1] + dp[i-2]) % 1000000000;
//            System.out.println(dp[i]);
        }
//        System.out.println(Arrays.toString(dp));

        System.out.println(dp[n]);

    }
}
