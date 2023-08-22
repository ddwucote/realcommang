package week5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class q2217 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] r = new int[N];

		for (int i = 0; i < N; i++) {
			r[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(r); 
		
		int max = Integer.MIN_VALUE;
		
		
		for (int i = 0; i < N; i++) {
			max = Math.max(max, r[i] * (N - i));
		}

		bw.write(max + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

}
