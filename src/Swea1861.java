import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Swea1861 {
	/*
	 * NxN 방 i번째 줄의 j번째 방 1 <= x <= N^2 모든 방이 다르다 어떤 방에서 상하좌우 이동 가능 but 현재 방보다 1 커야함
	 * 어떤 방에서 시작해야 많은 방을 갈 수 있는가?
	 * 
	 * 테스트 케이스 T
	 * 
	 * 첫 번재 줄 N 다음 N개 줄에서 Aij가 공백 구분으로 들어옴.
	 *  
	 * DFS 목표 노드가 깊은 곳에 있다면 BFS보다 낫다. 
	 */

	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int maxDepth;

	static int dfs(int x, int y, int depth) {
		maxDepth = Math.max(depth, maxDepth);
		visited[y][x] = true;
		int isTerminal = 0;

		int[] dy = { 1, -1, 0, 0 };
		int[] dx = { 0, 0, 1, -1 };

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= 0 && nx >= 0 && ny < N && nx < N && map[ny][nx] - map[y][x] == 1) {
				isTerminal = Math.max(isTerminal, dfs(nx,ny,depth+1));
			}
		}
		return isTerminal == 0? depth:isTerminal;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int input = Integer.parseInt(st.nextToken());
					map[i][j] = input;
				}
			}

			visited = new boolean[N][N];
			int max = 0;
			int minRoom = Integer.MAX_VALUE;
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if(visited[y][x]) {
						continue;
					}
					int cnt= dfs(x,y,1);
					if(cnt > max) {
						max = cnt;
						minRoom = map[y][x];
					}
					else if(cnt == max) {
						if(minRoom > map[y][x]) {
							minRoom = map[y][x];
						}
					}
				}
			}

			sb.append(String.format("#%d %d %d\n", testCase, minRoom, max));
		}
		System.out.println(sb);
	}

}
