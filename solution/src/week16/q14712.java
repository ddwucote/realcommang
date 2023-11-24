package week16;

import java.util.*;
import java.io.*;

public class q14712 {

	static int N, M;
	static int result;
	static int [][] map;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		
		dfs(0);
		System.out.println(result);
		
	}
	
	static void dfs(int count) {
		if(count == N*M) {
			result++;
			return;
		}
		
		int y = count / M + 1;
		int x = count % M + 1;
		
		if(map[y-1][x] == 1 && map[y][x-1] == 1 && map[y-1][x-1] == 1) {
			dfs(count+1);
		}
		else {
			dfs(count+1);
			map[y][x] = 1;
			dfs(count+1);
			map[y][x] = 0;
		}
	}

}
