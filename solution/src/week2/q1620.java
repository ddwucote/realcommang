package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class q1620 {

    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        HashMap<Integer, String> mint = new HashMap<>();
        HashMap<String, Integer> mstr = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            mint.put(i, name);
            mstr.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            String temp = br.readLine();
            if(isNum(temp)){
                sb.append(mint.get(Integer.parseInt(temp))+"\n");
            }else{
                sb.append(mstr.get(temp)+"\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean isNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
