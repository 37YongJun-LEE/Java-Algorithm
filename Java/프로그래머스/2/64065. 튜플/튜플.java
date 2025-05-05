import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        StringBuilder sb = new StringBuilder();
        int n = 0;
        for (int i = 0; i < s.length(); i++ ) if (s.charAt(i) == '}') n++;
        n -= 1;
        
        ArrayList<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s);
        for (int i = 0 ; i< n; i++) {
            String atom = st.nextToken("}");
            list.add(atom.substring(2, atom.length()));
        }
        Collections.sort(list, (a, b) -> a.length() - b.length());
        
        ArrayList<Integer> answerList = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (String str : list) {
            st = new StringTokenizer(str);
            while(st.hasMoreTokens()) {
                // System.out.print(st.nextToken(","));
                int num = Integer.parseInt(st.nextToken(","));
                if (set.add(num) ){
                    answerList.add(num);
                }
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0 ; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}