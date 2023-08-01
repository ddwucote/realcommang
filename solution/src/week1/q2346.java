package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class q2346 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Deque<int[]> que = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("1 ");
		int in = arr[0];
		
		for(int i=1; i<n; i++){
			que.add(new int[] {(i+1), arr[i]});
		}
		
		while(!que.isEmpty()) {
			if(in >0) {
				for(int i=1; i<in; i++) {
					que.add(que.poll());
				}
				
				int[] nxt = que.poll();
				in = nxt[1];
				sb.append(nxt[0]+" ");
			}
			else {
				for(int i=1; i<-in; i++	) {
					que.addFirst(que.pollLast());
				}
				
				int[] nxt = que.pollLast();
				in = nxt[1];
				sb.append(nxt[0]+" ");
			}
		}
				
		System.out.println(sb.toString());
		
	}
}