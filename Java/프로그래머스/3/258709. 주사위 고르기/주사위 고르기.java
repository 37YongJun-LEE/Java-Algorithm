import java.util.*;

class Solution {
    static boolean[] DiceTF;
    static int MaxA;
    static int[] answer;
    
    static ArrayList<Integer> aList, bList, aScoreList, bScoreList;
    
    public int[] solution(int[][] dice) {
        answer = new int[dice.length];
        
        DiceTF = new boolean[dice.length];
        
        dfsDiceTF( dice, 0);
        
        return answer;
    }
    
    
    
    public static void dfsDiceTF(int[][] dice , int idx) {
        if (idx == dice.length) {
            aList = new ArrayList<>();
            bList = new ArrayList<>();
            for (int i = 0 ; i < DiceTF.length; i++) {
                if (DiceTF[i]) aList.add(i); // aCnt++;
                else bList.add(i);// bCnt++;
            }
            
            if (aList.size() == bList.size()) {
                // System.out.println(aList);
                aScoreList = getScore(dice, aList);
                bScoreList = getScore(dice, bList);
                Collections.sort(bScoreList);
                int aWinCnt = 0;
                for (int score : aScoreList) {
                    aWinCnt += lowerBound(score);
                }
                if (MaxA < aWinCnt) {
                    MaxA = aWinCnt;
                    // System.out.println(aWinCnt);
                    answer = new int[aList.size()];
                    int cnt = 0;
                    for (int num : aList) {
                        answer[cnt] = num+1;
                        cnt++;
                    }
                }
                
                
            }
            return;
        }
        DiceTF[idx] = true;
        dfsDiceTF( dice, idx + 1);
        DiceTF[idx] = false;
        dfsDiceTF( dice, idx + 1);
    }
    
    public static int lowerBound(int aScore) {
        int low = 0;
        int high = bScoreList.size();
        
        while (low < high) {
            int mid = (low + high) / 2;
            if (bScoreList.get(mid) < aScore) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
    
        return low;
    }
    
    
    public static ArrayList<Integer> getScore(int[][] dice, ArrayList<Integer> nowList) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        for (int idx : nowList) {
            ArrayList<Integer> tempList = new ArrayList<>();
            for (int listNum : list) {
                for (int num : dice[idx] ) {
                    tempList.add(listNum + num);
                }    
            }
            list = tempList;
        }
        
        return list;
    }
    
}