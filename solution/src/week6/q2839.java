package week6;
import java.util.*;

public class q2839 {

	static int min = -1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		
		int result = 0;
		
		if(N%5 == 0) { //5로 나눠떨어지는 경우
			min = N/5;
		}
		else { 			
			result = sugar(N, N/3);
			
			if(min <= result) {
				min = result;
			}
		}
		
		System.out.println(min);
	}

	public static int sugar(int N, int max) {
		
		int result = 5000;
		int j = 0;
		
		for(int i = max; i >= 0; i--) {
			for(j = 0; j <= N/5; j++)
			if((i*3 + j*5) == N) {
				if(result >= (i+j)) {
					result = (i+j);
				}
			}				
		}
		
		if (result == 5000) 
			result = -2;
		
		return result;
	}
}
