package week12;

import java.io.*;
import java.util.*;

public class q16234 {

	static int N, L, R;
	static int [][] country;
	static boolean [][] visit;
	static int day = 0;
	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	public static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken()); //L이상
		R = Integer.parseInt(st.nextToken()); //R이하
		
		country = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int people = Integer.parseInt(st.nextToken());
				country[i][j] = people;
			}
		}
		
		while(calculate()) {
			
			init();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visit[i][j]) {
						line(i, j);
					}
				}
			}
			
			day++;
		}
		
		System.out.println(day);
		
	}
	
	public static void init() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				visit[i][j] = false;
			}
		}
	}
	
	public static boolean calculate() {
		
		int count = 0; 
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < 4; k++) {
					
					int x = dx[k] + i;
					int y = dy[k] + j;
					
					if(x >= 0 && y >= 0 && x < N && y < N) {
						if(Math.abs(country[i][j] - country[x][y]) >= L &&
								Math.abs(country[i][j] - country[x][y]) <= R) {
							count++;
						}
					}
				}	
			}
		}
		
		if(count == 0) 
			return false;
		else 
			return true;
	}

	public static void line (int start, int end) {
		
		Queue<Node> que = new LinkedList<>();
		ArrayList<Node> arr = new ArrayList<>();
		
		que.add(new Node(start, end));
		arr.add(new Node(start, end));
		visit[start][end] = true;
		
		while(!que.isEmpty()) {
			
			Node node = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int x = dx[i] + node.x;
				int y = dy[i] + node.y;
				
				if(x >= 0 && y >= 0 && x < N && y < N && !visit[x][y]) {
					if(Math.abs(country[node.x][node.y] - country[x][y]) >= L && 
							Math.abs(country[node.x][node.y] - country[x][y]) <= R) {
						que.add(new Node(x, y));
						arr.add(new Node(x, y));
						visit[x][y] = true;
					}
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i < arr.size(); i++) {
			Node node = arr.get(i);
			count += country[node.x][node.y];
		}
		
		for(int i = 0; i < arr.size(); i++) {
			Node node = arr.get(i);
			country[node.x][node.y] = count / arr.size();
		}
		
		arr.clear();
	}
}
