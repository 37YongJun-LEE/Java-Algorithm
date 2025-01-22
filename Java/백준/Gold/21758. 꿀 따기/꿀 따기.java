import java.util.*;
import java.io.*;

public class Main {
    static int Answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }


        // 1. s1, s2, e 순서.
        int sum1 = sum - arr[0];
        int sum2 = sum - arr[0];
        for (int i = 1 ; i < n-1; i++) {
            sum1 = sum - arr[0] - arr[i];
            sum2 -= arr[i];
            Answer = Math.max(Answer, sum1 + sum2);
//            System.out.println(sum1 + sum2);
        }
//        System.out.println("-----------------------------");

        // 2. s1, e, s2 순서 : e 가 이동.
        sum1 = 0;
        sum2 = sum - arr[0] - arr[n-1];
//        System.out.println(sum2);
        for (int i = 1; i < n-1; i++) {
            sum1 += arr[i];
            Answer = Math.max(Answer, sum1 + sum2);
//            System.out.println(sum1 + sum2);
            sum2 -= arr[i];
        }
//        System.out.println("-----------------------------");


        // 3. e, s1, s2 순서.
        sum1 = sum - arr[n-1];
        sum2 = sum - arr[n-1];
        for (int i = n-2; i >= 1; i--) {
            sum1 = sum - arr[n-1] - arr[i];
            sum2 -= arr[i];
            Answer = Math.max(Answer, sum1 + sum2);
//            System.out.println(sum1 + sum2);
        }

        System.out.println(Answer);

    }
}
