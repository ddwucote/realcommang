package week16;

import java.util.*;

public class q1174 {

    static long N;
    static long start = 0;
    static String s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextLong();        
        	
        while (N > 0) {
        	
            int i = 0, j = 0;
            
            s = Long.toString(start);
            char max = s.charAt(0);

            while (i < s.length() - 1) {
                if ((s.charAt(i) - '0') <= (s.charAt(i + 1) - '0'))
                    j++;

                if (i >= 1 && ((s.charAt(i) - '0') == (max - '0') || (s.charAt(i) - '0') > (max - '0'))) {
                    j++;
                    max = s.charAt(i);
                }

                i++;
            }

            if (j == 0) {
                N -= 1;
            }

            if (N <= 0) {
                break;  
            }

            start++;
            
            if(start == Integer.MAX_VALUE) {
            	start = -1;
            	break;
            }
        }
        
        System.out.println(start);
    }
}
