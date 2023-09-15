package week9;

import java.util.*;
import java.io.*;

public class q20053 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num > max)
					max = num;
				if(num < min)
					min = num;
			}
			System.out.println(min + " " + max);
		}
	}

}
