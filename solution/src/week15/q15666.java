package week15;

import java.io.IOException;
import java.util.*;

public class q15666 {

	static ArrayList<Integer> array = new ArrayList<Integer>();
	static int N, M;
	static int [] result;
	private static StringBuilder sb = new StringBuilder();
	static boolean [] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		result = new int[M];
		visited = new boolean[N];
		
		int j = 0;
		for(int i = 0; i < N; i++) {
			int k = sc.nextInt();	
			if(array.isEmpty()) {
				array.add(k);
				visited[j] = false;
				j++;
			}
			else
				if(!array.contains(k)) {
					array.add(k);
					visited[j] = false;
					j++;
				}
		}
		
		Collections.sort(array);
		
		dfs(0, 0);
		
		System.out.println(sb);
	}
	
	static void dfs(int start, int index){
		
		if(index == M) {
			int sum = 0;
			for(int i = 0; i < M-1; i++) {
				if(result[i] <= result[i+1])
					sum++;
			}
			
			if(sum == M-1) {
				for(int i = 0; i < M; i++) {
					sb.append(result[i]).append(" ");
				}
				sb.append("\n");
			}
			
			return;
		}
		
		int prev = -1;
		for(int i = start; i < array.size(); i++) {
			if(prev != array.get(i) && !visited[i]) {
				prev = array.get(i);
				result[index] = prev;		
				dfs(start, index+1);
			}
			visited[start] = true;
		}						
	}

}
