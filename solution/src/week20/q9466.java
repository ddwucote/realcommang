package week20;


import java.util.*;
import java.io.*;

public class q9466 {
    static int[] selected; //각 학생이 선택한 학생의 번호 저장
    static boolean[] visited; //방문여부
    static boolean[] finished; //학생마다 dfs 탐색 완료 여부
    static int count; //순환구조에 속하는 학생의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            //학생수 1로 시작
            selected = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
            	//각 학생이 선택한 번호
                selected[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                dfs(j); //학생수만큼 루프
            }

            System.out.println(n - count);
        }
    }

    static void dfs(int start) {
        if (visited[start]) return; //이미 방문 -> 종료

        visited[start] = true;
        int next = selected[start]; //현재 학생이 선택한 학생

        if (!visited[next]) {
            dfs(next);
        } else {
            if (!finished[next]) { //해당 학생의 dfs가 완료 x
                count++;
                for (int i = next; i != start; i = selected[i]) {
                    count++;
                }
            }
        }

        finished[start] = true;
    }
}
