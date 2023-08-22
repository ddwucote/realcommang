package week4;
import java.util.Scanner;

public class q2609 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			 
			Scanner in = new Scanner(System.in);
			
			int a = in.nextInt();
			int b = in.nextInt();
	 
			int d = sol(a, b);
	 
			System.out.println(d);
			System.out.println(a * b / d);
	 
		}
	 
		
		public static int sol(int a, int b) {
			if (b == 0)
				return a;
			else {
				return sol(b, a % b);
			}
		}
	}

