import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[] {0, 0};

        HashMap<String, Integer> map = new HashMap<>();
         
        String before = words[0];
        
        // 맨 처음 체크
        // 3. 한글자 단어 나온 경우.
        if (before.length() <= 1) {
            return new int[] {1, 1};
        }
        map.put(words[0], 1);

        int cnt = 2;
        for (int i = 1; i < words.length; i++) {
            String now = words[i];
            if (cnt > n) {
                cnt = 1;
            }
            // 3. 앞사람 말의 마지막 문자로 시작
            // 4. 이전 등장 단어 사용 불가
            // 5. 한글자 단어 불인정.
            if (before.charAt(before.length()-1) != now.charAt(0)
                    || map.containsKey(now) 
                    || now.length() <= 1
               ) {
                
                answer = new int[] {cnt, (i+1) % n == 0 ? (i+1)/n : (i+1)/n +1};
                break;
            }
            
            map.put(now, 1);
            before = now;
            cnt++;
            // System.out.println(map);
        }

        return answer;
    }
}

/** 
영어 끝말잇기 규칙

1. 1번 부터 차례대로 진행
2. 마지막 사람이 말한다음 다시 1번
//
3. 앞사람 말의 마지막 문자로 시작
4. 이전 등장 단어 사용 불가
5. 한글자 단어 불인정.



// 풀이
자료구조 : 맵
String , Integer 값 체크

이전단어
이전단어 맨 마지막 글자
지금단어
지금단어 맨 처음 글자


탈락자 나오는 경우
1. 맨 마지막 단어와 맨 처음 글자 다른 경우
2. 이미 존재하는 단어 말한 경우
3. 한글자 단어 나온 경우.


**/