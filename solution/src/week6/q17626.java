package week6;

import java.util.*;

public class q17626 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [] sol = new int[n+1];
		int min = 0;
		
		
		sol[0] = 0; sol[1] = 1;
		
		for(int i = 2; i<=n; i++) {
			
			min = Integer.MAX_VALUE;
			
			for(int j = 1; j*j<=i; j++) {
				
				int num = i - (j*j);
				min = Math.min(min, sol[num]);
								
			}
			sol[i] = min + 1;
		}
		
		System.out.println(sol[n]);
	}
}
