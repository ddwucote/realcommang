package week8;
import java.util.*;

public class q2579 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //계단의 개수
		
		int [] stairs = new int[301];
		int [] scores = new int[301];
		
		for(int i = 1; i <= n; i++) {
			stairs[i] = sc.nextInt();
		}
		
		scores[1] = stairs[1];
		scores[2] = stairs[1] + stairs[2];
		scores[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
		
		for(int i=4; i<=n; i++) {
			scores[i] = 
					Math.max(scores[i-3]+stairs[i-1], scores[i-2])+stairs[i];
		}
		
		System.out.println(scores[n]);
	}
}
