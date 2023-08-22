package week5;
import java.util.Scanner;
import java.util.Arrays;

public class q11399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		int[] array = new int[N];
		
		for(int i = 0; i < N; i++) {
			array[i] = in.nextInt();
		}
		
		Arrays.sort(array);
 
 
		int prev = 0;	 
		int sum = 0;	
				
		for(int i = 0; i < N; i++) {	
			sum += prev + array[i];
			prev += array[i];
		}
		System.out.println(sum);
	}

}
