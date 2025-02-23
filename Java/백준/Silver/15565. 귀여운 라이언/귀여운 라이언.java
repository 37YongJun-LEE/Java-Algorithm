import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] oneOrTwoCnt = new int[3];
        int start = 0;
        int end = 0;

        int minAnswer = Integer.MAX_VALUE;

        for (end = 0; end < N; end++) {
            oneOrTwoCnt[arr[end]]++;  // 1 또는 2의 개수 증가는 매번 이루어짐.

            while ( K <= oneOrTwoCnt[1] && start < end) {
                minAnswer = Math.min(minAnswer, oneOrTwoCnt[1] + oneOrTwoCnt[2]);
                oneOrTwoCnt[arr[start]]--;
                start++;
            }
        }
        System.out.println(minAnswer == Integer.MAX_VALUE ? -1 : minAnswer);
    }
}
