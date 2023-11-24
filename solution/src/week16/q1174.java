package week16;

import java.util.*;
import java.io.*;

public class q1174 {

	static long N;
	static long start = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextLong();
		dfs(1);
		System.out.println(start);
	}

	static void dfs(long count) {
		
		if(start > 1000000) {
			start = -1;
			return;
		}
		
		if(count == N) {
			return;
		}
		
		long temp = start;
		long i = 0, j = 0;
		long prev;
		
		prev = temp / 10;
		
		while(temp >= 10) {
			
			if(prev > temp % 10)
				i++;			
			j++; 
			
			prev = temp % 10;
			temp = prev / 10;
		}
		
		start++;
		
		if(i == j) {			
			dfs(count+1);
		}
		else {
			dfs(count);
		}
	}
}
