import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String scroll = br.readLine(); //
        String angel = br.readLine();  //
        String devil = br.readLine();  //

        int[][][] dp = new int[2][scroll.length()+1][angel.length()+1]; // [글자 길이][다리 길이][T or B]
                            // 2 4 7
        for (int i = 0; i < angel.length(); i++) {
            dp[0][0][i] = 1;
            dp[1][0][i] = 1;
        }
        for (int i = 1; i <= scroll.length(); i++) {
            for (int j = 1; j <= angel.length(); j++) {
                    if ( scroll.charAt(i-1) != angel.charAt(j-1)) {
                        dp[0][i][j] = dp[0][i][j-1];
                    } else {
                        dp[0][i][j] = dp[0][i][j-1] + dp[1][i-1][j-1];
                    }
                    if ( scroll.charAt(i-1) != devil.charAt(j-1) ) {
                        dp[1][i][j] = dp[1][i][j-1];
                    } else {
                        dp[1][i][j] = dp[1][i][j-1] + dp[0][i-1][j-1];
                    }
            }
        }

//        for (int tb = 0; tb < 2; tb++) {
//            System.out.println(tb);
//            for (int i = 1; i <= scroll.length(); i++) {
//                System.out.println(Arrays.toString(dp[tb][i]));
//            }
//            System.out.println();
//        }

        System.out.println(dp[0][scroll.length()][angel.length()] + dp[1][scroll.length()][devil.length()]);

    }
}


/**
 * 참고.
 * https://minsu20.tistory.com/81
 * **/