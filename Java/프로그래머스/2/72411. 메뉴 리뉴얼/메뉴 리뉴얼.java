import java.util.*;
import java.io.*;

class Solution {
    
    static HashMap<String, Integer> CourseMap;
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answerList = new ArrayList<>();
        
        CourseMap = new HashMap<>();
        
        for (String order : orders) {
            char[] cArr = new char[order.length()];
            for (int i = 0 ; i < order.length(); i++) {
                cArr[i] = order.charAt(i);
            }
            Arrays.sort(cArr);
            dfs(cArr, 0, "");
        }
        
        for (int len : course) {
            int maxCall = 0;
            for (String name : CourseMap.keySet()) {
                if (name.length() == len && CourseMap.get(name) >= 2) {
                    maxCall = Math.max(maxCall, CourseMap.get(name));
                }
            }
            
            for (String name : CourseMap.keySet()) {
                if (name.length() == len && CourseMap.get(name) >= 2) {
                    if (maxCall == CourseMap.get(name)) answerList.add(name);
                }
            }    
        }
        
        String[] answer = new String[answerList.size()];
        for (int i = 0 ; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        Arrays.sort(answer);

        
        return answer;
    }
    
    public static void dfs(char[] cArr, int idx, String course) {
        if (idx == cArr.length) {
            if (course.length() >= 2) {
                CourseMap.put(course , CourseMap.getOrDefault(course, 0) + 1);
            }
            return;
        }
        
        dfs(cArr, idx + 1, course + cArr[idx]);
        dfs(cArr, idx + 1, course);
    }
}