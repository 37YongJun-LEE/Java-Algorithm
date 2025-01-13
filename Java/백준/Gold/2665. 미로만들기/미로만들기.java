import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	
	static class Node { 
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int N;
	static char[][] Map;
	static int[][] isVisited;
	static Queue<Node> queue;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		queue = new LinkedList<>();
		Map = new char[N][N];
		isVisited = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			Map[i] = br.readLine().toCharArray();
			Arrays.fill(isVisited[i], Integer.MAX_VALUE);
		}
		
		queue.offer(new Node(0, 0));
		isVisited[0][0] = 0;
		
		bfs();
		
		System.out.println(isVisited[N-1][N-1]);
		
		
	}

	private static void bfs() {
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				
				if (Map[nr][nc] == '1') {
					if (isVisited[nr][nc] > isVisited[now.r][now.c]) {
						isVisited[nr][nc] = isVisited[now.r][now.c];
						queue.offer(new Node(nr, nc));
					}
				}
				else {
					if (isVisited[nr][nc] > isVisited[now.r][now.c] + 1) {
						isVisited[nr][nc] = isVisited[now.r][now.c] + 1;
						queue.offer(new Node(nr, nc));	
					}
				}
				
				
			}
		}
		
		
	}

}
