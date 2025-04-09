import java.io.*;
import java.util.*;


class Solution {
    static ArrayList<Integer>[] AdjList;
    static int[] Visited;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 1, 2 는 연결 등등.. 
        // 인접 연결 리스트 구현하기
        // bfs 구현하기. 
        // 방문 체크로 도달여부 구하기. > 최단시간 ++ 하기
        
        AdjList = new ArrayList[n+1]; // 0 1 2 3 n
        for (int i = 0 ; i <= n; i++) {
            AdjList[i] = new ArrayList<>();
        }
        
        for (int[] arr : roads) {
            int a = arr[0];
            int b = arr[1];
            AdjList[a].add(b);
            AdjList[b].add(a);
        }
        
        int idx = 0;
        // for (ArrayList<Integer> list : AdjList) {
        //     System.out.print(idx++);
        //     System.out.println(list);
        // }
        
        
        // 시작은 sources 위치 -> 목적지는 destination;
        int[] answer = new int[sources.length];
        
        Visited = new int[n+1];
        Arrays.fill(Visited, Integer.MAX_VALUE);
        bfs(destination); // 시작, 끝 명시
        // System.out.println(Arrays.toString(Visited));
        
        for ( int i = 0; i < sources.length; i++) {
            answer[i] = Visited[sources[i]];
            if (answer[i] == Integer.MAX_VALUE) answer[i] = -1;
        }
        
        return answer;
    }
    
    static void bfs(int start) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        queue.offer(new int[] {start, 0}); // {nextNum, cntDist}
        Visited[start] = 0;
        
        while (!queue.isEmpty()) {
            int[] v = queue.poll();
            int now = v[0];
            int dist = v[1];            
            
            for (int next : AdjList[now] )  { //AdjList
                if (Visited[next] > dist + 1) {
                    queue.offer(new int[] {next, dist + 1});
                    Visited[next] = dist + 1;
                }
            } 
        }
        
    }
}


// 다익스트라 -> 반대로 생각하기. > 목적지에서 모든 방향으로 bfs 탐색해서 각 최단거리 갱신하기.