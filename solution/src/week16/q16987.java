package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q16987 {

    static int N;
    static ArrayList<List<Integer>> eggs = new ArrayList<>();
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            List<Integer> egg = new ArrayList<>();
            egg.add(Integer.parseInt(st.nextToken()));
            egg.add(Integer.parseInt(st.nextToken()));
            eggs.add(egg);
        }

        dfs(0);

        System.out.println(max);
    }

    static void dfs(int index) {
        if (index == N) {
            int count = 0;
            for (List<Integer> egg : eggs) {
                if (egg.get(0) <= 0) {
                    count++;
                }
            }
            max = Math.max(max, count);
            return;
        }

        if (eggs.get(index).get(0) <= 0) {
            dfs(index + 1);
            return;
        }

        boolean canBreak = false;

        for (int i = 0; i < N; i++) {
            if (i != index && eggs.get(i).get(0) > 0) {
                canBreak = true;

                List<Integer> originalEggL = new ArrayList<>(eggs.get(index));
                List<Integer> originalEggR = new ArrayList<>(eggs.get(i));

                List<Integer> eggL = new ArrayList<>(eggs.get(index));
                List<Integer> eggR = new ArrayList<>(eggs.get(i));

                int left = eggL.get(0) - eggR.get(1);
                int right = eggR.get(0) - eggL.get(1);

                eggL.set(0, left);
                eggs.set(index, eggL);

                eggR.set(0, right);
                eggs.set(i, eggR);

                dfs(index + 1);

                // 백트래킹
                eggs.set(index, originalEggL);
                eggs.set(i, originalEggR);
            }
        }

        if (!canBreak) {
            dfs(index + 1);
        }
    }
}
