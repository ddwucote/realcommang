package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class q21942 {
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        String L = st.nextToken();
        int d = Integer.parseInt(L.substring(0,3));
        int h = Integer.parseInt(L.substring(4,6));
        int m = Integer.parseInt(L.substring(7, L.length()));
        int r = d*24*60 + h*60 + m;
        int F = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Long> fin = new HashMap<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String date = st.nextToken();
            String time = st.nextToken();
            String item = st.nextToken();
            String user = st.nextToken();
            String id = item + "_" + user;

            if(map.containsKey(id)) {
                String dateStr1 = map.get(id);
                String dateStr2 = date + " " + time;
                SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                long d1 = f.parse(dateStr1).getTime();
                long d2 = f.parse(dateStr2).getTime();

                long diff = ((d2-d1) / (1000*60));
                if(diff > r) {
                      if(fin.containsKey(user)) {
                          fin.put(user, fin.get(user)+(diff-r)*F);
                      } else {
                          fin.put(user,(diff-r)*F);
                      }
                }
                map.remove(id);
            } else {
                map.put(id, date + " " + time);
            }
        }

        List<String> list = new ArrayList<>(fin.keySet());
        list.sort((s1,s2) -> s1.compareTo(s2));
        if(fin.size() <= 0){
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for(String key : list) {
                sb.append(key + " " + fin.get(key)).append("\n");
            }
            System.out.print(sb.toString());
        }
    }
}