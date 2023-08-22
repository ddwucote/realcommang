package week4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q22864 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int sum = 0, p = 0, ans = 0;
		while(sum != 24) {
			if(p + a <= m) {
				ans += b;
				p += a;
			}
			else {
				p = p - c < 0 ? 0 : p - c;
			}
			sum++;
		}
		System.out.print(ans);
	}

}
