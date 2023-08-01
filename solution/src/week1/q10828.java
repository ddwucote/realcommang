

package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class q10828 {
 
	public static int[] box;
	public static int amount = 0;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
 
		box = new int[N];
		
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
 
			switch (st.nextToken()) {
			
			case "pop":
				sb.append(pop()).append('\n');
				break;
				
			case "amount":
				sb.append(amount()).append('\n');
				break;
				
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
				
			case "empty":
				sb.append(empty()).append('\n');
				break;
				
			case "top":
				sb.append(top()).append('\n');
				break;
			}
 
		}
		System.out.println(sb);
	}
 
	public static void push(int item) {
		box[amount] = item;
		amount++;
	}
	
	public static int pop() {
		if(amount == 0) {
			return -1;
		}
		else {
			int res = box[amount - 1];
			box[amount - 1] = 0;
			amount--;
			return res;
		}
	}
	
	public static int amount() {
		return amount;
	}
	
	public static int empty() {
		if(amount == 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public static int top() {
		if(amount == 0) {
			return -1;
		}
		else {
			return box[amount - 1];
		}
	}
	
}
 