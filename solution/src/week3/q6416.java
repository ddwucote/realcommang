package week3;
import java.util.*;

public class q6416 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> v;
        int cnt = 1;
        
        while(true) {
            v = new HashMap<>();
            int edge = 0;
            
            while(true) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                
                if(s == -1 && e == -1) return;
                else if(s == 0 && e == 0) break;
 
                v.put(s, v.getOrDefault(s, 0));
                v.put(e, v.getOrDefault(e, 0) + 1);
                edge++;
            }
            
            int root = 0;
            boolean isTrue = true;
            Iterator<Integer> key = v.keySet().iterator();
            
            while(key.hasNext()) {
                int num = key.next();
                if(v.get(num) == 0) root++;
                else if(v.get(num) > 1) {
                    isTrue = false;
                    break;
                }
            }
            
            if(v.size() == 0) {
                System.out.println("Case " + cnt + " is a tree.");
            }
            else if(isTrue && root == 1 && edge == v.size() - 1) {
                System.out.println("Case " + cnt + " is a tree.");
            } else {
                System.out.println("Case " + cnt + " is not a tree.");
            }
            cnt++;
        }

	}

}
