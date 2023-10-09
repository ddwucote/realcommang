package week12;

import java.io.*;
import java.util.*;

import week12.q7569.Node;

public class q2668 {

	static int N;
	static int [][] nums;
	
	static ArrayList<Integer> arr = new ArrayList<>();
	
	public static class Node {
		int start;
		int end;
		
		public Node(int start) {
			this.start = start;
		}
		
		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	static ArrayList<Node> arrays = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		nums = new int [2][N+1];
		
		for(int i = 1; i <= N; i++) { //첫째줄
			nums[0][i] = i; 			
		}
		
		arrays.add(new Node(0,0));
		
		for(int j = 1; j <= N; j++) { //둘째줄
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			nums[1][j] = start;
			arrays.add(new Node(start, j));
		}
		
		System.out.println(count());
		Collections.sort(arr);
		
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		
	}
	
	public static int count() {
		
		int count = 0;
	
		for(int i = 1; i <= N; i++) {
			int end = nums[1][i];
			Node node = arrays.get(end);
			if((i == node.start) && (end == node.end)) {
				count++;
				arr.add(node.start);
			}
		}
		
		return count;
	}
}
