package week14;

import java.util.*;

class 올바른괄호_큐_프로그래머스 {
    boolean solution(String s) {
        boolean answer = true;

        Queue<Character> que = new LinkedList<Character>();
        
        int num = 0;
		
        for(int i = 0; i < s.length(); i++) {
			
			que.offer(s.charAt(i));
		}
        
		while(!que.isEmpty()) {
			
            char a = que.poll();
            
			if(num < 0) break;
			
			if(a == '(') {
				num++;
			}
			else if (a == ')') {
				num--;
			}
		}
        
        if(num == 0)
            answer = true;
        else
            answer = false;

        return answer;
    }
}