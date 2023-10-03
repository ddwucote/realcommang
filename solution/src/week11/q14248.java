package week11;

import java.util.*;
import java.io.*;

public class q14248 {

	static int n, s;
	static boolean [] visit;
	static int [] A;
	static int count = 1;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n];
		A = new int[n];
		
		st = new StringTokenizer(br.readLine());		
		for(int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			visit[i] = false;
		}
		
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken()) - 1;
		
		stones(s);
		
		System.out.println(count);
	}

	static void stones(int i) {
		
		Queue<Integer> que = new LinkedList<>();
		que.offer(i);
		visit[i] = true;
		
		while(!que.isEmpty()) {
			
			int distance = que.poll();
			
			if(distance - A[distance] >= 0)
				if(!visit[(distance - A[distance])]) {
					count++;
					visit[(distance - A[distance])] = true;
					que.offer(distance - A[distance]);
				}
			
			if(distance + A[distance] < n) 
				if(!visit[(distance + A[distance])]) {
					count++;
					visit[(distance + A[distance])] = true;
					que.offer(distance + A[distance]);
				}
			
		}	
		
	}
}
