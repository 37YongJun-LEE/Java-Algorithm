import java.util.*;


class Solution {
    
    static ArrayList<Integer>[] AdjList;
    static boolean[] Visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0 ; i < wires.length; i++) {
            int disconnect = i;
            AdjList = new ArrayList[n+1];
            for (int idx = 0; idx <= n; idx++) AdjList[idx] = new ArrayList<>();
            
            for (int j = 0 ; j < wires.length; j++) {
                if (j == disconnect) continue;
                int a = wires[j][0];
                int b = wires[j][1];
                AdjList[a].add(b);
                AdjList[b].add(a);
            }
            
            // for (int c = 0; c <= n; c++) System.out.println(c + ": " + AdjList[c]);
            
            int[] answerArr = new int[2];
            int cnt = 0;
            Visited = new boolean[n+1]; // 0번 없음에 유의
            for (int number = 1; number <= n; number++) {
                if (Visited[number]) continue;
                answerArr[cnt] = bfs(number);
                cnt++;
            }
            
            answer = Math.min(answer, Math.abs(answerArr[0] - answerArr[1]));
        }    
        
        return answer;
    }
    
    public static int bfs(int number) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(number);
        Visited[number] = true;// 0번 없음에 유의
        int cnt = 1;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : AdjList[now]) {
                if (!Visited[next]) {
                    queue.offer(next);
                    Visited[next] = true;
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}