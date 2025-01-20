import java.util.*;
import java.io.*;

public class Main {
    static int T;

    static int N, M;
    static int[] MList;

    static ArrayList<int[]> CafeList;

    static ArrayList<Integer>[] CafeListAdj;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            CafeList = new ArrayList<>();

            CafeListAdj = new ArrayList[100001];
            for (int i = 0; i < 100001; i++) {
                CafeListAdj[i] = new ArrayList<>();
            }

            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                CafeListAdj[row].add(col);
            }

            // 풀이 .
            // 모든 애들 정렬: 정렬 기준 >> 이전 now.col의 크기가 min인지 max인지.
            int now = 0;
            for (int i = 0; i < 100001; i++) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int j = 0; j < CafeListAdj[i].size(); j++){
                    min = Math.min(min, CafeListAdj[i].get(j));
                    max = Math.max(max, CafeListAdj[i].get(j));
                }

                // 정렬에서 음수일때는 순서가 뒤바뀔수 있으므로 정렬 통일성 유지를 위해서 ABS 먹인다.
                if (min != Integer.MAX_VALUE || max != Integer.MIN_VALUE) {
                    if (now == min) { // 오름차순 정렬
                        CafeListAdj[i].sort((a, b) -> {
                            return a - b;
                        });
                        now = max;
                    } else { // 내림차순 정렬.
                        CafeListAdj[i].sort((a, b) -> {
                            return b - a;
                        });
                        now = min;
                    }
                }
            }

            ArrayList<int[]> AnswerList = new ArrayList<>();

            int num = 1;
            for (int i = 0; i < 100001; i++) {
                for (int j = 0; j < CafeListAdj[i].size(); j++){
                    AnswerList.add(new int[] {i, CafeListAdj[i].get(j)});
//                    System.out.println(num + ": " + i + "," + CafeListAdj[i].get(j));
                    num++;
                }
            }

            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            for (int m = 0; m < M; m++) {
                int idx = Integer.parseInt(st.nextToken()) - 1;
                System.out.println(AnswerList.get(idx)[0] + " " + AnswerList.get(idx)[1]);
            }

        }



    }
}
