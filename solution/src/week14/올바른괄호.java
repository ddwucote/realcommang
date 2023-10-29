package week14;

class 올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;

        int num = 0;
		
		for(int i = 0; i < s.length(); i++) {
			
			if(num < 0) break;
			
			if(s.charAt(i) == '(') {
				num++;
			}
			else if (s.charAt(i) == ')') {
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