import java.util.*;

class Solution {
    
    static ArrayList<int[]>[] AdjList;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;

        AdjList = new ArrayList[n+1]; // 정점 번호
        for (int i = 0 ; i <= n; i++) AdjList[i] = new ArrayList<>();
        for (int [] fare : fares) {
            int v1 = fare[0];
            int v2 = fare[1];
            int cost = fare[2];
            AdjList[v1].add(new int[] {v2, cost});
            AdjList[v2].add(new int[] {v1, cost});
        }
        
        // for (int i = 0 ; i <= n; i++) {
        //     System.out.print(i + ": " );
        //     for (int[] arr : AdjList[i]) {
        //         System.out.print(Arrays.toString(arr));
        //     }
        //     System.out.println();
        // }

        int[] SM = new int[n+1];
        int[] AM = new int[n+1];
        int[] BM = new int[n+1];
        
        SM = dijkstra(s, n);
        AM = dijkstra(a, n);
        BM = dijkstra(b, n);
        answer = SM[a] + SM[b];
        
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, SM[i] + AM[i] + BM[i]);
        }
        return answer;
    }
    
    public static int[] dijkstra(int start, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[1] - b[1];
        });        
        int[] visited = new int[n+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[start] = 0;
        pq.offer(new int[] {start, 0});        
        
        while(!pq.isEmpty()) {
            int[] v = pq.poll(); // {now, cost}
            int now = v[0];
            int cost = v[1];
            for (int[] nextv : AdjList[now] ) {
                if (visited[nextv[0]] > cost + nextv[1]) {
                    visited[nextv[0]] = cost + nextv[1];
                    pq.offer(new int[] {nextv[0], cost + nextv[1]});
                }
            }
        }
        
        
        return visited;
    }
    
    
    
}