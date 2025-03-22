import java.util.*;

class Solution {
    static HashSet<String> GemsSet;
    static HashMap<String, Integer> GemsMap;
    static ArrayList<int[]> AnswerList;
        
    public int[] solution(String[] gems) {
        GemsSet = new HashSet<>();
        AnswerList = new ArrayList<>();
        for (String gem : gems) {GemsSet.add(gem);}
        
        int left = 0;
        int right = 0;
        GemsMap = new HashMap<String, Integer>();
        for (right = 0; right < gems.length; right++) {
            if (GemsMap.containsKey(gems[right])) {
                GemsMap.put(gems[right], GemsMap.get(gems[right]) + 1);
            } else {
                GemsMap.put(gems[right], 1);
            }
            
            while (GemsSet.size() == GemsMap.size() && left <= right) {
                AnswerList.add(new int[] {right - left + 1, left, right}); // 길이 , left, right
                GemsMap.put(gems[left], GemsMap.get(gems[left]) - 1);
                if (GemsMap.get(gems[left]) == 0) GemsMap.remove(gems[left]);
                left++;
            } 
        }        

        Collections.sort(AnswerList, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        return new int[] {AnswerList.get(0)[1] + 1, AnswerList.get(0)[2] + 1};
    }
}

/**
    >> 종류개수를 구하고. 
    >> 맵 자료구조의 사이즈 체크를 통해서 사이즈가 동일해질때까지 오른쪽 증가.
    >> 종류개수와 맵사이즈 개수가 동일해지면 왼쪽에서 감소 시작. 
    >> 감소 이후에도 종류개수와 맵사이즈 개수 동일하면 최소구간갱신. 
    >> 반복.
**/