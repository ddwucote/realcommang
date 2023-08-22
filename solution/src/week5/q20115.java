package week5;
import java.util.Scanner;

public class q20115 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		double[] array = new double[N];
		double max = 0;
		
		for (int i = 0; i < N; i++) {
			array[i] = in.nextDouble();
			if (max < array[i])
				max = array[i];
		}
		
		double sum = max;
		
		for (int i = 0; i < N; i++) {
			if (array[i] == max)
				continue;
			sum += array[i] / 2;
		}
		
		System.out.println(sum);
	}

}
