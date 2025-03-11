import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] Visited, Count;
    static final int MAX = 200000;  // 방문 배열의 최대 크기

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Visited = new int[MAX + 1];
        Count = new int[MAX + 1];

        Arrays.fill(Visited, Integer.MAX_VALUE); // 초기값을 최댓값으로 설정

        bfs(N);  // 다익스트라 대신 BFS 사용

        System.out.println(Visited[K]);
        System.out.println(Count[K]);
    }

    public static void bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, start});
        Visited[start] = 0;
        Count[start] = 1;  // 시작 지점의 경로 수는 1

        while (!queue.isEmpty()) {
            int[] v = queue.poll();
            int sec = v[0];
            int now = v[1];

            for (int next : new int[]{now + 1, now - 1, now * 2}) {
                if (next < 0 || next > MAX) continue;

                if (Visited[next] > sec + 1) { // 처음 방문하는 경우
                    Visited[next] = sec + 1;
                    Count[next] = Count[now];  // 이전 경로 수를 그대로 가져옴
                    queue.offer(new int[]{sec + 1, next});
                } else if (Visited[next] == sec + 1) { // 최단 시간으로 도달한 경우
                    Count[next] += Count[now];  // 추가적인 최단 경로 발견
                }
            }
        }
    }
}
