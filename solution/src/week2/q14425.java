package week2;

import java.io.*;
import java.util.*;

public class q14425 {
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> sol = new HashMap<>();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
        	sol.put(br.readLine(), 0);
        }
        
        int sum = 0;
        
        for (int i = 0; i < m; i++) {
            if (sol.containsKey(br.readLine())) sum++;
        }
        System.out.print(sum);
    }
}