import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static String Word;
    static HashSet<String> Set;
    static StringBuilder SB;

    static int[] AlphaCnt;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            Word = br.readLine();
            // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
            // a b c d e f g h i j k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
            AlphaCnt = new int[26];

            for (int i = 0 ; i < Word.length(); i++) {
                AlphaCnt[Word.charAt(i) - 'a']++;
            }
//            System.out.println(Arrays.toString(AlphaCnt));
            SB = new StringBuilder();
            Set = new HashSet<>();
            dfs(0);


        }


    }

    private static void dfs(int depth) {
        if (depth == Word.length()) {
            System.out.println(SB.toString());
            return;
        }

        for (int i = 0 ; i < 26; i++) {
            if (AlphaCnt[i] > 0) {
                AlphaCnt[i]--;
                SB.append( (char)('a' + i) );
                dfs(depth + 1);
                AlphaCnt[i]++;
                SB.deleteCharAt(SB.length()-1);
            }



        }

    }

}
