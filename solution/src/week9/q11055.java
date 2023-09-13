package week9;
import java.util.*;
import java.math.*;

public class q11055 {

	static int dp[], nums[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		nums = new int[n+1];
		dp = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			nums[i] = sc.nextInt();
		}
		
		dp[1] = nums[1];
		
		for(int i=2; i<=n; i++) {
			dp[i] = nums[i];
			for(int j=1; j<i; j++) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[j] + nums[i], dp[i]);
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=1; i<=n; i++) {
			if(dp[i]>max) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}

}
