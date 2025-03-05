import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] InsertDegree;
    static ArrayList<Integer>[] AdjList;
    static int[] AnswerArr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        AdjList = new ArrayList[N+1];
        for (int i = 0 ; i <= N; i++) {
            AdjList[i] = new ArrayList<>();
        }
        InsertDegree = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            AdjList[a].add(b); // 방향 그래프.
            InsertDegree[b]++;
        }

//        System.out.println(Arrays.toString(InsertDegree));
//        for (int i = 0 ; i <= N; i++) {
//            System.out.println(AdjList[i]);
//        }

        AnswerArr = new int[N+1];

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (InsertDegree[i] == 0) {
                queue.offer(i);
                AnswerArr[i]++;
            }
        }

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int next : AdjList[v]) {
                InsertDegree[next]--;
                if (InsertDegree[next] == 0) { // 인접한 노드의 진입차수가 0이 된 경우에는 큐 삽입.
                    queue.offer(next);
                    AnswerArr[next] = AnswerArr[v] + 1; // 0이 되는 경우에 학기 증가.
                }
            }
        }

        for (int i = 1; i <= N; i++) System.out.print(AnswerArr[i] + " ");
    }
}
