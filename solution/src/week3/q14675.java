package week3;

import java.util.*;

public class q14675 {
 
    static ArrayList<Integer>[] lists;
    static int num;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        num = sc.nextInt();
        lists = new ArrayList[num + 1];
        
        for(int i = 1; i < num + 1; i++) {
        	lists[i] = new ArrayList<>();
        }
 
        for(int i = 0; i < num - 1; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            lists[v1].add(v2);
            lists[v2].add(v1);
        }
 
        int q = sc.nextInt();
        for(int i = 0; i < q; i++) {
            int t = sc.nextInt();
            int k = sc.nextInt();
 
            if(t == 2) System.out.println("yes");
            else {
                int count = 0;
                for(int temp : lists[k]) {
                    count++;
                }
                if(count >= 2) System.out.println("yes");
                else System.out.println("no");
            }
        }
    }
}
 

