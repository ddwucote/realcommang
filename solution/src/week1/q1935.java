package week1;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class q1935 {
	
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String inf = br.readLine();
        double[] array = new double[num];
        
        for(int i = 0; i < array.length; i++) {
        	array[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        double result = 0;
        for(int i = 0; i < inf.length(); i++) {
            if('A' <= inf.charAt(i) && inf.charAt(i) <= 'Z') {
                stack.push(array[inf.charAt(i) - 'A']);
            } 
            else {
                if(!stack.isEmpty()) {
                    double first = stack.pop();
                    double second = stack.pop();
                    switch (inf.charAt(i)) {
                        case '+':
                            result = second + first;
                            stack.push(result);
                            continue;
                        case '*':
                            result = second * first;
                            stack.push(result);
                            continue;
                        case '-':
                            result = second - first;
                            stack.push(result);
                            continue;
                        case '/':
                            result = second / first;
                            stack.push(result);
                            continue;
                    }
                }
            }
        }

        System.out.printf("%.2f", stack.pop());

        br.close();
    }
}