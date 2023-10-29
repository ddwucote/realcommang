package week14;

import java.util.*;
import java.io.*;

public class 기능개발_이클립스 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), ",", false);
		
		int [] progresses = new int [100];
		int [] speeds = new int [100];
		
		int i = 0;
		while(st.hasMoreTokens()) {
			progresses[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		
		st = new StringTokenizer(br.readLine(), ",", false);
		int j = 0;
		while(st.hasMoreTokens()) {
			speeds[j] = Integer.parseInt(st.nextToken());
			j++;
		}
		
		ArrayList<Integer> day = new ArrayList<>();
		
		for(int k = 0; k < progresses.length; k++) {
			day.add(0);
		}
		
		int days = 0;
		int sum = 0;
		
		while(sum != i) {
			
			for(int k = 0; k < progresses.length; k++) {
				
				if(progresses[k] >= 100) {
					continue;
				}
				if(progresses[k] < 100) {
					progresses[k] += speeds[k];
					day.set(k, days);
				}
			}
			
			sum = 0;
			
			for(int k = 0; k < progresses.length; k++) {				
				if(progresses[k] >= 100) {
					sum++;
				}
			}
			
			days++;
		}
		
		int [] answer = {};
		answer = new int [progresses.length+1];
		
		for(int k = 0; k < answer.length; k++) {
			answer[k] = 0;
		}
		
		int max = day.get(0);
		answer[0] = 1;
		int index = 0;
		
		for(int k = 1; k < i; k++) {
			if(day.get(k) <= max) {
				answer[index] += 1;
			}
			else {
				max = day.get(k);
				index++;
				answer[index] += 1;
			}
		}
		
		for(int k = 0; k <= index; k++) {
			System.out.print(answer[k]);
		}
	}

}
