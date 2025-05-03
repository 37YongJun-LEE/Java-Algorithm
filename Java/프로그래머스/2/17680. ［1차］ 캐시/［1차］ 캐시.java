import java.util.*;

class Solution {
    static ArrayList<String> cacheList;
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) return cities.length * 5;
        cacheList = new ArrayList<>();
        
        for (String city : cities) {
            city = city.toLowerCase();
            // System.out.print(city + " ");
            
            if (cacheList.isEmpty()) {
                // System.out.println("MISS");
                cacheList.add(city);
                answer += 5;
            } else {
                // 찾기.
                if (find(city)) {
                    // System.out.println("HIT");
                    
                    answer += 1;
                    change(city);
                } else {
                    // System.out.println("MISS");
                    answer += 5;
                    // 추가 조건
                    
                    if (cacheList.size() < cacheSize) { // 추가.
                        cacheList.add(city);
                        
                    } else { // 맨 마지막 교체.
                        changeRecently(city);
                    }
                }
                
            }
            
            // System.out.println(cacheList);
        }
        
        
        return answer;
    }
    
    public static void changeRecently(String city) {
        cacheList.remove(0);
        cacheList.add(city);
    }
    
    public static void change(String city) {
        for (int i = 0; i < cacheList.size(); i++) {
            if (city.equals(cacheList.get(i))) {
                // System.out.println("remove" + cacheList.get(i));
                cacheList.remove(i);
                cacheList.add(city);
                // System.out.println("add" + city);
                return;
            }
        }
        return;
    }
    
    public static boolean find(String city) {
        
        for (String name : cacheList) {
            if (city.equals(name)) {
                return true;
            }
        }
        return false;
    }
}


/** 
입력된 도시이름 배열을 순서대로 처리할 때, "총 실행시간"을 출력한다.
1. LRU
    > 가장 최근에 사용된 캐시를 교체(순서바꾸기.) >> ArrayList로 구현하기.
    0이 가장 오래전 >> list.size()-1dl 가장 최근 사용된여부.
    >> 여부 판단
    1) 스택 빈공간 여부
        비어있다
            > MISS > 5
            
        안비어있다.
            > ArrayList 크기 ㅣ해봤자 30개니까 그냥 순회해서 찾기. 
            찾음
                > HIT > 1
                > 교체
            못찾음 
                > MISS > 5
                > 추가
                    캐시사이즈 체크
                        > list.size() == cacheSize
                            > 교체
                        > list.size() != cacheSize
                            > 그냥 추가.



2. cache hit > 1 시간 
3. cache miss > 5 시간

**/