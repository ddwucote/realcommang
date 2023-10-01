package week10;

import java.io.*;
import java.util.*;

public class q18232 {

	static int min = Integer.MAX_VALUE;
	static int N, M, S, E;
	//텔레포트 정보
	static ArrayList<int []> teleport = new ArrayList<int []>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //길 전체 길이
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken()); //주예 위치
		E = Integer.parseInt(st.nextToken()); //방주 위치
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int [] tele = new int [2];
			tele[0] = x; tele[1] = y;
			teleport.add(tele);
		}
		
		int i = 0;
		
		while(i < teleport.size()) {
			
			if(teleport.get(i) == null) {
				System.out.println("null");
				break;
			}
			
			int start = teleport.get(i)[0];
			int end = teleport.get(i)[1];
			
			getMin(start, end);
			i++;
		}
		
		System.out.println(min);
	}

	static void getMin(int start, int end) {
		
		int time = 1;
		time += Math.abs(start - S);
		time += Math.abs(end - E);
		
		
		
		if(min > time)
			min = time;
	}
}
