package week10;

import java.io.*;
import java.util.*;

public class q18232 {

	static int min = Integer.MAX_VALUE;
	static int N, M, S, E;
	//텔레포트 정보
	static ArrayList<ArrayList<Integer>> teleport;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //길 전체 길이
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken()); //주예 위치
		E = Integer.parseInt(st.nextToken()); //방주 위치
		
		visited = new boolean[N+1];
		teleport = new ArrayList<>();
		
		for(int i = 0; i <= N; i++) {
			teleport.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			//양방향 연결
			teleport.get(x).add(y);
			teleport.get(y).add(x);
		}
		
		int result = bfs();
		System.out.println(result);		
	}
	
	static int bfs() {
		
		Queue<Integer> que = new LinkedList<>();
		que.add(S);
		visited[S] = true;
		int time = 0;
		
		while(!que.isEmpty()) {
			
			int size = que.size();
			
			for(int i = 0; i < size; i++) {
				int now = que.poll();
				
				if(now == E) {
					return time;
				}
				
				for(int next : teleport.get(now)) {
					if(!visited[next]) {
						que.add(next);
						visited[next] = true;
					}
				}
				
				int next1 = now + 1;
				int next2 = now -1;
				
				if(next1 <= N && !visited[next1]) {
					que.add(next1);
					visited[next1] = true;
				}
				
				if(next2 >= 1 && !visited[next2]) {
					que.add(next2);
					visited[next2] = true;
				}
			}
			time++;
		}
		return -1;
	}
}
