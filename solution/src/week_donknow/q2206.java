package week_donknow;

import java.util.*;
import java.io.*;

class Node {
    int x, y, distance;
    boolean wall;

    public Node(int x, int y, int distance, boolean wall) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.wall = wall;
    }
}

public class q2206 {

	static int N, M;
	static int [][] map;
	static boolean [][] visited;
	static int min = Integer.MAX_VALUE;
	
	static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		visited = new boolean [N][M];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);
		
		System.out.println(min);
	}
	
	static void bfs(int x, int y) {
		
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 1, false));
        
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (node.x == N - 1 && node.y == M - 1) {
                min = Math.min(node.distance, min);
                break;
            }

            for (int i = 0; i < 4; i++) {
               	
                int j = node.x + dx[i];
                int k = node.y + dy[i];

                if (j >= 0 && k >= 0 && j < N && k < M) {
                    if (map[j][k] == 0 && !visited[j][k]) {
                        visited[j][k] = true;
                        queue.add(new Node(j, k, node.distance + 1, node.wall));
                    } else if (map[j][k] == 1 && node.wall == false && !visited[j][k]) {
                        visited[j][k] = true;
                        queue.add(new Node(j, k, node.distance + 1, true));
                    }
                }
            }
        }
	}
}

