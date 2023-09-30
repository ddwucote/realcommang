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
		
		visit = new boolean[M][N];
		percolate = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			String str = sc.next();
			for(int j = 0; j < N; j++) {
				percolate[i][j] = str.charAt(j) - '0';
				visit[i][j] = false;
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(percolate[0][i] == 0) //첫째줄
				reachInner(0, i);
		}
		
		if(result)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
	public static void reachInner(int i, int j) {
		
		visit[i][j] = true;
		
		if(i == (M-1) && percolate[i][j] == 0) {//마지막행
			//System.out.println("i" + " ,j " + i + " " + j);
			result = true;
			return;
		}
		
		for(int k = 0; k < 4; k++) {
			
			int x = dx[k] + i;
			int y = dy[k] + j;
			
			if(x >= 0 && y >= 0 && x < M && y < N && percolate[x][y] == 0 && !visit[x][y]) {
				//System.out.println("x" + " ,y " + x + " " + y);
				reachInner(x,y);
			}
		}			
	}
}
