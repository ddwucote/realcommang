package week10;

import java.util.*;
import java.io.*;

public class q16956 {

	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static char [][] farm = new char [501][501]; //목장상태
	static int R, C;
	static boolean result = true;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		farm = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				farm[i][j] = str.charAt(j);
			}
		}
		
		//늑대 인접한 칸 자유롭게 이동
		//양 가만히
		//늑대는 울타리 있는 칸으로 이동 불가
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(farm[i][j] == 'W') 
					fence(i, j);
			}
		}
		
		if(result) {
			System.out.println(1);
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					System.out.print(farm[i][j]);
				}
				System.out.println();
			}
		}
	}

	static void fence(int i, int j) { 
		//늑대 좌우양옆 무조건 울타리 설치
		//늑대 바로 옆에 양이면 무조건 불가능
		for(int k = 0; k < 4; k++) {
			int x = dx[k] + i;
			int y = dy[k] + j;
			if(x >= 0 && x < R && y >= 0 && y < C) {
				if(farm[x][y] == 'S')
				{
					System.out.println(0);
					result = false;
					return;
				}
				else if(farm[x][y] == '.')
				{
					farm[x][y] = 'D';
				}
			}
		}
	}
}
