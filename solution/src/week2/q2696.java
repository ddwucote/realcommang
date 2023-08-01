package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class q2696 {
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int test = Integer.parseInt(br.readLine());
 
        StringBuilder sb = new StringBuilder();
        while (test-- > 0) {
            int N = Integer.parseInt(br.readLine()); 
 
            sb.append(((N + 1) / 2) + "\n"); 
            ArrayList<Integer> a = new ArrayList<>();
            int count = 0; 
 
            for (int i = 0; i < N; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
 
                int x = Integer.parseInt(st.nextToken());
                a.add(x);
                Collections.sort(a); 
                if (i % 2 == 0) {
                    if (count == 9 || i == N - 1) {
                        sb.append(a.get(i / 2) + "\n");
                        count = 0;
                    } else {
                        sb.append(a.get(i / 2) + " ");
                    }
                    count++;
                }
            }
        }
 
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
}
