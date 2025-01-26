import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static ArrayList<Integer>[] StudentList;
    static int[][] Dp;
    static long Answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        StudentList = new ArrayList[N+1];
        for (int i = 1 ; i <= N; i++) {
            StudentList[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int cnt = st.countTokens();
            for (int j = 0; j < cnt; j++) {
                StudentList[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        Dp = new int[N+1][H+1];
        for (int i = 0; i <= N; i++) {
            Dp[i][0] = 1; // 0 만드는 경우의수는 무조건 1가지.
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= H; j++) {
                for (int num : StudentList[i]) {
                    if ( j < num ) break;
                    Dp[i][j] += Dp[i-1][j - num];
                    Dp[i][j] = Dp[i][j] % 10007;
                }
                Dp[i][j] += Dp[i-1][j];
                Dp[i][j] = Dp[i][j] % 10007;
            }
        }
        System.out.println(Dp[N][H]);
    }
}
