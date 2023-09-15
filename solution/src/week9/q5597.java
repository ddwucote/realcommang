package week9;
import java.util.*;

public class q5597 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] students = new int[30];
		int[] submit = new int[28];
		
		for(int i=0; i<30; i++)
			students[i] = i+1;
		
		for(int i=0; i<28; i++) 
			submit[i] = sc.nextInt();
		
		for(int i=0; i<28; i++)
			for(int j=0; j<30; j++) {
				if(submit[i] == students[j])
					students[j] = 100;
			}
		
		int min = 100;
		int max = 0;
		
		for(int i=0; i<30; i++) 
		{
			if(students[i] != 100) {
				if(min > students[i])
					min = students[i];
				if(max < students[i])
					max = students[i];
			}
		}
	System.out.println(min);
	System.out.println(max);
	
	}

}
