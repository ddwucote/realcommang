package week14;

import java.util.*;
import java.io.*;

public class q15664 {
	
	static int N, M;
	static int [] array;
	static int [] NS; 
	static boolean [] visited;
	static HashSet<ArrayList<Integer>> arr = new HashSet<>();	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out), 65536);
	
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
		
		Arrays.sort(NS);
		
		dfs(0, 0);
		
		bw.flush();
		bw.close();
	}

	static void dfs(int start, int index) throws IOException{
		
		if(index == M) {			
			ArrayList<Integer> ar = new ArrayList<>();
			ArrayList<Integer> ar1 = new ArrayList<>();
			
			for (int i = 0; i < M; i++) {
				ar.add(array[i]);
				ar1.add(array[M-i-1]);
			}
			
			if(!arr.contains(ar) && !arr.contains(ar1)) {
				for (int i = 0; i < M; i++) {
					bw.write(array[i] + " ");
				}
				arr.add(ar);
				bw.newLine();
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(!visited[i]) {
				array[index] = NS[i];
				visited[i] = true;
				dfs(start + 1, index + 1);
				visited[i] = false;
			}
		}		
	}
}
