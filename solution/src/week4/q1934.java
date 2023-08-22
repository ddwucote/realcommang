package week4;
import java.util.Scanner;

public class q1934 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
        
		StringBuilder sb = new StringBuilder();
 
		
		for(int i = 0; i < N; i++) {
			
			int a = in.nextInt();
			int b = in.nextInt();
			
			int d = calc(a, b);	
			
			sb.append(a * b / d).append('\n');
		}
		System.out.println(sb);
	}

	public static int calc(int a, int b) {
		 
		while (b != 0) {
			int r = a % b; 
 
			a = b;
			b = r;
		}
		return a;
	}
}
