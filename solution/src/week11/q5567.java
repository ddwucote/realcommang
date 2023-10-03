package week11;

import java.io.*;
import java.util.*;

public class q5567 {

	static int n, m;
	static ArrayList<ArrayList<Integer>> friends;
	static boolean [] visit;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		friends = new ArrayList<>();
		visit = new boolean [n+1];
		visit[1] = true;
		
		for(int i = 0; i <= n; i++) {
			friends.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			friends.get(x).add(y);
			friends.get(y).add(x);
		}
		
		wedding(1, 0);
		
		for(int i = 2; i <= n; i++) {
			if(visit[i]) count++;
		}
		
		System.out.println(count);
		
	}
	
	public static void wedding(int i, int depth) {
		
		if(depth == 2) {
			return;
		}
		
		for(int j = 0; j < friends.get(i).size(); j++) {
			int next = friends.get(i).get(j);
			visit[next] = true;
			wedding(next, depth+1);
		}
	}

}
