package week11;

import java.util.*;
import java.io.*;

public class q17086 {

	static int N, M;
	static int [][] shark;
	static int distance = -1;
	
	static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	
    public static class pos {
    	int x, y, count;
    	
    	public pos(int x, int y, int count) {
    		this.x = x;
    		this.y = y;
    		this.count = count;
    	}
    	
    }
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		shark = new int [N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				shark[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(shark[i][j] == 0) {
					int tmp = bfs(i, j);
					if(distance < tmp)
						distance = tmp;
				}
			}
		}

		System.out.println(distance);
	}
	
	public static int bfs(int i, int j) {
		
		Queue<pos> que = new LinkedList<>();
		que.add(new pos(i, j, 0));
		
		boolean [][] visit = new boolean[N][M];
		visit[i][j] = true;
		
		while(!que.isEmpty()) {
			
			pos now = que.poll();
			
			for(int k = 0; k < 8; k++) {
				
				int x = now.x + dx[k];
				int y = now.y + dy[k];
				
				if(x >= 0 && y >= 0 && x < N && y < M && !visit[x][y]) {
					if(shark[x][y] == 0) {
						visit[x][y] = true;
						que.add(new pos(x, y, now.count+1));
					}
					else {
						return now.count+1;
					}
				}
			}
		}
		return 0;
		
	}
}
