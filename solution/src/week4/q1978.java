package week4;
import java.util.Scanner;

public class q1978 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			 
			boolean Prime = true;
			
			int num = in.nextInt();
			
			if(num == 1) {	
				continue;
			}
			for(int j = 2; j <= Math.sqrt(num); j++) {
				
				if(num % j == 0) {
					Prime = false;	
					break;
				}
				
			}
			if(Prime) {	
				sum++;
			}
		}
		System.out.println(sum);
	}

}
