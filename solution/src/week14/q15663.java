package week14;

import java.util.*;
import java.io.*;

public class q15663 {
	
	static int N, M;
	static int N1;
	static int [] array;
	static int [] NUMS; 
	static boolean [] visited;
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		int [] NS = new int[N];
		
		array = new int [M];
		visited = new boolean [N];
		
		for (int i = 0; i < N; i++) {
			NS[i] = sc.nextInt();
		}
		
		int count; int sum = 0;
		for (int i = 0; i < N; i++) {
			count = 0;
			for (int j = i; j < N; j++) {
				if(NS[i] == NS[j]) {
					count++;
				}
			}
			if(count >= 2) {
				NS[i] = 10001;
				sum++;
			}
		}
		
		NUMS = new int[N - sum];
		
		int index = 0;
		for(int i = 0; i < N; i++) {
			if(NS[i] != 10001) {
				NUMS[index] = NS[i];
				index++;
			}				
		}
		
		N1 = N-sum;
		Arrays.sort(NUMS);
		
		dfs(0, 0);
		
		bw.flush();
		bw.close();
	}

	static void dfs(int start, int index) throws IOException{
		
		if(index == M) {
			for (int i = 0; i < M; i++) {
				bw.write(array[i] + " ");
			}
			bw.newLine();
			return;
		}
		
		for(int i = 0; i < N1; i++) {
			if(!visited[i]) {
				array[index] = NUMS[i];
				visited[i] = true;
				dfs(start + 1, index + 1);
				visited[i] = false;
			}
		}		
	}
}
