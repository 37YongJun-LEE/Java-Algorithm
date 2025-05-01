import java.util.*;

class Solution {
    
    HashMap<String, Integer> map;
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        map = new HashMap<>(); // 확인하는 곳. 
        for (int i = 0; i < 10; i++ ){
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1 );
        }
        
        boolean flag = true;
        for (int i = 0; i < want.length; i++) {
            if (number[i] > map.getOrDefault(want[i], 0)) {
                flag = false;
            };
        }
        if (flag) answer++;
        
        for (int i = 10; i < discount.length; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1 );
            map.put(discount[i-10], map.getOrDefault(discount[i-10], 0) - 1);
            
            flag = true;
            for (int idx = 0; idx < want.length; idx++) {
                if (number[idx] > map.getOrDefault(want[idx], 0)) {
                    flag = false;
                }
            }
            if (flag) {
                answer++;
            }
        }
        
        
        return answer;
    }
}