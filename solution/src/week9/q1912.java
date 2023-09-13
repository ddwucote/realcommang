package week9;
import java.util.*;

public class q1912 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] nums = new int[N];
		int[] dp = new int[N];
		
		for(int i = 0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		
		dp[0] = nums[0];
		int max = nums[0];
		
		for(int i=1; i<N; i++) {
			dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}

}
