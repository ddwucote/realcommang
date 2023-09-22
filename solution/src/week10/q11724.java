package week10;

import java.util.*;
import java.io.*;

public class q11724 {

	static int N;
	static int M;
	static int [][] graph = new int [1001][1001];
	static boolean [] visit = new boolean [1001];
	static int link = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int [N+1][N+1];
		
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j < N; j++) {
				graph[i][j] = 0;
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u][v] = 1;
			graph[v][u] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			if(visit[i] == false) {
				countLink(i);
				link++;
			}
		}
		System.out.println(link);
	}
	
	static void countLink(int idx) { //dfs
		
		if(visit[idx] == true)
			return;
		else {
			visit[idx] = true;
			for(int i = 1; i <= N; i++) {
				if(graph[idx][i] == 1)
					countLink(i);
			}
		}
	}

}
