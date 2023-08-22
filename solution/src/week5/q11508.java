package week5;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class q11508 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        Integer[] goods = new Integer[N];

        for(int i=0;i<N;i++) goods[i] = in.nextInt();
        
        Arrays.sort(goods, Comparator.reverseOrder());

        int sum = 0;
        for(int i=0;i<N;i++){
            if(i%3==2) continue;
            sum += goods[i];
        }
        System.out.println(sum);
	}

}
