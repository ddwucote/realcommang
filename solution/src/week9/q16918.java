package week9;
import java.io.*;
import java.util.*;
public class q16918 {

	static char [][] rec; //격자판
	static Queue<int[]> que = new LinkedList<>();
	static int plus1[] = {0,0,1,-1};
	static int plus2[] = {1,-1,0,0};
	static int R,C,N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); //초
		
		rec = new char [R][C];
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				rec[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 2; i <= N; i++) {
			if(i % 2 == 1) {
				for (int k = 0; k < R; k++) {
					for (int j = 0; j < C; j++) {
						if(rec[k][j] == 'O') {
							que.add(new int[] {k, j});
						}
					}
				}
				for (char[] re : rec) {
					Arrays.fill(re, 'O');
				}
				bfs();
			}
			
		}
		
		if( N % 2 == 0) {
			for (char[] re : rec) {
				Arrays.fill(re, 'O');
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(rec[i][j]);
			}
			System.out.println();
		}
	}

	static void bfs() {
		
		while (!que.isEmpty()) {
			int [] t = que.poll();
			int indexX = t[0];
			int indexY = t[1];
			rec[indexX][indexY] = '.';
			for(int i = 0; i < 4; i++) {
				int nx = indexX + plus1[i];
				int ny = indexY + plus2[i];
				if(nx >= 0 && nx < R && ny >=0 && ny < C) {
					if(rec[nx][ny] == 'O') {
						rec[nx][ny] = '.';
					}
				}
			}
		}
		
	}
}
