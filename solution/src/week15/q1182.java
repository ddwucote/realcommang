package week15;

import java.util.*;
import java.io.*;

public class q1182 {

	static int N, S;
	static ArrayList<Integer> array = new ArrayList<Integer>();
	static int sum = 0;
	static boolean [] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			array.add(Integer.parseInt(st.nextToken()));
		}
		
		dfs(0,0);
		
		if(S == 0) 
			System.out.println(sum-1);
		else
			System.out.println(sum);
	}

	static void dfs(int index, int count) {		
		
		if(index == N) {			
			if(count == S) sum++;
			return;
		}
		dfs(index+1, count + array.get(index));
		dfs(index+1, count);
		
	}
}
