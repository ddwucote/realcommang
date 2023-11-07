package week15;

import java.io.IOException;
import java.util.*;

public class q15665 {

	static ArrayList<Integer> array = new ArrayList<Integer>();
	static int N, M;
	static int [] result;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		result = new int[M];
		
		for(int i = 0; i < N; i++) {
			int k = sc.nextInt();	
			if(array.isEmpty())
				array.add(k);
			else
				if(!array.contains(k))
					array.add(k);
		}
		
		Collections.sort(array);
		
		dfs(0);
		
		System.out.println(sb);
	}
	
	static void dfs(int index){
		
		if(index == M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int prev = -1;
		for(int i = 0; i < array.size(); i++) {
			if(prev != array.get(i)) {
				prev = array.get(i);
				result[index] = prev;
				dfs(index+1);
			}
		}
		
	}

}
