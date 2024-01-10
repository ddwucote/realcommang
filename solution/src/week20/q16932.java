package week20;

import java.util.*;
import java.io.*;

public class q16932 {
    static int N, M;
    static int[][] arr;
    static int[][] component;
    static int max = 0;
    static int componentId = 2;
    static Map<Integer, Integer> componentSizeMap = new HashMap<>();

    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        component = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 연결 요소 식별 및 크기 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && component[i][j] == 0) {
                    int size = calculateComponentSize(i, j, componentId);
                    componentSizeMap.put(componentId, size);
                    componentId++;
                }
            }
        }

        // 모양의 최대 크기 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    max = Math.max(max, calculateMaxShapeSize(i, j));
                }
            }
        }

        System.out.println(max);
    }

    static int calculateComponentSize(int x, int y, int id) {
        int size = 1;
        component[x][y] = id;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = current[0] + dx[k];
                int ny = current[1] + dy[k];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 1 && component[nx][ny] == 0) {
                    component[nx][ny] = id;
                    queue.add(new int[]{nx, ny});
                    size++;
                }
            }
        }

        return size;
    }

    static int calculateMaxShapeSize(int x, int y) {
        Set<Integer> adjacentComponents = new HashSet<>();
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && component[nx][ny] != 0) {
                adjacentComponents.add(component[nx][ny]);
            }
        }

        int totalSize = 1; // Including the current cell
        for (int id : adjacentComponents) {
            totalSize += componentSizeMap.get(id);
        }

        return totalSize;
    }
}
