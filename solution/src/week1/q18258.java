package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
 
public class q18258 {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		Deque<Integer> que = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer com;
		
		while(N-- > 0) {
			com = new StringTokenizer(br.readLine(), " ");	// 문자열 분리 
			
			switch(com.nextToken()) {	
			
			case "push":
				que.offer(Integer.parseInt(com.nextToken()));	
				break;
				
			case "pop" :
				Integer item = que.poll();	
				if(item == null) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(item).append('\n');
				}
				break;
				
			case "size":	
				sb.append(que.size()).append('\n');
				break;
				
			case "empty":
				if(que.isEmpty()) {
					sb.append(1).append('\n');
				}
				else {
					sb.append(0).append('\n');
				}
				break;
				
			case "front":
				Integer ite = que.peek();
				if(ite == null) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(ite).append('\n');
				}
				break;
				
			case "back":
				Integer it = que.peekLast();	 
				if(it == null) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(it).append('\n');
				}
				break;
			}
		}
		System.out.println(sb);
	}
}