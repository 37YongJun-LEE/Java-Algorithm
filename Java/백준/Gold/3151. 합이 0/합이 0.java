import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] Arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N; i++) {
            Arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Arr);
//        System.out.println(Arrays.toString(Arr));
        long answer = 0;
        for (int i = 0; i < N; i++) {
            if (Arr[i] > 0) break;
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                int sum = Arr[i] + Arr[left] + Arr[right];
                int lCnt = 1;
                int rCnt = 1;

                if (sum == 0) {
                    if (Arr[left] == Arr[right]) {
                        int n = right - left + 1;
                        answer += n * (n-1) / 2;
                        break;
                    }
                    while (left + 1 < right && Arr[left] == Arr[left+1]) {
                        lCnt++;
                        left++;
                    }
                    while (left < right - 1 && Arr[right] == Arr[right-1]) {
                        rCnt++;
                        right--;
                    }
                    answer += lCnt * rCnt;
                }

                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(answer);




    }
}
