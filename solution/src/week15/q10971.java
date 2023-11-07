package week15;

import java.util.*;
import java.io.*;

public class q10971 {

	static int N;
	static int [][] W;
	static boolean [] visited;
	static int N1;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		W = new int [N][N];
		visited = new boolean [N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				N1 = i;
				dfs(i, 0, 0);
				visited[i] = true;
			}
		}
	}

	static void dfs(int start, int count, int sum) {

		visited[start] = true;
		
		if(count == N-1) {
			
			for(int i = 0; i < N; i++) {
				visited[i] = false;
			}
			
			if(start == N1) {
				System.out.println(sum + W[start][N1]);
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i] && (W[start][i] != 0)) {
				System.out.println(start + " " + i);
				dfs(i, count+1, sum + W[start][i]);
			}
		}
	}
}
