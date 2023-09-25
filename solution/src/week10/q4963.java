package week10;

import java.util.*;
import java.io.*;

public class q4963 {

	static int w, h;
	static int count=0;
	
	static boolean [][] visit; //방문여부
	static int [][] rec; //정사각형
	
	static int dx[] = {0, 0, -1 ,1, -1, 1, -1, 1};
	static int dy[] = {-1, 1, 0, 0, 1, 1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0)
				break;
			
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
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
		
	}
	
	public static void Island(int i, int j) {
		
		visit[i][j] = true;
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {i, j});
		
		while( !que.isEmpty() ) {
			int[] pos = que.poll();
			
			for(int k = 0; k < 8; k++) {
				
				int nx = dx[k] + pos[0];
				int ny = dy[k] + pos[1];
				
				if(nx >= 0 && ny >= 0 && nx < h && ny < w) {
					if(!visit[nx][ny] && rec[nx][ny] == 1) {
						visit[nx][ny] = true;
						que.offer(new int[] {nx, ny});
					}
				}
			}
		}
	}

}
