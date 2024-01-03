package week_donknow;

import java.util.*;
import java.io.*;

public class q2206 {

	static int N, M;
	static int [][] map;
	static boolean [][] visited;
	static int min = Integer.MAX_VALUE;
	
	static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//System.out.println(N + " " + M);
		
		map = new int [N][M];
		visited = new boolean [N][M];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
				//System.out.print(map[i][j]);
			}
			//System.out.println();
		}
		
		bfs(0, 0, 1, 1);
		
		System.out.println(min);
	}
	
	static void bfs(int x, int y, int size, int walls) {
		
		visited[x][y] = true; 
		 
		if(x == N-1 && y == M-1) {
			min = Math.min(size, min);
			visited[x][y] = false;
			return;
		}
		
		int j, k;
		
		for(int i = 0; i < 4; i++) {
			
			j = x + dx[i];
			k = y + dy[i];
			
			if(j >= 0 && k >= 0 && j < N && k < M) {
				if(map[j][k] == 0 && !visited[j][k])
					bfs(j, k, size+1, walls);
				else if(map[j][k] == 1 && !visited[j][k] && walls == 1)
					bfs(j, k, size+1, 0);
				else if(map[j][k] == 1 && !visited[j][k] && walls == 0)
					min = -1;
			}
		}
		
		visited[x][y] = false;
	}

}
