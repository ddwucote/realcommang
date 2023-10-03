package week11;

import java.util.*;

public class programmers_의상 {

	public int solution(String[][] clothes) {
		// TODO Auto-generated method stub
		int answer = 0;
		
		HashMap<String, Integer> wear = new HashMap<>();
		String[] name = new String[clothes.length];
		
		for(int i = 0; i < clothes.length; i++) {
			
			name[i] = clothes[i][1];
			
			if(wear.get(clothes[i][1]) != null) {
				wear.put(clothes[i][1], wear.get(clothes[i][1]) + 1);
			}
			else {
				wear.put(clothes[i][1], 1);
			}
		}
		
		answer = 1;
		
		String[] name2 = Arrays.stream(name).distinct().toArray(String[]::new);
		
		for(int i=0; i < name2.length; i++) {
			answer *= (wear.get(name2[i])+1);
		}
		
		answer = answer - 1;
		
        return answer;
	}

}
