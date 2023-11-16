package week16;

import java.util.*;
import java.io.*;

public class q14888 {

	static int N;
	static int [] nums; //수
	static int [] calc = new int [4]; //연산자 개수
	
	static String [] calculators; //연산자 수열
	static String [] calculator = {"+", "-", "*", "/"};
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		nums = new int [N];
		calculators = new String [N-1];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken()); //수
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < 4; i++) {
			calc[i] = Integer.parseInt(st.nextToken()); //연산자 개수
		}		
		
		for(int i = 0; i < N-1; i++) {
			dfs(0, 0);
		}
		
		System.out.println(max);
		System.out.println(min);
		
	}
	
	static void dfs (int index, int start) {
		
		if(index == N-1) {
			
			int sum = nums[0];
			
			for (int i = 0; i < N-1; i++) {
				if(calculators[i] == "+") {
					sum += nums[i+1];
				}
				else if(calculators[i] == "-") {
					sum -= nums[i+1];
				}
				else if(calculators[i] == "*") {
					sum *= nums[i+1];
				}
				else {
					sum /= nums[i+1];
				}
			}
			
			if(sum < min)
				min = sum;
			
			if(sum > max)
				max = sum;
			
			return;
		}
		
		for(int j=0; j < N; j++) {
			
			for(int i = 0; i < 4; i++) {
				
				if(calc[i] > 0) {
					
					calc[i] -= 1;
					
					if(calculator[i] == "+") {
						calculators[index] = "+";
					}
					else if(calculator[i] == "-") {
						calculators[index] = "-";
					}
					else if(calculator[i] == "*") {
						calculators[index] = "*";
					}
					else {
						calculators[index] = "/";
					}
					dfs(index+1, start+1);
				}				
			}	
		}
	}

}
