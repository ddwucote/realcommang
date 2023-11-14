package week16;

import java.util.*;
import java.io.*;

public class q14888 {

	static int N;
	static int [] nums;
	static int [] calc = new int [4];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		nums = new int [N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < 4; i++) {
			calc[i] = Integer.parseInt(st.nextToken());
		}
		
	}

}
