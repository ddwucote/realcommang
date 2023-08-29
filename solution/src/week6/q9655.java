package week6;

import java.util.*;

public class q9655 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int three = N/3; //3개 횟수
		int one = N%3; //1개 횟수
		
		if((three + one) % 2 == 0)
			System.out.println("CY");
		else
			System.out.println("SK");
	}

}
