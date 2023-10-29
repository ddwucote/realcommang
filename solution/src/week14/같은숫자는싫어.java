package week14;
import java.util.*;

public class 같은숫자는싫어 {

	public int[] solution(int []arr) {
        
		int[] answer = {};
       
		int size = arr.length;
		int [] answer0 = new int[size];
        
        int count = 0;
		int count1 = 0;
        
        for(int i = 1; i < size; i++) {
        	
        	if(arr[i] != arr[i-1]) {
                count1++;
        		count = 0;
        		answer0[i] = count;
        	}
        	else if(arr[i] == arr[i-1]) {
        		count++;
        		answer0[i] = count;
        	}
        }
        
        answer = new int[count1+1];
        int j = 0;
        for(int i = 0; i < size; i++) {
        	if(answer0[i] == 0) {
        		answer[j++] = arr[i];
        	}
        }
        
        return answer;
    }
}
