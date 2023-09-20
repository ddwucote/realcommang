package week9;

import java.io.*;
import java.util.*;

public class q14940 {

	static int[] plus1 = {1, 0, -1, 0};
	static int[] plus2 = {0, -1, 0, 1};
	static int[][] map, distance;
	static boolean [][] isVisited;
	
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		boolean isStartChecked = false;
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int startX = -1, startY = -1;
		
		map = new int [n][m];
		distance = new int [n][m];
		isVisited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			if(!isStartChecked)
				for(int j=0; j<m; j++)
					if(map[i][j] == 2) {
						isStartChecked = true;
						startX = i;
						startY = j;
						break;
					}
		}
		
		bfs(startX, startY);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) 
				if(!isVisited[i][j] && map[i][j] == 1)
					sb.append(-1 + " ");
				else
					sb.append(distance[i][j] + " ");
				sb.append("\n");			
		}
		System.out.print(sb.toString());
	}
		
		static void bfs(int x, int y) {
			Queue<Point> que = new LinkedList<>();
			que.add(new Point(x,y));
			isVisited[x][y] = true;
			
			while(!que.isEmpty()) {
				Point cur = que.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = cur.x + plus1[i];
					int ny = cur.y + plus2[i];
					
					if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
					if(map[nx][ny] == 0)continue;
					if(isVisited[nx][ny])continue;
					
					que.add(new Point(nx, ny));
					distance[nx][ny] = distance[cur.x][cur.y] + 1;
					isVisited[nx][ny] = true;
				}
			}
		}

		static class Point {
			public int x, y;
			public Point(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
}
