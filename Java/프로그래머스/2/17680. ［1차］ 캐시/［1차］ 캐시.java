import java.util.*;

class Solution {
    static ArrayList<String> cacheList;
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) return cities.length * 5;
        cacheList = new ArrayList<>();
        
        for (String city : cities) {
            city = city.toLowerCase();
            if (cacheList.isEmpty()) {
                cacheList.add(city);
                answer += 5;
            } else {
                // 찾기.
                if (find(city)) {
                    answer += 1;
                    change(city);
                } else {
                    answer += 5;
                    if (cacheList.size() < cacheSize) { // 추가.
                        cacheList.add(city);
                    } else { // 맨 마지막 교체.
                        changeRecently(city);
                    }
                }
            }
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
                cacheList.remove(i);
                cacheList.add(city);
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