import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] Height;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Height = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i< N; i ++) {
            Height[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> distList = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            distList.add(Height[i] - Height[i-1]);
        }
        Collections.sort(distList);

        long answer = 0;
        for (int i = 0; i < N - K; i++) {
            answer += distList.get(i);
        }
        System.out.println(answer);



    }
}
