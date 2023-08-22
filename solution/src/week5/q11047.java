package week5;
import java.util.Scanner;

public class q11047 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int K = in.nextInt();
		
		int[] coins = new int[N];
		
		for(int i = 0; i < N; i++) {
			coins[i] = in.nextInt();
		}
		
		int count = 0;
 
		for(int i = N - 1; i >= 0; i--) {
 
			if(coins[i] <= K) {
				count += (K / coins[i]);
				K = K % coins[i];
			}
		}
		System.out.println(count);
	}

}
