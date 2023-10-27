package week14;

import java.util.*;
import java.io.*;

public class q15652 {
	
	static int N, M;
	static int [] array;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int [M];
		
		dfs(1, 0);
		
		bw.flush();
		bw.close();
	}

	static void dfs(int start, int index) throws IOException {
		
		if(index == M) {
			for (int i = 0; i < M; i++) {
				bw.write(array[i] + " ");
			}
			bw.newLine();
			return;
		}
		
		for(int i = start; i <= N; i++) {
			array[index] = i;
			dfs(i, index + 1);
		}		
	}
}
