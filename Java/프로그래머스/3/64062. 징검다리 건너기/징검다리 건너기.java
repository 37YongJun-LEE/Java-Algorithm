import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;

        int low = 0;
        int high = 200000001;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            int[] temp = new int[stones.length];
            for (int i = 0 ; i < stones.length; i++) {
                temp[i] = stones[i] - mid;
            }
            int cnt = 0;
            
            for (int t : temp) {
                if (t <= 0) {
                    cnt++;
                } else {
                    cnt = 0;
                }
                if (cnt == k) break;
            }
            // System.out.println("mid : " + mid);
            // System.out.println(Arrays.toString(temp));
            // System.out.println("---------------");
            // 길이가 K 보다 짧다면 >> 덜건넜다 >> 사람 늘려보기.
            // 길이가 k 보다  길다면 >> 너무 많이 건넜다 >> 사람 줄여보기 
            if (cnt == k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return high + 1;
    }
}