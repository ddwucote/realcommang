package week12;

import java.io.*;
import java.util.*;

import week12.q7569.Node;

public class q2668 {

	static int N;
	static int[][] nums;

	static ArrayList<Integer> arr = new ArrayList<>();
	static boolean[] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		nums = new int[2][N + 1];
		visit = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) { // 첫째줄
			nums[0][i] = i;
		}

		for (int j = 1; j <= N; j++) { // 둘째줄
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			nums[1][j] = start;
		}

		for (int j = 1; j <= N; j++) { 
			visit[j] = true;
			dfs(j, j);
			visit[j] = false;
		}
		
		Collections.sort(arr);
		System.out.println(arr.size());
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}

	}

	public static void dfs(int start, int target) {
		
		if(!visit[nums[1][start]]) {
			visit[nums[1][start]] = true;
			dfs(nums[1][start], target);
			visit[nums[1][start]] = false;
		}
		
		if(nums[1][start] == target) {
			arr.add(target);
		}
	}
}
