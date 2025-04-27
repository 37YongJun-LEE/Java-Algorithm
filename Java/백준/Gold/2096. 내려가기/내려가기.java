import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] MaxDp, MinDp;

    static int[] dc = {-1, 0, 1};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        MaxDp = new int[N][3];
        MinDp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                MaxDp[i][j] = num;
                MinDp[i][j] = num;
            }
        }

        for (int r = 1; r < N; r++) {
            for (int c = 0; c < 3; c++) {
                int maxtemp = 0;
                int mintemp = Integer.MAX_VALUE;
                for (int d = 0; d < 3; d++) {
                    int nc = c + dc[d];
                    if (nc < 0 || nc >= 3) continue;
                    maxtemp = Math.max(maxtemp, MaxDp[r-1][nc]);
                    mintemp = Math.min(mintemp, MinDp[r-1][nc]);
                }
                MaxDp[r][c] += maxtemp;
                MinDp[r][c] += mintemp;
            }
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, MaxDp[N-1][i]);
            min = Math.min(min, MinDp[N-1][i]);
        }

        System.out.println(max + " " + min);

    }
}