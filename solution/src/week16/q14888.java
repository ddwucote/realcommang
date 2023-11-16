package week16;

import java.util.*;
import java.io.*;

public class q14888 {

	static int N;
	static int [] nums; //수
	static int [] calc = new int [4]; //연산자 개수
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		nums = new int [N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken()); //수
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < 4; i++) {
			calc[i] = Integer.parseInt(st.nextToken()); //연산자 개수
		}		
		
		dfs(nums[0], 1);
		
		System.out.println(max);
		System.out.println(min);
		
	}
	
	static void dfs (int sum, int index) {
		
		if(index == N) {
			
			max = Math.max(sum, max);
			min = Math.min(sum, min);
			
			return;
		}
			
		for(int i = 0; i < 4; i++) {
			
			if(calc[i] > 0) {
				
				calc[i]--;
				
				int next = nums[index];
				
				if(i==0) {
					dfs(sum+next, index+1);
				}
				else if(i==1) {
					dfs(sum-next, index+1);
				}
				else if(i==2) {
					dfs(sum*next, index+1);
				}
				else if(i==3){
					dfs(sum/next, index+1);
				}
				
				calc[i]++;
			}				
		}	
		
	}

}
