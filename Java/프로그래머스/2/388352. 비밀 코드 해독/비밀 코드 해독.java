import java.util.*;

class Solution {
    
    static int[] arr;
    static int answer;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        arr = new int[5];
        
        // for (int i = 0; i < ans.length; i++) {
        //     System.out.println(Arrays.toString(q[i]) + " ==> " + ans[i]);
        // }
        
        dfs(n, q, ans, 0, 1); //int idx, int start
        
        
        return answer;
    }
    
    public static void dfs(int n, int[][] q, int[] ans, int idx, int start) {
        if (idx == 5) {
            
            HashSet<Integer> set = new HashSet<>();
            for (int num : arr) set.add(num);

            boolean secretPossible = true;
            for (int i = 0 ; i < q.length; i++) {
                int tempCnt = 0;
                for (int j = 0 ; j < q[i].length; j++) {
                    if (set.contains(q[i][j])) {
                        // System.out.print("yes");
                        tempCnt++;
                    } else {
                        // System.out.print("no");
                    }
                }
                
                if (tempCnt != ans[i]) secretPossible = false;
            }
            
            if (secretPossible) answer++;
            return;
        }
    
        for (int num = start; num <= n; num++) {
            arr[idx] = num;
            dfs(n, q, ans, idx + 1, num + 1);
            
        }
        
    }
}