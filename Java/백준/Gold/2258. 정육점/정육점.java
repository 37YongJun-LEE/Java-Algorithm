import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<int[]> MeetList;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MeetList = new ArrayList<>();
        int ws = 0;
        for (int i = 0 ; i < N ; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            MeetList.add(new int[] {a, b});
            ws += a;
        }
        if (ws < M) {
            System.out.println(-1);
            return;
        }


        Collections.sort(MeetList, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0]; // 무게는 내림차순 정렬 // 큰거부터 담기.
            return a[1] - b[1]; // 가격은 오름차순 정렬
        });

        int[] price = new int[MeetList.size()+1];
        int[] weight = new int[MeetList.size()+1];
        for (int i = 1 ; i <= MeetList.size(); i++)  {
            weight[i] = MeetList.get(i-1)[0];
            price[i] = MeetList.get(i-1)[1];
        }
        int minAnswer = Integer.MAX_VALUE;
        int weightSum = 0;
        int priceNow = 0;
        int beforePrice = 0;


        for (int i = 1; i <= MeetList.size(); i++) {
            weightSum += weight[i];
            
            if (beforePrice != price[i]) {
                priceNow = beforePrice = price[i];
            } else {
                priceNow += price[i];
            }
            if (weightSum >= M) {
                minAnswer = Math.min(minAnswer, priceNow);
            }
//            System.out.println(weightSum + ", " + priceNow);
        }

        System.out.println(minAnswer);
    }
}


/**
 4 9
 1 8
 2 6
 3 4
 4 2

 5 9
 1 2
 2 2
 3 2
 4 2
 9 3


 1. 압축 고기 배열: 가격이 같은 고기들을 압축해버리자.
 2. 그대로 고기 배열 : 입력그대로 이루어진 배열.

// 3. 무게도 정렬해야한다?

 * **/