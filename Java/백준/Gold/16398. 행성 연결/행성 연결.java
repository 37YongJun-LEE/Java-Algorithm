import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<int[]> FlowList;
    static int[] Parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Parent = new int[N];
        for (int i = 0; i < N; i++) Parent[i] = i;
        StringTokenizer st;
        FlowList = new ArrayList<>();

        for (int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i <= j) continue;
                FlowList.add(new int[] {i, j, cost});
            }
        }

        Collections.sort(FlowList, (a, b) -> a[2] - b[2]);
        // 최소 신장 트리 구하기.
        long sum = 0;
        for (int[] flow : FlowList) {
            int a = flow[0];
            int b = flow[1];
            int cost = flow[2];
            if (find(a) != find(b) ) {
                sum += cost;
                union(a, b);
            }
        }
        System.out.println(sum);
    }

    private static int find(int a) {
        if (Parent[a] == a) return a;
        return find(Parent[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        // 작은 번호를 부모로 취급.
        if (a < b) Parent[b] = a;
        else Parent[a] = b;
    }

}