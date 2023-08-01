package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class q11279 {
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());

            if (a == 0)
                sb.append(que.size() == 0 ? 0 : que.poll()).append('\n');
            else que.add(a);
        }
        
        System.out.println(sb.toString());
    }
}
