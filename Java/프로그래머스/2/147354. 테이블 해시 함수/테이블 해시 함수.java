import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        //규칙 1. col번째 컬럼(새로) 기준 정렬하기. 
        // >> 이때 오름차순으로 정렬하지만, 값이 똑같다면 >> 기본키(첫번째 컬럼[0]) 기준으로 내림차순 정렬
        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] == b[col - 1]) return b[0] - a[0];
            return a[col - 1] - b[col - 1];
        });
        
        // 규칙 2. 정렬된 데이터에서 i번째 행의 튜블들에 대해 각 컬럼을 i로 나눈 나머지들의 합을 S_i 라고 정의
        int[] S_i = new int[row_end - row_begin + 1];
        int i = 0;
        for (int idx = row_begin-1; idx <= row_end-1; idx++) {
            for (int num : data[idx]) {
                S_i[i] += num % (idx+1);
            }
            i++;
        }

        // 규칙 3. row_begin ~ row_end 범위의 S_i 들을 모두 XOR 연산하여 비트값 계산하기. 
        for (int idx = 1; idx < S_i.length; idx++) {
            S_i[idx] = S_i[idx] ^ S_i[idx - 1];
        }
        
        
        return S_i[S_i.length-1];
    }
}