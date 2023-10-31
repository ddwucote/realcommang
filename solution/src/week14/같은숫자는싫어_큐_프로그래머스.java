package week14;
import java.util.*;

public class 같은숫자는싫어_큐_프로그래머스 {
    
    public int[] solution(int []arr) {
       
        int[] answer = {};
        
        Queue<Integer> que = new LinkedList<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int i = 0; i < arr.length; i++) {
            que.offer(arr[i]);
        }

        int a = Integer.MAX_VALUE;
		while(!que.isEmpty()) {
			int tmp = que.poll();
			
            if(a != tmp) {
              ans.add(tmp);
            }
            
            a = tmp;
		}
        
        answer = new int[ans.size()];
        
        int j = 0;
        while(j < ans.size()) {
            answer[j] = ans.get(j);
            j++;
        }
        
        return answer;
    }
}