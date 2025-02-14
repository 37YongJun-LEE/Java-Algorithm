import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int[] A = new int[str.length()];
        int[] ACopy = new int[str.length()];
        for(int i = 0 ; i < str.length(); i++) {
            A[i] = str.charAt(i) - '0';
            ACopy[i] = str.charAt(i) - '0';
        }
        str = br.readLine();
        int[] B = new int[str.length()];
        for(int i = 0 ; i < str.length(); i++) B[i] = str.charAt(i) - '0';

        ACopy[0] = 1 - ACopy[0];
        ACopy[1] = 1 - ACopy[1];


//        n-2, n-1, n;
        int cnt = 0;
        for (int  i = 0; i < n-1; i++) {
            if (A[i] != B[i]) {
                A[i] = 1 - A[i];
                if (i+1 < n) {
                    A[i+1] = 1 - A[i+1];
                }
                if (i+2 < n) {
                    A[i+2] = 1 - A[i+2];
                }
                cnt++;
            }
        }
        if (A[n-1] != B[n-1]) {
            cnt = -1;
        }


        int cnt2 = 0;
        for (int  i = 0; i < n-1; i++) {
            if (ACopy[i] != B[i]) {
                ACopy[i] = 1 - ACopy[i];
                if (i+1 < n) {
                    ACopy[i+1] = 1 - ACopy[i+1];
                }
                if (i+2 < n) {
                    ACopy[i+2] = 1 - ACopy[i+2];
                }
                cnt2++;
            }
        }
        if (ACopy[n-1] != B[n-1]) {
            cnt2 = -1;
        }
        if (cnt2 != -1) cnt2++;



        if (cnt == -1)
            System.out.println(cnt2);
        else if (cnt2 == -1)
            System.out.println(cnt);
        else
            System.out.println(Math.min(cnt2, cnt));

    }


}
