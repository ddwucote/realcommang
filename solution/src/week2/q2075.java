package week2;

import java.util.*;
import java.io.*;
 
class q2075 {
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N*N];
        int index =0;
 
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
            	array[index++] = Integer.parseInt(st.nextToken());
            }
        }
 
        Arrays.sort(array);
 
        System.out.println(array[N*N - N]);
    }
}