package week10;

import java.io.*;
import java.util.*;

public class q18352 {

	static int N, M, X, K;
	
	//그래프 저장(간선정보)
	static ArrayList<ArrayList<Integer>> distance = new ArrayList<ArrayList<Integer>>();
	static ArrayList<Integer> cities = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //도시의 개수
		M = Integer.parseInt(st.nextToken()); //도로의 개수
		K = Integer.parseInt(st.nextToken()); //최단 거리
		X = Integer.parseInt(st.nextToken()); //출발 도시의 번호
		
		for(int i = 0; i <= N; i++) { //도시 노드 추가
			distance.add(new ArrayList<Integer>());
			cities.add(Integer.MAX_VALUE);
		}
		
		for(int i = 0; i < M; i++) { //간선 정보 추가
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			distance.get(A).add(B);
		}
		
		countDistance(X);
		
		boolean found = false;
		for(int i = 0; i <= N; i++) {
			if(cities.get(i) == K) {
				System.out.println(i);
				found = true;
			}	
		}
		
		if(!found)
			System.out.println(-1);
	}

	static void countDistance(int node) {
		
		Queue<Integer> que = new LinkedList<>();
		que.offer(node);
		cities.set(node, 0);
		
		while(!que.isEmpty()) {
			
			int a = que.poll();
			
			/*
			 * for(int i=0; i< distance.get(a).size();i++) {
			 * 
			 * if(distance.get(a).get(i) == 0) { //방문 x
			 * 
			 * int nodeInfo = distance.get(a).get(i);
			 * 
			 * if(cities.get(nodeInfo) > cities.get(a) + 1) { cities.set(nodeInfo,
			 * cities.get(a) + 1); que.offer(distance.get(a).get(i)); } } }
			 */
			
			for(int next : distance.get(a)) {
				if(cities.get(next) > cities.get(a) + 1) {
					cities.set(next, cities.get(a) + 1);
					que.offer(next);
				}
			}
		}
	}
}
