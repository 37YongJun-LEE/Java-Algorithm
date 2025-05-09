import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int t = bandage[0];
        int hps = bandage[1];
        int tps = bandage[2];
        
        int hp = health; 
        int time = 0;
        
        for (int[] attack : attacks) {
            System.out.println(time);
            System.out.println(Arrays.toString(attack));
            int gap = attack[0] - time - 1;
            
            time = attack[0];
            int deal = attack[1];
            
            System.out.println(gap);
            
            // 회복
            hp += gap * hps ; // 초당 회복
            hp += (gap / t) * tps; // t초당 회복
            if (hp >= health) hp = health;

            // 공격
            hp -= deal;
            if (hp <= 0 ) return -1;
            
            // System.out.println("==================");
        }
        
        return hp;
    }
}