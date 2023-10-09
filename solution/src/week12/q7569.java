package week12;

import java.io.*;
import java.util.*;

import week11.q14496.Node;

public class q7569 {

	static int M, N, H;
	static int [][][] tomato;
	static boolean [][][] visit;
	
	static int row[] = {-1, 0, 1, 0, 0, 0};
    static int col[] = {0, 1, 0, -1, 0, 0};
    static int height[] = {0, 0, 0, 0, 1, -1};
    
	public static class Node {
		int h;
		int n;
		int m;
		
		public Node (int h, int n, int m) {
			this.h = h;
			this.n = n;
			this.m = m;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		tomato = new int [H+1][N+1][M+1];
		visit = new boolean [H+1][N+1][M+1];
		
		for(int s = 1; s <= H; s++) {
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= M; j++) {
					tomato[s][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		int days = bfs();
		System.out.println(days);
	
	}

	static int bfs() {
		
		Queue<Node> que = new LinkedList<>();
		
		for(int s = 1; s <= H; s++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					if(tomato[s][i][j] == 1) {
						que.offer(new Node(s, i, j));
						visit[s][i][j] = true;
					}
				}
			}
		}
		
		int days = 0;
		while(!que.isEmpty()) {
			int size = que.size();
			
			while(size-- > 0) {
				Node node = que.poll();
				
				for(int i = 0; i < 6; i++) {
					int a = height[i] + node.h;
					int b = row[i] + node.n;
					int c = col[i] + node.m;
					
					if(a >= 1 && a <= H && b >= 1 && b <= N && c >= 1 && c <= M
							&& tomato[a][b][c] == 0 && !visit[a][b][c]) {
						visit[a][b][c] = true;
						tomato[a][b][c] = 1;
						que.offer(new Node(a, b, c));
					}
				}
			}
			days++;
		}
		
		for (int s = 1; s <= H; s++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (tomato[s][i][j] == 0) {
                        return -1;
                    }
                }
            }
        }

        return days - 1;
	}
}
