package week14;

import java.util.*;

public class q15649 {
	
	static int[] array;
	static boolean[] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		array = new int[M];
		visited = new boolean[N+1];
		dfs(N, M, 0);				
	}

	public static void dfs(int N, int M, int index) {
		if(index == M) {
			for (int val : array) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i=1; i<=N; i++) {
			if(!visited[i]) {
				
				visited[i] = true;
				array[index] = i;
				
				dfs(N, M, index + 1);
				
				visited[i] = false;
			}
		}
	}
}
