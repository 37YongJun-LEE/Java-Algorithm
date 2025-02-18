import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] Map;
    static boolean[][] Visited;
    static ArrayList<int[]> WillBeMeltList;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(Map[i]));
        }

        // 빙산 덩어리 카운트.
        int year = 0;
        int cnt = 0;
        while (true) {
            // 빙산 덩어리 카운트
            cnt = iceburgCounting();
            if (cnt != 1) break; // 끝나는 조건 : 두 덩어리로 분리된 경우, 더이상 녹을게 없는 경우.

            // 빙산 녹이기 가능한 경우, 리스트에 담기.
            willBeMelt();

            // 빙산 녹이기.
            melting();

//            for (int i = 0; i < N; i++) System.out.println(Arrays.toString(Map[i]));
//            System.out.println("---------------------------------------------------------");
            year++;
        }

        if (cnt == 0) {
            System.out.println(0);
        } else {
//            System.out.println("cnt : " +cnt);
//            System.out.println("year : " +year);
            System.out.println(year);
        }

    }

    private static void melting() {
        for (int[] iceburg : WillBeMeltList) {
            int r = iceburg[0];
            int c = iceburg[1];
            int cnt = iceburg[2];
            Map[r][c] -= cnt;
            if (Map[r][c] < 0) Map[r][c] = 0;
        }
    }

    private static void willBeMelt() {
        WillBeMeltList = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (Map[r][c] != 0) {
                    int mCnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                        if (Map[nr][nc] == 0) mCnt++;
                    }
                    WillBeMeltList.add(new int[] {r, c, mCnt});

                }
            }
        }
//        for (int[] arr : WillBeMeltList) System.out.println(Arrays.toString(arr));
    }

    private static int iceburgCounting() {
        Visited = new boolean[N][M];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Map[i][j] != 0 && !Visited[i][j]) {
//                    System.out.println(i + " " + j);
                    iceburgBfs(i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static int[] dr = new int[] {-1, 1, 0, 0};
    static int[] dc = new int[] {0, 0, -1, 1};
    private static void iceburgBfs(int r, int c) { // 조건 : Map[r][c] != 0 && !Visited[r][c]
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c});
        Visited[r][c] = true;

        while(!queue.isEmpty()) {
            int[] v = queue.poll();
            r = v[0];
            c = v[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M || Visited[nr][nc] || Map[nr][nc] == 0) continue;
                Visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc});
            }
        }
    }
}