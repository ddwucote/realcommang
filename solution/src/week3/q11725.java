package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q11725 {

    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j;
        
        int num = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] peak = new ArrayList[num+1];    
        
        for(i=1; i<=num; i++) {
        	peak[i] = new ArrayList<Integer>();
        }
        
        for(i=0; i<num-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            peak[num1].add(num2);peak[num2].add(num1);
        }
        
        int[] pNode = new int[num+1];
        
        dfs(peak, pNode, num, 1, 0);
        for(j=2;j<=num; j++) System.out.println(pNode[j]);
    }

    private static void dfs(ArrayList<Integer>[] peak, int[] pNode, int num, int start, int parent) {
    	pNode[start] = parent;
        for(int item : peak[start]) {
            if(item != parent) 
            	dfs(peak, pNode, num, item, start);
        }
    }
}