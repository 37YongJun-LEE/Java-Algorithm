import java.util.*;
import java.io.*;

public class Main {
    static int C;
    static int[][] Score;
    static int MaxScore;

    static boolean[] PlayerVisited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());

        for (int c = 1; c <= C; c++) {

            Score = new int[11][11];
            for (int i = 0 ; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    Score[i][j] = Integer.parseInt(st.nextToken());
                }
//                System.out.println(Arrays.toString(Score[i]));
            }

            PlayerVisited = new boolean[11];
            MaxScore = 0;
            backTracking(0, 0);
            System.out.println(MaxScore);
        }

    }

    static void backTracking(int jdx, int sum) { // jdx는 포지션 번호.
        if (jdx == 11) {
//            System.out.println(sum);
            MaxScore = Math.max(sum , MaxScore);
            return;
        }

        // for 에서 순회도는 경우는 사람번호를 순회. jdx 포지션에 배치되는 사람의 번호.
        // 따라서 jdx 포지션에 배치되는 사람이 최대를 갱신하는 경우에 탐색을 진행.
        for (int i = 0 ; i < 11; i++) {
            if (PlayerVisited[i]) continue;
            PlayerVisited[i] = true;
            if (sum < sum + Score[i][jdx]) {
                backTracking(jdx + 1, sum + Score[i][jdx]);
            }
            PlayerVisited[i] = false;

        }
    }

}
