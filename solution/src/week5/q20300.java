package week5;
import java.util.*;

public class q20300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long [] weight = new long[n];
        
        for(int i=0; i<n; i++){
            weight[i] = in.nextLong();
        }
        
        Arrays.sort(weight);
        long maxnum = 0;
        
        if(n%2==0){
            for(int i=0; i<n/2; i++){
                maxnum = Math.max(maxnum,weight[i]+weight[n-1-i]);
            }
        }else{
            maxnum = weight[n-1];
            for(int i=0; i<(n-1)/2; i++){
                maxnum = Math.max(maxnum, weight[i]+weight[n-2-i]);
            }
        }


        System.out.println(maxnum);
	}

}
