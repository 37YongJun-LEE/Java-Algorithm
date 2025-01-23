import java.util.*;
import java.io.*;

/////////////////////// 답보고 품 ///////////////////////////

public class Main {
    static int N;
    static int[] Tri;
    static int[] Dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // Tri 배열 : 수열의 결과로 나온 n번째 정사면체에 사용되는 대포알 개수가 저장된 배열.
        Tri = new int[121];
        int cnt = 0;
        for (int i = 0 ; i < 121; i++) {
            Tri[i] = cnt + i;
            cnt = cnt + i;
        }
        for (int i = 1; i < 121; i++) {
            Tri[i] = Tri[i] + Tri[i-1];
//            System.out.println(i + "번째 개수: " + Tri[i]);
        }

        // DP 배열 초기화
        Dp = new int[300001];
        for (int i = 0 ; i < 300001; i++) {
            Dp[i] = i;
        }

        // Dp 점화식으로 개수 구하기.
        for (int i = 0; i < Dp.length; i++) {

            for (int j = 0; j < Tri.length; j++) {
                if (i < Tri[j]) break;
                Dp[i] = Math.min(Dp[i], Dp[i - Tri[j]] + 1);
            }
        }
        System.out.println(Dp[N]);

    }
}
