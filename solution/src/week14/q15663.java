package week14;

import java.util.*;
import java.io.*;

public class q15663 {
	
	static int N, M;
	static int [] array;
	static int [] NS; 
	static boolean [] visited;
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		NS = new int[N];
		
		array = new int [M];
		visited = new boolean [N];
		
		for (int i = 0; i < N; i++) {
			NS[i] = sc.nextInt();
		}
		
		ArrayList<Integer> ar = new ArrayList<Integer>();
		
		for (int i = 0; i < M; i++) {
			ar.add(0);
		}
		
		arr.add(ar);
		
		Arrays.sort(NS);
		
		dfs(0, 0);
		
		bw.flush();
		bw.close();
	}

	static void dfs(int start, int index) throws IOException{
		
		if(index == M) {
			
			ArrayList<Integer> ar = new ArrayList<>();
			
			for (int i = 0; i < M; i++) {
				ar.add(array[i]);
			}
			
			if(!arr.contains(ar)) {
				for (int i = 0; i < M; i++) {
					bw.write(array[i] + " ");
				}
				arr.add(ar);
				bw.newLine();
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				array[index] = NS[i];
				visited[i] = true;
				dfs(i + 1, index + 1);
				visited[i] = false;
			}
		}		
	}
}
