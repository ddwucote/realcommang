package week10;

import java.util.*;
import java.io.*;

public class q1012 {

	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int M, N, K;
	static int [][] cabbage = new int [51][51]; //양배추 밭
	static boolean [][] visit = new boolean [51][51];
	static int bugs = 0; 
	 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		while( T-- > 0) {
			
			bugs = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			cabbage = new int [M][N];
			visit = new boolean [M][N];
			
			for(int i = 0; i < K; i++) {//양배추 위치
				StringTokenizer str = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(str.nextToken());
				int y = Integer.parseInt(str.nextToken());
				cabbage[x][y] = 1;
			}
			
			for(int i = 0; i < M; i++) { //초기화
				for(int j = 0; j < N; j++) {
					if(cabbage[i][j] == 1 && !visit[i][j]) {
						countBugs(i, j);
						bugs++;
					}
				}
			}
			
			//System.out.println(bugs);
			nums.add(bugs);
		}
		
		for(int i = 0; i < nums.size(); i++) {
			System.out.println(nums.get(i));
		}
	}

	static void countBugs(int i, int j) {	
		
		boolean result = true;
		visit[i][j] = true;
		
		for(int k = 0; k < 4; k++) {
			
			int x = dx[k] + i;
			int y = dy[k] + j;
			
			if(x >= 0 && y >= 0 && x < M && y < N) {
				if(cabbage[x][y] == 1 && !visit[x][y]) {
					countBugs(x,y);
				}
				
			}
		}			
	}
}
