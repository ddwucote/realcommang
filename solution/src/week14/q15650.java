package week14;

import java.util.*;

public class q15650 {

	static boolean [] visited;
	static int [] array;
	
	static int N, M;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		array = new int [M];
		visited = new boolean [N+1];
		

		dfs(1, 0);
		visited[1] = true;

	}

	static void dfs(int s, int index) {
		
		if(index == M) {
			for (int arr : array) {
				System.out.print(arr + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = s; i <= N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				array[index] = i;
				dfs(i, index+1);
				visited[i] = false;
			}
		}
	}
}
