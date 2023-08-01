package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class q10866 {
	
	static int f = 0;
	static int b = 0;
	static int amount = 0;
	static int[] deq = new int[10000];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			
			switch(s[0]) {
			
				case "push_front" : {
					push_front(Integer.parseInt(s[1]));
					break;
				}
				
				case "push_back" : {
					push_back(Integer.parseInt(s[1]));
					break;
				}
				
				case "pop_front" : {
					sb.append(pop_front()).append('\n');
					break;
				}
				
				case "pop_back" : {
					sb.append(pop_back()).append('\n');
					break;
				}
				
				case "size" : {
					sb.append(size()).append('\n');
					break;
				}
				
				case "empty" : {
					sb.append(empty()).append('\n');
					break;
				}
				
				case "front" : {
					sb.append(front()).append('\n');
					break;
				}
				
				case "back" : {
					sb.append(back()).append('\n');
					break;
				}
			}
			
		}
		System.out.println(sb);
	}
		
	
	static void push_front(int val) {
		deq[f] = val;
		f = (f - 1 + 10000) % 10000;
		amount++;
	}
	
	static void push_back(int val) {
		b = (b + 1) % 10000;
		amount++;
		deq[b] = val;
	}
	
	static int pop_front() {
		if (amount == 0) {
			return -1;
		}
		int ret = deq[(f + 1) % 10000];
		f = (f + 1) % 10000;
		amount--;	
		return ret;
	}
	
	static int pop_back() {
		if (amount == 0) {
			return -1;
		} 
		int ret = deq[b];
		b = (b - 1 + 10000) % 10000;
		amount--;
		return ret;
	}
	
	static int front() {
		if(amount == 0) {
			return -1;
		}
		return deq[(f + 1) % 10000];
	}
	
	static int back() {
		if(amount == 0) {
			return -1;
		}
		return deq[b];
	}
	
	static int size() {
		return amount;
	}
	
	static int empty() {
		if(amount == 0) {
			return 1;
		}
		return 0;
	}
}