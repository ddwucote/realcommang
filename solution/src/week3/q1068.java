package week3;
import java.util.*;

public class q1068 {

	static int num, del, count;
    static int[] Pnode;
    static boolean[] check;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        num = sc.nextInt();
        Pnode = new int[num];
        int root = 0;
        
        for(int i = 0; i < num; i++) {
        	Pnode[i] = sc.nextInt();        
            if(Pnode[i] == -1) root = i;
        }
        
        del = sc.nextInt();        
        deleteNode(del);
            
        count = 0;
        check = new boolean[num];
        cnt(root);
            
        System.out.println(count);
    }
    
    public static void deleteNode(int d) {
    	Pnode[d] = -2; 
        for(int i = 0; i < num; i++) {
            if(Pnode[i] == d) {
                deleteNode(i);
            }
        }
    }
    
    public static void cnt(int s) {
        boolean isLeaf = true;
        check[s] = true;
        if(Pnode[s] != -2) {
            for(int i = 0; i < num; i++) {
                if(Pnode[i] == s && check[i] == false) {
                	cnt(i);
                    isLeaf = false;
                }
            }
            if(isLeaf) count++;
        }
    }
}
