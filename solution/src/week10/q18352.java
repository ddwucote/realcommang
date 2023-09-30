package week10;

import java.io.*;
import java.util.*;

public class q18352 {

	static int N, M, X, K;
	//그래프 저장(간선정보)
	static ArrayList<ArrayList<Integer>> distance = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> visit = new ArrayList<ArrayList<Integer>>();
	//2인도시
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
			visit.add(new ArrayList<Integer>());
			cities.add(Integer.MAX_VALUE);
		}
		
		for(int i = 0; i < M; i++) { //간선 정보 추가
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			distance.get(A).add(B);
			visit.get(A).add(0);
		}
		
		/*
		 * for(int i = 0; i < distance.get(X).size(); i++) { int node =
		 * distance.get(X).get(i); countDistance(node); }
		 */
		
		countDistance(X);
		
		int count = 0;
		for(int i = 0; i < cities.size(); i++) {
			if(cities.get(i) == K) {
				System.out.println(i);
				count++;
			}	
		}
		
		if(count == 0)
			System.out.println(-1);
	}

	static void countDistance(int node) {
		
		int sum = 0;
		
		Queue<Integer> que = new LinkedList<>();
		que.offer(node);
		
		while(!que.isEmpty()) {
			
			int a = que.poll();
			//System.out.println("a " + a);
			
			for(int i=0; i< distance.get(a).size();i++) {
				
				if(visit.get(a).get(i) == 0) { //방문 x
					
					//System.out.println(distance.get(a).get(i));
					
					visit.get(node).set(i, 1);
					sum++;
					
					//System.out.println("K, sum" + K + " " + sum);
					int nodeInfo = distance.get(a).get(i);
					
					if(cities.get(nodeInfo) > sum) {
						//System.out.println("sum: " + distance.get(a).get(i));
						cities.set(nodeInfo, sum);
						//System.out.println(cities.get(nodeInfo) + " " + nodeInfo);
						sum = 0;
					}
					
					que.offer(distance.get(a).get(i));
				}
			}
		}
	}
}
