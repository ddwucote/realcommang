package week11;

import java.util.*;
import java.io.*;

public class q16953 {

	static int A, B;
	static int result = -1;
	
	public static class Node {		
		long start;
		int count;
		
		public Node(long start, int count) {
			this.start = start;
			this.count = count;
		}
	}		
			
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		result = getMin(A);		
		System.out.println(result);
	}

	static int getMin(int start) {
		
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(start, 0));
		
		while(!que.isEmpty()) {
			
			Node now = que.poll();
			
			if(now.start == B) {
				return now.count+1;
			}
			
			long num1 = (now.start)*2;
			long num2 = (now.start)*10+1;
			
			if(num1 <= B)
				que.offer(new Node(num1, now.count+1));
			if(num2 <= B)
				que.offer(new Node(num2, now.count+1));
		}
		
		return -1;
	}
}
