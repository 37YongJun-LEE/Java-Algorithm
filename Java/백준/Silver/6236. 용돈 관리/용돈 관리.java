import java.io.*;
import java.util.*;

public class Main {

    static int N, M,
            K; // M 번 만 출금. >> M번을 맞추기 위한 K 원 출금 금액을 찾을것.
    static int[] Charge;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Charge = new int[N];

        int low = 0;
        int high = 0;
        for (int i = 0; i < N; i++) {
            Charge[i] = Integer.parseInt(br.readLine());
            low = Math.max(low, Charge[i]);
            high += Charge[i];
        }

        while (low <= high) {

            int mid = (low + high) / 2;
            int cnt = 1; // cnt는 필요한 순간에 돈을 뽑는 경우이다.
            int nowCash = mid;

            for (int i = 0; i < N; i++) {
                nowCash -= Charge[i];
                if (nowCash < 0) {
                    cnt++;
                    nowCash = mid - Charge[i];
                }

            }
//            System.out.println("현재 cnt : " + cnt);
//            System.out.println("현재 mid : " + mid);

            if (cnt <= M) {
//                System.out.println("mid 크다 줄여");
                high = mid - 1;
            } else {
//                System.out.println("mid 작다 키워");
                low = mid + 1;

            }

        }
        System.out.println(low);

    }
}
