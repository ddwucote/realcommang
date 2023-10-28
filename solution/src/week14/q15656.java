package week14;

import java.util.*;
import java.io.*;

public class q15656 {
	
	static int N, M;
	static int [] array;
	static int [] NS; 
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		NS = new int[N];
		
		array = new int [M];
		
		for (int i = 0; i < N; i++) {
			NS[i] = sc.nextInt();
		}
		
		Arrays.sort(NS);
		
		dfs(0, 0);
	}

	static void dfs(int start, int index) {
		
		if(index == M) {
			for (int arr : array) {
				System.out.print(arr + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			array[index] = NS[i];
			dfs(start + 1, index + 1);
		}		
	}
}
