import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int Answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        dfs(0, list); // int depth;
        System.out.println(Answer);

    }

    private static void dfs(int sum, ArrayList<Integer> list) {
        if (list.size() == 2) {
            Answer = Math.max(Answer, sum);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (i == 0 || i == list.size() - 1) continue;
            int temp = list.get(i);
            int w1 = list.get(i-1);
            int w2 = list.get(i+1);
            list.remove(i);
            dfs(sum + (w1 * w2), list);
            list.add(i, temp);
        }

    }
}


