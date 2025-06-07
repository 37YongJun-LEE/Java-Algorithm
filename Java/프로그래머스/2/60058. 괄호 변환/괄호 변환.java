import java.util.*;
import java.io.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        answer = dfs(p);
        return answer;
    }
    
    public static String dfs(String w) {
        if (w.equals("")) {
            return w;
        } else {
            // u,v 나누기 로직
            int lCnt = 0;
            int rCnt = 0;
            
            int idx = 0;
            for (int i = 0; i < w.length(); i++) {
                if (w.charAt(i) == '(') {lCnt++;
                } else {rCnt++;}
                idx = i;
                if (lCnt == rCnt) {break;}
            }
            String u = w.substring(0, idx+1);
            String v = w.substring(idx+1, w.length());

            // u 올바른 문자열 판단.
            StringBuilder sb = new StringBuilder();
            if (rightCheck(u)) {
                // System.out.println("u는 올바름");
                sb.append(u);
                sb.append(dfs(v));
                return sb.toString();
            } else {
                // System.out.println("올바르지 않음");
                v = dfs(v);
                u = u.substring(1, u.length()-1);
                u = reverse(u);
                
                sb.append("(");
                sb.append(v);
                sb.append(")");
                
                sb.append(u);
                return sb.toString();
            }
        }
    }
    
    public static String reverse(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') sb.append(')');
        else sb.append('(');
    }
        return sb.toString();
    }

    
    public static boolean rightCheck(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (stack.peek() == '(' && s.charAt(i) == ')') stack.pop();
                else stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}