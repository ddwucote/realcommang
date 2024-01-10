package week20;

import java.util.*;
import java.io.*;

public class q16932 {
    static int N, M;
    static int[][] arr;
    static int[][] component; //각 배열 요소가 속하는 모양 id 저장
    static int max = 0; //최대 모양 크기
    static int componentId = 2; //현재까지 사용된 연결 요소의 id 추적
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
            	//연결요소가 할당되지 않은 1
                if (arr[i][j] == 1 && component[i][j] == 0) {
                	//연결요소 크기 저장
                    int size = calculateComponentSize(i, j, componentId);
                    componentSizeMap.put(componentId, size);
                    //다음 연결 요소->증가
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

    //각 연결 요소의 크기를 계산하고 각 요소에 고유한 ID 할당
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

    //최대 모양 크기 계산
    static int calculateMaxShapeSize(int x, int y) {
        Set<Integer> adjacentComponents = new HashSet<>();
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            //어떤 연결 요소에 속해있는지 확인
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && component[nx][ny] != 0) {
                adjacentComponents.add(component[nx][ny]);
            }
        }

        int totalSize = 1; // Including the current cell
        for (int id : adjacentComponents) {
        	//각 요소의 크기를 더함
            totalSize += componentSizeMap.get(id);
        }

        return totalSize;
    }
}
