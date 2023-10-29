package week14;

import java.util.*;

class 기능개발_프로그래머스 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        ArrayList<Integer> day = new ArrayList<>();
		
		for(int k = 0; k < progresses.length; k++) {
			day.add(0);
		}
        
        int days = 0;
		int sum = 0;
		
		while(sum != progresses.length) {
			
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
		
		int [] answer1 = {};
		answer1 = new int [progresses.length+1];
		
		for(int k = 0; k < answer.length; k++) {
			answer1[k] = 0;
		}
		
		int max = day.get(0);
		answer1[0] = 1;
		int index = 0;
		
		for(int k = 1; k < progresses.length; k++) {
			if(day.get(k) <= max) {
				answer1[index] += 1;
			}
			else {
				max = day.get(k);
				index++;
				answer1[index] += 1;
			}
		}
        
        answer = new int[index+1];
        
        for(int k = 0; k <= index; k++) {
			answer[k] = answer1[k];
		}
        
        return answer;
    }
}