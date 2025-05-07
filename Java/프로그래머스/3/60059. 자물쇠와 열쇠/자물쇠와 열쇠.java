import java.util.*;
class Solution {
    
    static int[][] Map, CopyMap;
    static int N, M;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        N = lock.length;
        M = key.length;
        Map = new int[2*M + N][2*M + N];
        CopyMap = new int[2*M + N][2*M + N];
            
        for (int i = 0 ; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lock[i][j] == 1) {
                    Map[i+M][j+M] = 1;
                    CopyMap[i+M][j+M] = 1;
                }
            }
        }
        
        
        for (int rCnt = 0; rCnt < 4; rCnt++) {
            key = rotate(key);
            for (int sr = 0; sr <= M + N; sr++) {
                for (int sc = 0; sc <= M + N; sc++) {
                    mapClear();
                    
                    // boolean isValid = true; // 🔧 [수정된 부분] 충돌 검사
                    for (int r = 0; r < M; r++) {
                        for (int c = 0; c < M; c++) {
                            if (key[r][c] == 1) {
                                Map[r + sr][c + sc] += 1;
                            }
                        }
                    }
                    if (isOpen()) {
                        return true;
                    }
                }
            }
        }
        
        return answer;
    }
    
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static int[][] rotate(int[][] key) {
        int[][] rotatedKey = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                rotatedKey[j][M-1-i] = key[i][j];
            }
        }
        return rotatedKey;
    }
    
    public static boolean isOpen() {
        boolean open = true;
        for (int i = 0 ; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Map[i+M][j+M] != 1) {
                    open = false;
                }
            }
        }
        return open;
    }
    
    public static void mapClear() {
        for (int i = 0 ; i < Map.length; i++) {
            for (int j = 0 ; j < Map.length; j++) {
                Map[i][j] = CopyMap[i][j];
            }
        }
    }
}