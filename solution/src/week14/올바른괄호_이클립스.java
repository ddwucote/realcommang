package week14;

import java.util.*;
import java.io.*;

public class 올바른괄호_이클립스 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int num = 0;
		
		for(int i = 0; i < s.length(); i++) {
			
			if(num < 0) break;
			
			if(s.charAt(i) == '(') {
				num++;
			}
			else if (s.charAt(i) == ')') {
				num--;
			}
		}
		
		if(num == 0)
			System.out.println("true");
		else
			System.out.println("false");
		
		
	}

}
