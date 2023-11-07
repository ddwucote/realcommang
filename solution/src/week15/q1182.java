package week15;

import java.util.*;
import java.io.*;

public class q1182 {

	static int N, S;
	static ArrayList<Integer> array = new ArrayList<Integer>();
	static int sum = 0;
	static boolean [] visited;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			array.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < N; i++) {
			dfs(0,i, 0);
		}
		
		System.out.println(sum);
	}

	//start : 시작, index : 부분 수열 크기, count : 지금까지 합 
	static void dfs(int start, int index, int count) {
		
		if(index == start) {
			count = 0;
			if(count == 0) {
				sum++;
			}			
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(start, index+1, count+array.get(i));
				
			}
		}
		
	}
}
