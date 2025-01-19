import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] Number;
    static int Plus, Minus, Multiple, Divide;
    static int MinAnswer = Integer.MAX_VALUE;
    static int MaxAnswer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Number = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Number[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        Plus = Integer.parseInt(st.nextToken());
        Minus = Integer.parseInt(st.nextToken());
        Multiple = Integer.parseInt(st.nextToken());
        Divide = Integer.parseInt(st.nextToken());
        backTracking(1, Plus, Minus, Multiple, Divide, Number[0]); // int idx , + , - , *, /, 초기 숫자.

        System.out.println(MaxAnswer);
        System.out.println(MinAnswer);

    }

    private static void backTracking(int idx, int plus, int minus, int multiple, int divide, int calculate) {
        // 기저조건
        if (idx == N) {
            MinAnswer = Math.min(MinAnswer, calculate);
            MaxAnswer = Math.max(MaxAnswer, calculate);
            return;
        }

        if (plus != 0) {
            backTracking(idx + 1, plus - 1, minus, multiple, divide, calculate + Number[idx]);
        }
        if (minus != 0) {
            backTracking(idx + 1, plus, minus - 1, multiple, divide, calculate - Number[idx]);
        }
        if (multiple != 0) {
            backTracking(idx + 1, plus, minus, multiple - 1, divide, calculate * Number[idx]);
        }
        if (divide != 0) {
            if (calculate < 0) {
                calculate = -1 * (Math.abs(calculate) / Number[idx] );
            } else {
                calculate = calculate / Number[idx] ;
            }

            backTracking(idx + 1, plus, minus, multiple, divide - 1, calculate);
        }
    }

}
