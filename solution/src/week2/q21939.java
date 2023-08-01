package week2;

import java.io.*;
import java.util.*;

public class q21939 {
	
    static int N, M;
    static int[] in = new int[100001];    
    
    static PriorityQueue<Problem> asc = new PriorityQueue<>();    
    static PriorityQueue<Problem> desc = new PriorityQueue<>(Collections.reverseOrder());   
    
    static class Problem implements Comparable<Problem> {
        int p, l;

        public Problem(int p, int l) {
            this.p = p;
            this.l = l;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.l == o.l) {
                return Integer.compare(this.p ,o.p);
            }
            return Integer.compare(this.l, o.l);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Problem prob = new Problem(p, l);
            in[p] = l;           
            asc.offer(prob);
            desc.offer(prob);
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("recommend")){
                if(Integer.parseInt(st.nextToken()) == -1){
                    while(true){
                        Problem p = asc.peek();
                        if(in[p.p] == p.l){            
                            sb.append(p.p).append("\n");
                            break;
                        }
                        asc.poll();      
                    }
                }else{
                    while(true){
                        Problem p = desc.peek();
                        if(in[p.p] == p.l){
                            sb.append(p.p).append("\n");
                            break;
                        }
                        desc.poll();
                    }
                }
            }else if(command.equals("add")){
                int probNo = Integer.parseInt(st.nextToken());
                int probLev = Integer.parseInt(st.nextToken());
                Problem newProb = new Problem(probNo,probLev);
                in[probNo] = probLev;
                asc.offer(newProb);
                desc.offer(newProb);
            }else if(command.equals("solved")){
            	in[Integer.parseInt(st.nextToken())] = 0;
            }
        }
        System.out.println(sb.toString());
    }

}