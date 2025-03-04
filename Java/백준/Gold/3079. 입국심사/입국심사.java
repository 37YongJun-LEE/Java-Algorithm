import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] Time;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Time = new int[N];
        for (int i = 0; i < N; i++) {
            Time[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(Time);
        long low = 0;
        long high = (long)M * Time[0];

        while (low < high) {
            long mid = (low + high) / 2; // 우리가 원하는 시간.
            long cnt = 0; // mid 시간내에 처리할 수 있는 사람 수.

            for (int i = 0; i < N; i++) {
                cnt += mid / Time[i];
            }
            if (cnt < M) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        System.out.println(low);
    }
}
