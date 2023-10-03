package week11;

import java.util.*;
import java.io.*;

public class q14496 {

	static int a, b;
	static int N, M;
	
	static int result = -1;	
	static ArrayList<ArrayList<Integer>> characters;
	static boolean [] visit;
	
	public static class Node {
		int x;
		int cost;
		
		public Node(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N+1];
		characters = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			characters.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			characters.get(x).add(y);
			characters.get(y).add(x);
		}
		
		bfs();
		System.out.println(result);
	}
	
	public static void bfs() {
		
		int count = 0;
		
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(a, 0));
		visit[a] = true;
		
		while(!que.isEmpty()) {
			
			Node now = que.poll();
			visit[now.x] = true;
			count = now.cost;
			
			if(now.x == b) {
				result = now.cost;
				break;
			}
			
			for(int next : characters.get(now.x)) {
				if(!visit[next]) {
					visit[next] = true;
					que.add(new Node(next, count+1));
				}
			}
			
		}
	}
}

