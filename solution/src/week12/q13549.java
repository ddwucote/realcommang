package week12;

import java.io.*;
import java.util.*;

public class q13549 {

	static int N, K;
	static int time;
	static boolean [] visit;
	
	static int max = 100000;
	static int min = Integer.MAX_VALUE;
	
	public static class Node {
		
		int start;
		int count;
		
		public Node(int start, int count) {
			this.start = start;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visit = new boolean[max+1];
		bfs(N, K);
		System.out.println(min);
		
	}

	public static void bfs(int start, int end) {
		
		Queue<Node> que = new LinkedList<>();
		
		que.offer(new Node(start, 0));
		
		while(!que.isEmpty()) {
			
			Node node = que.poll();
			visit[node.start] = true;
			
			if(node.start == K) min = Math.min(min, node.count);
			
			if(node.start * 2 <= max)
				if(!visit[node.start * 2])
					que.add(new Node(node.start * 2, node.count));
			
			if(node.start + 1 <= max)
				if(!visit[node.start + 1])
					que.add(new Node(node.start + 1, node.count + 1));
			
			if(node.start - 1 >= 0)
				if(!visit[node.start - 1])
					que.add(new Node(node.start - 1, node.count + 1));
			
		}	
	}
}

