package week6;
import java.util.*;

public class q1463 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		int dp[] = new int[X+1];
		dp[0] = 0; dp[1] = 0;
		
		for(int i = 2; i<=X; i++) {
			dp[i] = dp[i-1] + 1;
			if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
			if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
		}
		
		System.out.println(dp[X]);
	}
}
