import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        int cnt = bomb.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (sb.length() >= cnt && sb.substring( sb.length() - bomb.length() , sb.length()).equals(bomb) ) {
                sb.delete(sb.length() - bomb.length() , sb.length());
            }
        }
        System.out.println( sb.length() == 0 ? "FRULA" : sb.toString() );
    }
}
