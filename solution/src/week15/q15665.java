package week15;

import java.util.*;

public class q15665 {

	static ArrayList<Integer> array = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			int k = sc.nextInt();	
			if(array.isEmpty())
				array.add(k);
			else
				if(!array.contains(k))
					array.add(k);
		}
		
		Collections.sort(array);
		
		for(int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
	}

}
