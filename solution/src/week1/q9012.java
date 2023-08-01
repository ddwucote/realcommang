package week1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
 
public class q9012 {
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int T = Integer.parseInt(br.readLine());
 
		while (T-- > 0) {
			sb.append(solve(br.readLine())).append('\n');
		}
		System.out.println(sb);
 
	}
 
	public static String solve(String s) {
 
		int sum = 0;
 
		for (char c : s.toCharArray()) {
 
			if (c == '(') {
				sum++;
			}
			else if (sum == 0) {
				return "NO";
			}
			else {
				sum--;
			}
		}
 
		if (sum == 0) {
			return "YES";
		} 
		else {
			return "NO";
		}
	}
}