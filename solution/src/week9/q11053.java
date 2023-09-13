package week9;
import java.util.*;
import java.io.*;
import java.math.*;

public class q11053 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] nums = new int[N];
		int[] dp = new int[N];
		
		for(int i = 0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		
		for(int i = 0; i<N; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(nums[j] < nums[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		int max = -2;
		for(int i=0; i<N; i++) {
			max = dp[i] > max ? dp[i] : max;
		}
		
		System.out.println(max);
		
	}

}
