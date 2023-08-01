package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class q1158 {
 
    public static void main(String[] args) throws Exception {
    	
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
 
        Queue<Integer> que = new LinkedList<>();
        
        for (int i = 1; i <= N; i++) {
        	que.offer(i);
        }
 
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        while(que.size() != 1) {
            for (int i = 0; i < K - 1; i++) {
            	que.offer(que.poll());
            }
            sb.append(que.poll() + ", ");
        }
        
        sb.append(que.poll() + ">");
 
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}