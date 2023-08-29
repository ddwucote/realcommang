package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class q2748 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[] fibo = new long[91]; //피보나치 값 저장
		
		fibo[0] = 0; fibo[1] = 1;
		
		if(n >= 2) {
			for(int i=2; i<=n; i++) {
				fibo[i] = fibo[i-1] + fibo[i-2];
			}
		}
		
		System.out.println(fibo[n]);
	}

}
