import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] Num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N; i++) Num[i] = Integer.parseInt(st.nextToken());

        int answer = 0;

        int left = 0;
        int right = 0;
        int sum = 0;

        while (true) {
            if (sum >= K) {
                sum -= Num[left];
                left++;
            } else if (right == N) {
                break;
            } else {
                sum += Num[right];
                right++;
            }

            if (sum == K) answer++;
        }

        System.out.println(answer);


    }
}
