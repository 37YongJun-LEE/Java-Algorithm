import java.util.*;
import java.io.*;

public class Main {

    static HashMap<String, String> Parent;
    static HashMap<String, Integer> SizeMap;

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            int F = Integer.parseInt(br.readLine());

            Parent = new HashMap<>();
            SizeMap= new HashMap<>();

            for (int f = 0; f < F; f++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!Parent.containsKey(a)) {
                    Parent.put(a, a);
                    SizeMap.put(a, 1);
                }
                if (!Parent.containsKey(b)) {
                    Parent.put(b, b);
                    SizeMap.put(b, 1);
                }
                union(a, b);
                System.out.println(SizeMap.get(find(a)));
            }


        }
    }

    public static void union(String a, String b) {
        a = find(a);
        b = find(b);
        if (a.equals(b)) return;

        Parent.put(b, find(a));
        SizeMap.put(a, SizeMap.get(a) + SizeMap.get(b));
        SizeMap.put(b, 1);
    }

    public static String find(String name) {
        String parent = "";

        if (name.equals(Parent.get(name)) ) return name;
        Parent.put(name, find(Parent.get(name)));
        return Parent.get(name);
    }

}

/**

 2
 3
 Fred Barney
 Barney Betty
 Betty Wilma
 3
 Fred Barney
 Betty Wilma
 Barney Betty


 */
