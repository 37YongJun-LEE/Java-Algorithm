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
            int gap = attack[0] - time - 1;
            time = attack[0];
            int deal = attack[1];
            
            hp += gap * hps ; // 초당 회복
            hp += (gap / t) * tps; // t초당 회복
            if (hp >= health) hp = health;

            hp -= deal;
            if (hp <= 0 ) return -1;
        }
        return hp;
    }
}