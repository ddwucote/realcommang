package week2;

import java.io.*;
import java.util.*;

public class q4358 {
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int sum = 0;
        Map<String, Integer> sol = new HashMap<>();
        
        while ((s = br.readLine()) != null) {
        	sum++;
            sol.put(s, sol.getOrDefault(s, 0) + 1);
        }
        
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sol.entrySet()) {
            String tree = entry.getKey();
            list.add(tree);
        }
        
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        
        for (String tree : list) {
            int count = sol.get(tree) * 100;
            sb.append(tree + " " + String.format("%.4f", (double)count / (double)sum) + "\n");
        }
        
        System.out.print(sb);
    }
}