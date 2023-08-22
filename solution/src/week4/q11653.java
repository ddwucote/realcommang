package week4;
import java.util.Scanner;

public class q11653 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        
		int N = in.nextInt();
 
		for (int i = 2; i * i <= N; i++) {
			
			while (N % i == 0) {
				System.out.println(i);
				N /= i;
			}
			
		}
		if (N != 1) {
			System.out.println(N);
		}
	}

}
