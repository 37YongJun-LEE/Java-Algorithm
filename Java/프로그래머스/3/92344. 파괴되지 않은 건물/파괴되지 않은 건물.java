import java.util.*;

class Solution {
    static int[][] sum;
    static int N, M;
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        N = board.length;
        M = board[0].length;
        sum = new int[N+1][M+1];
        
        for (int[] order : skill) {
            // System.out.println(Arrays.toString(order));
            int type = order[0];
            int sr = order[1];
            int sc = order[2];
            int er = order[3];
            int ec = order[4];
            int degree = type == 1 ? order[5] * -1 : order[5];
    
            sum[sr][sc] += degree;
            sum[sr][ec+1] += degree * (-1);

            sum[er+1][sc] += degree * (-1);
            sum[er+1][ec+1] += degree ;
            
            // for (int i = 0; i <= N; i++) 
            //     System.out.println(Arrays.toString(sum[i]));            
            // System.out.println("+++++++++++");
        }
        
        // 상하 갱신하기.
        for (int c = 0; c <= N; c++) {
            for (int r = 1; r <= N; r++) {
                sum[r][c] += sum[r-1][c];
            }
        }
        // 좌우갱신하기
        for (int r = 0; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                sum[r][c] += sum[r][c-1];
            }
        }
        for (int r = 0; r < N; r++) {
            for (int c = 0 ; c < M; c++) {
                board[r][c] += sum[r][c];
                if (board[r][c] >= 1) answer++;
            }
        }
        
        
        // for (int i = 0; i < N; i++) 
        //     System.out.println(Arrays.toString(board[i]));            
        // System.out.println("+++++++++++");
        
        
        return answer;
    }
}