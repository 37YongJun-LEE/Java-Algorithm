import java.io.*;
import java.util.*;



public class Main {
    static int N;
    static long K;
    static long[] Num, Sum;
    static Map<Long, Long> Map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Num = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= N; i++) {
            Num[i] = Num[i-1] + Integer.parseInt(st.nextToken());
        }

//        System.out.println(Arrays.toString(Sum));
        long answer  =0;
        Map = new HashMap<>();
        Map.put(0L, 1L);

        for (int i = 1 ; i <= N; i++) {
            answer += Map.getOrDefault(Num[i]-K, 0L);
            Map.put(Num[i], Map.getOrDefault(Num[i], 0L) + 1);
        }

        System.out.println(answer);

    }
}
