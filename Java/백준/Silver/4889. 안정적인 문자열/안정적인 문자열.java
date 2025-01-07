import java.util.*;
import java.io.*;

public class Main {

    static Stack<Character> stack;
    static int T;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = 0;
        while (true) {
            String string = br.readLine();
            if (string == null || string.contains("-") ) {
                break;
            } else if (string.isEmpty()) {
                T++;
                int answer = 0;
                System.out.print(T + ". ");
                System.out.println(answer);
            } else {
                T++;
                stack = new Stack<>();

                // 풀이 //
                for (int i = 0; i < string.length(); i++) {
                    stack.push(string.charAt(i));
                    while (stack.size() >= 2) {
                        char now = stack.pop();
                        if (now == '{') {
                            stack.push(now);
                            break;
                        } else { // now == '}'
                            if (stack.peek() == '{') {
                                stack.pop();
                            } else {
                                stack.push(now);
                                break;
                            }
                        }
                    }
                }

                int answer = 0;
                while (stack.size() >= 2) {
                    char now = stack.pop();
                    if (stack.peek() == now) { // 같은경우는 하나만 바꾸면됌.
                        answer++;
                        stack.pop();
                    } else { // 다른경우. 는 2개다 바꿔야함.
                        answer++;
                        answer++;
                        stack.pop();
                    }
                }
//                System.out.println(stack);
                System.out.print(T + ". ");
                System.out.println(answer);
//                System.out.println(string);
            }
        }


    }
}
