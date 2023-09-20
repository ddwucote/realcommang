package week9;

import java.util.*;
import java.io.*;

public class q2667 { //ArrayList사용해서 구현
	
	private static int plus1[] = {0,0,1,-1};
	private static int plus2[] = {1,-1,0,0};
	private static int[] aparts = new int[25*25];
	private static int N;
	private static int sum = 0; //아파트 단지 번호의 수
	private static boolean[][] visited = new boolean[25][25];
	private static int[][] map = new int[25][25];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        
        //System.out.println(N);
        
        //사각형 입력
        for(int i = 0; i < N; i++) {
        	String st = sc.next();
        	for(int j = 0; j < N; j++) {
        		map[i][j] = st.charAt(j)-'0';
        	}
        }
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		if(map[i][j] == 1 && !visited[i][j]) {
        			sum++;
        			bfs(i,j);
        		}
        	}
        }
        
        Arrays.sort(aparts);
        System.out.println(sum); //총 단지수
        
        for(int i = 0; i< aparts.length; i++) {
        	if(aparts[i] == 0) {}
        	else {
        		System.out.println(aparts[i]); //아파트 수
        	}
        }
	}
	
	private static void bfs(int x, int y) {
		
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x,y});
		visited[x][y] = true;
		aparts[sum]++;
		
		while(!que.isEmpty()) {
			
			int num1 = que.peek()[0];
			int num2 = que.peek()[1];
			que.poll(); //삭제, 없으면 null 반환
			
			for(int i = 0; i < 4; i++) {
				int nx = num1 + plus1[i];
				int ny = num2 + plus2[i];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if(map[nx][ny] == 1 && !visited[nx][ny]) {
						que.add(new int[] {nx, ny});
						visited[nx][ny] = true;
						aparts[sum]++;
					}
				}
			}
		}
		
	}

}
