package week5;
import java.util.Scanner;

public class q13305 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		long[] d = new long[N - 1];	
		long[] cost = new long[N];	
		
		for(int i = 0; i < N - 1; i++) {
			d[i] = in.nextLong();
		}
		
		for(int i = 0; i < N; i++) {
			cost[i] = in.nextLong();
		}
		
		long sum = 0;
		long min = cost[0];	
 
		for(int i = 0; i < N - 1; i++) {
			
			if(cost[i] < min) {
				min = cost[i];
			}
			
			sum += (min * d[i]);	
		}
		
		System.out.println(sum);
	}

}
