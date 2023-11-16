package week16;

import java.util.*;
import java.io.*;

public class q16987 {

	static int N;
	static ArrayList<List> eggs = new ArrayList<>();
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			List<Integer> egg = new ArrayList<>();
			egg.add(Integer.parseInt(st.nextToken()));
			egg.add(Integer.parseInt(st.nextToken()));
			eggs.add(egg);
		}
		
		dfs(0, 0, 0);
		
		System.out.println(max);
	}
	
	static void dfs(int index, int start, int sum) {
		
		if(index == N) {	
			max = Math.max(sum, max);		
			return;
		}
		
		for(int i = start+1; i < N; i++) {
			
			if(Integer.parseInt(eggs.get(i).get(0).toString()) > 0) { 
				
				if(Integer.parseInt(eggs.get(start).get(0).toString()) > 0) {
					
					int left = Integer.parseInt(eggs.get(start).get(0).toString()) - 
							Integer.parseInt(eggs.get(i).get(1).toString());
					int right = Integer.parseInt(eggs.get(i).get(0).toString()) - 
							Integer.parseInt(eggs.get(start).get(1).toString());
					
					System.out.println("left: " + left + " right: " + right);
					
					List<Integer> eggL = new ArrayList<>();
					eggL.add(left); eggL.add(Integer.parseInt(eggs.get(start).get(1).toString()));
					eggs.set(start, eggL);
					
					
					List<Integer> eggR = new ArrayList<>();
					eggR.add(right); eggR.add(Integer.parseInt(eggs.get(i).get(1).toString()));
					eggs.set(i, eggR);
					
					if(left < 0 && right < 0)
						dfs(index+2, start+1, sum+2);
					else if (left > 0 && right < 0)
						dfs(index+1, start+1, sum+1);
					else if (left < 0 && right > 0)
						dfs(index+1, start+1, sum+1);
				}
				
				dfs(index+1, i, sum);
			}
		}
	}

}
