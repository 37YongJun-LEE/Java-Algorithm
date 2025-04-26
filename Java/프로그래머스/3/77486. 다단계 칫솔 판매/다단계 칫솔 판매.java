import java.util.*;

class Solution {
        
    static HashMap<String, Integer> TotalMap;
    static HashMap<String, Integer> ChargeMap;
    static HashMap<String, String> RefMap;
    
    public int[] solution(
        String[] enroll, 
        String[] referral, 
        String[] seller, 
        int[] amount
    
    ) {
        TotalMap = new HashMap<>(); // 본인, 이익
        ChargeMap = new HashMap<>(); // 본인, 이익
        RefMap = new HashMap<>(); // 본인 , 수혜자

        for (int i = 0 ; i < enroll.length; i++) {
            TotalMap.put(enroll[i], 0);
            ChargeMap.put(enroll[i], 0);
            RefMap.put(enroll[i], referral[i]);
        }
        TotalMap.put("-", 0);
        ChargeMap.put("-", 0);
        RefMap.put("-", "0");
        // 판매수익금 계산 : total과 charge
        for (int i = 0 ; i < seller.length; i++) {
            int income = ( 100 * amount[i] );
            dfs(seller[i], income); // 수혜자에게 수입 계산이 되어야함.
        }
        
        // System.out.println(TotalMap);
        
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = TotalMap.get(enroll[i]);
        }
        
        return answer;
    }
    
    public void dfs(String name, int income) { // 수혜자 수수료 수입.
        while (!name.equals("0") && income > 0) {
            int cIncome = (int)(income * (0.1));
            int sIncome = income - cIncome;
            TotalMap.put(name, TotalMap.get(name) + sIncome);
            name = RefMap.get(name);
            income = cIncome;
        }
        
    }
}