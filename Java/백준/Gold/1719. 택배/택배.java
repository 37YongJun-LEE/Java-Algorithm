import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Node>[] IdjList;
    static int N, M;
    // 번호, 번호, 가중치.

    private static class Node {
        int num;
        int weight;
        public Node (int num, int weight){
            this.num = num;
            this.weight = weight;
        }
    }
    static int[][] AnswerMap;
    static int[] MinDist, FirstNode;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        IdjList = new ArrayList[N+1]; // 0번은 안쓸거임.
        for (int i = 0; i <= N; i++) {
            IdjList[i] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            IdjList[s].add(new Node(e, w));
            IdjList[e].add(new Node(s, w));

        }

//        for (int i = 0 ; i < IdjList.length; i++) {
//            System.out.println(IdjList[i]);
//            for (int j = 0 ; j < IdjList[i].size(); j++) {
//                System.out.println(i + " " + IdjList[i].get(j).num + " " + IdjList[i].get(j).weight);
//            }
//        }

        AnswerMap = new int[N+1][N+1];
        for (int start = 1; start <= N; start++) {

            MinDist = new int[N+1];
            Arrays.fill(MinDist, Integer.MAX_VALUE);

            FirstNode = new int[N+1];
//            Arrays.fill(MinDist, Integer.MAX_VALUE);

            dijkstra(start); // 시작, 끝, sum

//            System.out.println(start);
//            System.out.println(Arrays.toString(MinDist));
//            System.out.println(Arrays.toString(FirstNode));

            for (int i = 1; i <= N; i++) {
                if (FirstNode[i] == 0) {
                    System.out.print("- ");
                } else {
                    System.out.print(FirstNode[i] + " ");
                }
            }
            System.out.println();
        }



    }

    private static void dijkstra(int start) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start, 0, 1, start}); // start, sum:거리합계, depth, firstNode

        while(!queue.isEmpty()) {
            int[] v = queue.poll();
            int now = v[0];
            int sum = v[1];
            int depth = v[2];
            int firstNode = v[3];

            for (Node next : IdjList[now]) {
                if (next.num == start) continue;

                if (depth == 1) firstNode = next.num;

                if (MinDist[next.num] > sum + next.weight) {
                    queue.offer(new int[] {next.num, sum + next.weight, depth + 1, firstNode});
                    MinDist[next.num] = sum + next.weight;
                    FirstNode[next.num] = firstNode;
                }
            }

        }

    }


}
