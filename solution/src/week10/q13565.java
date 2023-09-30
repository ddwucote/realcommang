package week10;

import java.util.*;
import java.io.*;

public class q13565 {

	static boolean result = false;
	
	static int M, N;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	static boolean [][] visit = new boolean [1001][1001];
	static int [][] percolate = new int [1001][1001];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		visit = new boolean[N][M];
		percolate = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			for(int j = 0; j < M; j++) {
				percolate[i][j] = str.charAt(j) - '0';
				visit[i][j] = false;
			}
		}
		
		for(int i = 0; i < M; i++) {
			if(percolate[0][i] == 0) 
				reachInner(0, i);
		}

		if(result)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
	public static void reachInner(int i, int j) {
		
		visit[i][j] = true;
		
		if(i == (N-1) && percolate[i][j] == 0) {
			result = true;
			return;
		}
		
		for(int k = 0; k < 4; k++) {
			
			int x = dx[k] + i;
			int y = dy[k] + j;
			
			if(x >= 0 && y >= 0 && x < N && y < M) {
				if(percolate[x][y] == 0 && !visit[x][y]) {					
					reachInner(x,y);
				}
				
			}
		}			
	}
}
