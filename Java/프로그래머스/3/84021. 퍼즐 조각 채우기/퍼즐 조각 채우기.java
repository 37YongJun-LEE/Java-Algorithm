import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<int[]>> gList = new ArrayList<>();
    static ArrayList<ArrayList<int[]>> tList = new ArrayList<>();
    static boolean[] visited;
    static int maxFill = 0;

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        int N = game_board.length;
        
        // 빈칸 추출 (0 -> 1 로 마킹)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (game_board[i][j] == 0) {
                    gList.add(bfs(i, j, 0, 1, game_board));
                }
            }
        }

        // 조각 추출 (1 -> 0 로 마킹)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (table[i][j] == 1) {
                    tList.add(bfs(i, j, 1, 0, table));
                }
            }
        }

        visited = new boolean[tList.size()];
        
        // 각 빈칸에 대해 조각 매칭
        for (ArrayList<int[]> gBlock : gList) {
            normalize(gBlock); // 좌상단 정렬

            boolean matched = false;

            for (int i = 0; i < tList.size(); i++) {
                if (visited[i]) continue;

                ArrayList<int[]> tBlock = tList.get(i);

                for (int r = 0; r < 4; r++) {
                    ArrayList<int[]> rotated = rotate(tBlock, r);
                    normalize(rotated);
                    if (isSameShape(gBlock, rotated)) {
                        answer += gBlock.size();
                        visited[i] = true;
                        matched = true;
                        break;
                    }
                }

                if (matched) break;
            }
        }

        return answer;
    }

    // 좌상단 기준으로 상대좌표 정렬
    static void normalize(ArrayList<int[]> list) {
        int minR = Integer.MAX_VALUE, minC = Integer.MAX_VALUE;
        for (int[] p : list) {
            minR = Math.min(minR, p[0]);
            minC = Math.min(minC, p[1]);
        }
        for (int[] p : list) {
            p[0] -= minR;
            p[1] -= minC;
        }
        list.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    }

    // 도형 회전 (r번 90도 회전)
    static ArrayList<int[]> rotate(ArrayList<int[]> shape, int r) {
        ArrayList<int[]> rotated = new ArrayList<>();
        for (int[] p : shape) {
            int x = p[0], y = p[1];
            for (int i = 0; i < r; i++) {
                int temp = x;
                x = y;
                y = -temp;
            }
            rotated.add(new int[]{x, y});
        }
        return rotated;
    }

    // 두 블록이 같은 모양인지 확인
    static boolean isSameShape(ArrayList<int[]> a, ArrayList<int[]> b) {
        if (a.size() != b.size()) return false;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) return false;
        }
        return true;
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    // 도형 탐색 (bfs)
    public static ArrayList<int[]> bfs(int sr, int sc, int target, int visitCheck, int[][] map) {
        ArrayList<int[]> list = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sr, sc});
        map[sr][sc] = visitCheck;
        list.add(new int[] {0, 0}); // 기준점에서 상대 좌표

        while(!queue.isEmpty()) {
            int[] v = queue.poll();
            int r = v[0], c = v[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr >= map.length || nc >= map.length 
                    || map[nr][nc] != target) continue;
                queue.offer(new int[] {nr, nc});
                map[nr][nc] = visitCheck;   
                list.add(new int[] {nr - sr, nc - sc});
            }
        }

        return list;
    }
}
