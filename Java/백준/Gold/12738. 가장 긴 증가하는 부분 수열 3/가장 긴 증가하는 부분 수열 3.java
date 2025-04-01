import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer> LIS;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        LIS = new ArrayList<>();
        for (int i = 0 ; i < N; i++ ) {
            int now = Integer.parseInt(st.nextToken());
            if (LIS.isEmpty()) {
                LIS.add(now);
            } else {

                int last = LIS.get(LIS.size() - 1);
                if (last < now) {
                    LIS.add(now);
                } else {
                    int low = 0;
                    int high = LIS.size();
                    while (low <= high) {
                        int mid = (low + high) / 2;

                        if (LIS.get(mid) < now) { // 크거나 같으면,
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }
                    LIS.set(low, now);
                }
            }
        }
        System.out.println(LIS.size());

    }
}
