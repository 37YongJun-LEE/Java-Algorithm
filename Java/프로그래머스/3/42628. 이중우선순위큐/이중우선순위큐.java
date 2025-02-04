import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        StringTokenizer st;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (String str : operations) {
            // System.out.println(str);
            st = new StringTokenizer(str);
            String cmd = st.nextToken();
            int number = Integer.parseInt(st.nextToken());
            
            if (cmd.equals("I")) { // I = 삽입
                list.add(number);
                Collections.sort(list);
            } else { // D = 삭제.
                if (!list.isEmpty()) {
                    if (number == 1) { // 최댓값 삭제
                        list.remove(list.size()-1);
                    } else { // number = -1 // 최솟값 삭제
                        list.remove(0);
                    }   
                }
            }
            
        }
        
        
        if (!list.isEmpty()) {
            Collections.sort(list);
            answer = new int[] {list.get(list.size()-1), list.get(0)};
        }
        
        System.out.println(list);
        
        return answer;
    }
}