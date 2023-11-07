package week15;

import java.util.*;
import java.io.*;

public class q1182 {

	static int N, S;
	static ArrayList<Integer> array = new ArrayList<Integer>();
	static int sum = 0;
	static int temp = 0;
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
		
		for(int i = 1; i < N; i++) {
			
			System.out.println("--------------------");
			dfs(0, i, 0);
			
		}
		
		System.out.println(sum);
	}

	//index : 부분 수열 크기, count : 지금까지 반복한 횟수 
	static void dfs(int start, int index, int count) {		
		if(index == count) {
			
			for(int i = start; i < N; i++) {
				visited[i] = false;		
			}
			
			if(temp == 0) 
				sum++;
			
			System.out.print(temp);
			System.out.println();
			
			
			count = 0; temp = 0;
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(!visited[i]) {
				System.out.print(array.get(i) + " ");
				temp += array.get(i);
				visited[i] = true;
				dfs(start, index, count+1);						
			}			
		}
	}
}
