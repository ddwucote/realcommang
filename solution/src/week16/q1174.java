package week16;

import java.util.*;
import java.io.*;

public class q1174 {

	static long N;
	static long start = 0;
	static String s;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextLong();
	
		while(N > 0) {
			
			int i = 0, j = 0;
			s = Long.toString(start);
			char max = s.charAt(0);
			
			while(i < s.length()-1) {
				
				//System.out.println("prev : " + s.charAt(i) + " next : " + s.charAt(i+1));
				
				if((s.charAt(i) - '0') <= (s.charAt(i+1) - '0'))
					j++;
				
				if(i >= 1 && ((s.charAt(i) - '0') == (max - '0') || (s.charAt(i) - '0') > (max - '0'))) {
					j++;
					max = s.charAt(i);
				}
				
				i++;				
			}
			
			if(j == 0) {
				//System.out.println(start);
				N -= 1;
			}
			
			if(N <= 0)
				break;
			
			start++;
			
			if(start > 1000000) {
				start = -1;
				break;
			}			
		}
		
		System.out.println(start);
	}
}
