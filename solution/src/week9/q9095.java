package week9;
import java.util.*;

public class q9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			int n = sc.nextInt();
			System.out.println(num(n));
		}			
	}

	public static int num(int n) {
		
		int dp[] = new int[11];
		dp[0] = 0; dp[1] = 1; dp[2] = 2; dp[3] = 4;
		
		for(int i=4; i<=n; i++) {
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		}
		
		return dp[n];
	}
}
