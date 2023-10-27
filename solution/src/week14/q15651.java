package week14;

import java.util.*;

public class q15651 {
	
	static int N, M;
	static int [] array;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		array = new int [M];
		
		dfs(0);
	}

	static void dfs(int index) {
		
		if(index == M) {
			for (int arr : array) {
				System.out.print(arr + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
				array[index] = i;
				dfs(index+1);
		}
	}
}
