package week5;
import java.util.Scanner;

public class q14916 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int count = 0;
        
         while(true){
             if(N%5 == 0){
                    count += N/5;
                 System.out.println(count);
                 break;
             }else{
                 N -= 2;
                 count++;
             }
             if(N < 0){
                 System.out.println(-1);
                 break;
             }
         }
	}

}
