import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        // 서로 다른 종류가 최소인 경우 만들기.
        // 한상자 k개, 귤 배열. >> 개수를 센다 . > 정렬한다. > 최소부터 뺴야하는 개수만큼 뺸다?
        // Arrays.sort(tangerine);
        // System.out.println(Arrays.toString(tangerine));
        
        // 크기와 개수로 나누고 개수 기준으로 정렬해서 가장 적은 거 부터 빼면 최소종류가 된다.
        
        HashMap<Integer, Integer> map = new HashMap<>();       
        
        for (int num : tangerine) {
            map.put(num , map.getOrDefault(num, 0) + 1);
        }

        ArrayList<int[]> list  = new ArrayList<>();

        for (int num : map.keySet()) {
            list.add(new int[] {num, map.get(num)});
        }
        
        Collections.sort(list, (a, b) -> {
            return a[1] - b[1];
        });
        
        // k 
        
        if ( tangerine.length > k ) {
            int minusCnt = tangerine.length - k;
            System.out.println(minusCnt);
            for (int[] arr : list) {
                if (arr[1] <= minusCnt) {
                    minusCnt -= arr[1];
                    arr[1] = 0;
                } else {
                    arr[1] -= minusCnt;
                }
            }
            
        }

        
        for (int[] arr : list) if (arr[1] != 0) answer++;
        
        return answer;
    }
}

// 	[3, 1]
// [2, 3]
// [1, 4]