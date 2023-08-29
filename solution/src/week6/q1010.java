package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.math.*;

public class q1010 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			solution(N, M);
		}
	}

	public static void solution(int N, int M) {
		
		long result = 1;
		int j = 1;
		
		for(int i = M-N+1; i <= M; i++) { //m! / (m-n)!
			result *= i;
			if(j <= N) { //n!구하고 나누기
				//System.out.print(result);
				result /= j;	
				j++;
			}
			//System.out.println(" " + result);
		}
		
		System.out.println(result);
	}
}
