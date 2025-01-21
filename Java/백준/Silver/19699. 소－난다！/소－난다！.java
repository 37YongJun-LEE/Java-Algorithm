import java.util.*;
import java.io.*;

public class Main {
    static boolean[] Prime, Answer;
    static int N, M;
    static int[] Number;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Number = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Number[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 에라스토테네스의 체 를 만들어서 소수를 미리 골라놓은다.
        Prime = new boolean[10001];
        Answer = new boolean[10001];
        Arrays.fill(Prime, true);
        Prime[0] = Prime[1] = false;
        for (int i = 2; i <= Math.sqrt(10000); i++) {
            if (Prime[i]) {
                for (int j = i * i; j < Prime.length; j = j + i) {
                    Prime[j] = false;
                }
            }
        }
//        for (int i = 0; i <= 10000; i++) {
//            if (Prime[i]) System.out.println(i);
//        }

        // 2. 완전탐색 ( 조합 ) 을 진행해서 모든 수의 합 경우의수를 추출한다.
        Arrays.sort(Number);
        Visited = new boolean[N];
        dfs(0, 0);

        boolean flag = false;
        for (int i = 0 ; i < Answer.length; i++) {
            if (Answer[i]) {
                System.out.print(i + " ");
                flag = true;
            }
        }
        if (!flag) System.out.println(-1);
    }

    static boolean[] Visited;
    private static void dfs(int cnt, int sum) {
        if (cnt == M) {
            //System.out.println(sum);
            // 3. 경우의 수 각각 소수인지 판단하고 출력한다. + 한번 방문한수 체크.
            if (Prime[sum]) {
                Answer[sum] = true;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (Visited[i]) continue;
            Visited[i] = true;
            dfs(cnt + 1, sum + Number[i]);
            Visited[i] = false;
        }
    }

}
