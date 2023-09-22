package week10;

import java.util.*;
import java.io.*;

public class q4963 {

	static int w=1;
	static int h=1;
	static int count=0;
	
	static boolean [][] visit = new boolean [51][51]; //방문여부
	static int [][] rec = new int [51][51]; //정사각형
	
	static int dx[] = {0,0,1,-1,1,1,-1,-1};
	static int dy[] = {1,-1,0,0,1,-1,1,-1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		while(w != 0 && h != 0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			//System.out.println(w + " " + h);
			rec = new int [h][w];
			visit = new boolean [h][w]; 
			count = 0;
			
			//사각형 채우기
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine()); //사각형의 한 변 받음
				for(int j = 0; j < w; j++) {
					rec[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(rec[i][j] == 1 && !visit[i][j]) {
						Island(i, j);
					}
				}
			}
			
			System.out.println(count);	
			//System.out.println();
		}
		
	}
	
	public static void Island(int i, int j) {
		
		boolean result = true;
		visit[i][j] = true;
		
		for(int k = 0; k < 8; k++) {
			int x = dx[k] + i;
			int y = dy[k] + j;
			
			if(x >= 0 && x < h && y < w && y >= 0) {
				if(rec[x][y] == 1 && !visit[x][y]) {
					visit[x][y] = true;
				}
				else if(rec[x][y] == 1 && visit[x][y]){
					result = false;
				}
			}
		}
		
		if(result)
			count++;
	}

}
