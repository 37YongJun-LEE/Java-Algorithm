import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static HashMap<String, String> Map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map = new HashMap<String, String>();
        for (int i = 1; i<= N; i++) {
            String name = br.readLine();
            Map.put(name, "" + i);
            Map.put(""+i , name);
        }

//        System.out.println(Map);
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (Map.containsKey(str)) {
                System.out.println(Map.get(str));
            }
        }


    }
}
