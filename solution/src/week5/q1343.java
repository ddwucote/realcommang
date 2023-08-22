package week5;
import java.util.*;

public class q1343 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
 
        String res = "";
 
        res = poliomino(s);
 
        System.out.println(res);
	}

	private static String poliomino(String s) {
		String A = "AAAA", B = "BB";
		String ans = "";
          
        s = s.replaceAll("XXXX", A);
        ans = s.replaceAll("XX", B);
        
        if(ans.contains("X")) {
            ans = "-1";
        }
 
        return ans;
    }
}
