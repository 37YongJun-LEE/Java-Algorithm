import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람 수.
        int m = Integer.parseInt(st.nextToken()); // 종류 수.
        int[] arr = new int[m];

        int low = 1;
        int high = 1;

        for (int i = 0 ; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, arr[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = 0;
            for (int i = 0 ; i < m; i++) {
                if (arr[i] % mid == 0) { // 몫. 그대로 반영
                    cnt += arr[i] / mid;
                } else {
                    cnt += (arr[i] / mid) + 1;
                }
            }

//            System.out.println("최대 질투심. : " + mid);
//            System.out.println("현재 나눠준 사람수. : " + cnt);
            if (cnt <= n) {
//                System.out.println("더 주만 안돼 > 개수 내려");
                high = mid - 1;

            } else {
//                System.out.println("더 줘도 된다 > 개수 올려");
                low = mid + 1;
            }
        }

        System.out.println(low);

    }
}
