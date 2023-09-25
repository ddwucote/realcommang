package week10;

import java.io.*;
import java.util.*;

public class q2644 {
	
	static int n;
	static int[] question = new int [2];
	static boolean[] visit;
	static List<Integer>[] relation;
	static int result = -1;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); //전체 사람 수
		relation = new ArrayList[n+1];
		visit = new boolean[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i < n+1; i++) {
			relation[i] = new ArrayList<>(); 
		}
		
		question[0] = Integer.parseInt(st.nextToken()); //사람1
		question[1] = Integer.parseInt(st.nextToken()); //사람2
		
		int m = Integer.parseInt(br.readLine());
		int i = m;
		
		while(i > 0) {
			
			st = new StringTokenizer(br.readLine());
			
			int parent = Integer.parseInt(st.nextToken());
			int baby = Integer.parseInt(st.nextToken());
			
			relation[parent].add(baby);
			relation[baby].add(parent);
			
			i--;
		}
		
		countRelation(question[0], question[1], 0);
		System.out.println(result);
	}

	static void countRelation(int x, int y, int count) {
		
		if(x == y) {
			result = count;
			return;
		}
		
		visit[x] = true;
		
		for(int i = 0; i < relation[x].size(); i++) {
			int nr = relation[x].get(i);
			if(!visit[nr]) {
				countRelation(nr, y, count+1);
			}
		}
	}
}
