package week4;
import java.util.*;

public class q2745 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		int N = sc.nextInt();
		int temp = 1;
		int ans = 0;
		
		for (int i = s.length()-1; i >= 0; i--) {
			char c = s.charAt(i);
			
			if('A'<= c && c <= 'Z') {
				ans += (c-'A'+10)*temp;
			}else {
				ans += (c-'0')*temp;
			}
			temp *= N;
		}
		
		System.out.println(ans);
	}

}
