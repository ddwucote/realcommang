package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class q2164 {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int[] que = new int[2 * N];	  
		for(int i = 1; i <= N; i++) {
			que[i] = i;
		}
		int pre = 1;
		int last = N;
		
		while(N-- > 1) {
			pre++;
			que[last + 1] = que[pre];
			last++;
			pre++;
		}
 
		System.out.println(que[pre]);
	}
 
}
