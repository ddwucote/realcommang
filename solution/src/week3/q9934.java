package week3;

import java.io.*;

public class q9934 {

	static int K;
	static int[] array;
	static StringBuffer[] ans;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		K = Integer.parseInt(br.readLine());
		array = new int[(int) Math.pow(2, K) - 1];
		String[] in = br.readLine().split(" ");
		
		for (int i = 0; i < array.length; i++)
			array[i] = Integer.parseInt(in[i]);

		ans = new StringBuffer[K];
		
		for (int i = 0; i < K; i++)
			ans[i] = new StringBuffer();

		solve(0, array.length - 1, 0);

		for (int i = 0; i < K; i++)
			bw.write(ans[i].toString() + "\n");
		bw.flush();

	}

	public static void solve(int start, int end, int floor) {

		if (floor == K)
			return;

		int mid = (start + end) / 2;
		ans[floor].append(array[mid] + " ");

		solve(start, mid - 1, floor + 1);
		solve(mid + 1, end, floor + 1);
	}

}