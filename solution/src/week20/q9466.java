package week20;


import java.util.*;
import java.io.*;

public class q9466 {
    static int[] selected;
    static boolean[] visited;
    static boolean[] finished;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            selected = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                selected[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                dfs(j);
            }

            System.out.println(n - count);
        }
    }

    static void dfs(int start) {
        if (visited[start]) return;

        visited[start] = true;
        int next = selected[start];

        if (!visited[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                count++;
                for (int i = next; i != start; i = selected[i]) {
                    count++;
                }
            }
        }

        finished[start] = true;
    }
}
