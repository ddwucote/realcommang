package week4;
import java.util.Scanner;

public class q1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		 
		int N = in.nextInt();
		in.close();
        
		int count = 0;
		int copy = N;
        
		while (true) {
			N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
			count++;
 
			if (copy == N) {
				break;
			}
		}
		System.out.println(count);
	}

}
