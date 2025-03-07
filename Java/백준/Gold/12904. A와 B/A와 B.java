import java.io.*;

public class Main {
    static StringBuilder S,T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = new StringBuilder(br.readLine());
        T = new StringBuilder(br.readLine());

        while (S.length() < T.length() ) {
            if (T.charAt(T.length()-1) == 'A') {
                T.deleteCharAt(T.length()-1);
            } else {
                T.deleteCharAt(T.length()-1);
                T.reverse();
            }
        }

        if (S.toString().equals(T.toString())) System.out.println(1);
        else System.out.println(0);

    }
}
