package week14;

import java.util.*;
import java.io.*;

public class q15655 {
	
	static int N, M;
	static int [] array;
	static int [] NS; 
	static boolean [] visited;
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		NS = new int[N];
		visited = new boolean [N];
		
		array = new int [M];
		
		for (int i = 0; i < N; i++) {
			NS[i] = sc.nextInt();
		}
		
		Arrays.sort(NS);
		
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
		
		for(int i = start; i < N; i++) {
			array[index] = NS[i];					
			dfs(i + 1, index + 1);	
		}
	}
}
