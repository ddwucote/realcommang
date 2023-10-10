package week12;

import java.io.*;
import java.util.*;

public class q17836 {

	static int N, M, T;
	static int [][] castle;
	static boolean [][] visit;
	static int min = Integer.MAX_VALUE;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	public static class Node {
		int x;
		int y;
		int time;
		
		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		castle = new int [N+1][M+1];
		visit = new boolean [N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				castle[i][j] = Integer.parseInt(st.nextToken());
			}
		}	
		
		Princess(1, 1);
		
		if(min <= T)
			System.out.println(min);
		else
			System.out.println("Fail");
		
	}

	public static void Princess(int x, int y) {
		
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(x, y, 0));
		
		while(!que.isEmpty()) {
			
			Node node = que.poll();
			
			for(int i = 0; i < 4; i++) {
				
				int a = node.x + dx[i];
				int b = node.y + dy[i];
				
				if(a == N && b == M) {
					min = Math.min(min, node.time);
				}
				
				if(a >= 1 && b >= 1 && a <= N && b <= M) {
					if(!visit[a][b] && castle[a][b] == 0) {		
						visit[a][b] = true;
						que.add(new Node(a, b, node.time + 1));						
					}
					
					if(!visit[a][b] && castle[a][b] == 2) {		
						visit[a][b] = true;
						int k = N - a;
						int l = M - b;
						int sword = (int) Math.sqrt(k*k + l*l);
						que.add(new Node(N, M, sword + node.time));
					}
					
				}
				
			}
		}
		
	}
}
