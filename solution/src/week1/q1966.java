package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
import java.util.StringTokenizer;
import java.util.LinkedList;
 
public class q1966 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test = Integer.parseInt(br.readLine()); 
 
		while (test-- > 0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			LinkedList<int[]> q = new LinkedList<>();	
			st = new StringTokenizer(br.readLine());
 
			for (int i = 0; i < N; i++) {
				q.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
			}
 
			int sum = 0;	
			
			while (!q.isEmpty()) {	
				
				int[] front = q.poll();	
				boolean Max = true;	
				
				for(int i = 0; i < q.size(); i++) {
					
					if(front[1] < q.get(i)[1]) {
						
						q.offer(front);
						for(int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						
						Max = false;
						break;
					}
				}
				
				if(Max == false) {
					continue;
				}
				
				sum++;
				if(front[0] == M) {
					break;
				}
 
			}
 
			sb.append(sum).append('\n');
 
		}
		System.out.println(sb);
	}
 
}