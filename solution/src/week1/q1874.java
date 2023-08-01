package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class q1874 {

	static int T;
	static StringBuilder sb = new StringBuilder();
	static int tmp = 1;
	static boolean error = false;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		T = Integer.parseInt(br.readLine());		
		Stack<Integer> st = new Stack<>();

		for(int i = 0 ; i < T ; i++) {
			int N = Integer.parseInt(br.readLine());
			
			for( ; tmp <= N ; tmp++) {
				st.push(tmp);
				sb.append("+").append("\n");
			}
			
			if(st.peek()==N) {
				st.pop();
				sb.append("-").append("\n");
			}else {
				error = true;
			}
		}
		
		if(error)
			System.out.println("NO");
		else
			System.out.println(sb);
		}
}