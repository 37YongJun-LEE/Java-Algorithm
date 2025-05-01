import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        
        for (int len = 0; len < s.length(); len++) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0 ; i < sb.toString().length(); i++) {
                
                if ( stack.isEmpty() ){
                    stack.add(sb.toString().charAt(i));
                } else {
                    if (stack.peek() == '[' && sb.toString().charAt(i) == ']') {
                        stack.pop();
                    } else if (stack.peek() == '(' && sb.toString().charAt(i) == ')') {
                        stack.pop();
                    } else if (stack.peek() == '{' && sb.toString().charAt(i) == '}') {
                        stack.pop();
                    } else {
                        stack.add(sb.toString().charAt(i));
                    }
                }         
            }
            if (stack.isEmpty() ) answer++;
            // 회전
            sb.append(s.charAt(len));
            sb.deleteCharAt(0);
        }
        
        return answer;
    }
}

// 현재문자열 확인하기 >> 스택을 통해서 여부 판단.
// 확인 후 -> 회전 ..문자열 길이만큼 진행.
