package week12;

import java.io.*;
import java.util.*;

public class q13549 {

	static int N, K;
	static int time;
	static boolean [] visit;
	
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
		
		bfs(N, K);
		
	}

	public static void bfs(int start, int end) {
		
		Queue<Node> que = new LinkedList<>();
		
		que.offer(new Node(start, 0));
		
		while(!que.isEmpty()) {
			
			Node node = que.poll();
			
			if(node.start == end) {
				System.out.println(node.count);
				return;
			}
						
			que.add(new Node(node.start * 2, node.count));
			que.add(new Node(node.start + 1, node.count + 1));
			que.add(new Node(node.start - 1, node.count + 1));
			
		}	
	}
}

