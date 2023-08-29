package week6;
import java.util.Scanner;

public class q10870 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int n = 0;
		int[] fibo = new int[21]; //피보나치 값 저장
		
		fibo[0] = 0; fibo[1] = 1;
		
		n = in.nextInt();
		
		if(n >= 2) {
			for(int i=2; i<=n; i++) {
				fibo[i] = fibo[i-1] + fibo[i-2];
			}
		}
		
		System.out.println(fibo[n]);
	}

}
