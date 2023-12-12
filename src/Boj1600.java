import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1600 {
	static int w, h, k, min = Integer.MAX_VALUE;
	static int[][] map;

	static class State {
		int x, y, d, j;

		public State(int x, int y, int d, int j) {
			this.x = x;
			this.y = y;
			this.d = d; // 방문횟수
			this.j = j; // 점프한 차원
		}

	}

	static void bfs() {
		boolean[][][] visited = new boolean [k+1][h][w];
		int[] dy = { -1, 1, 0, 0 }; // 일반은 3까지 나이트 이동 가능하면 4~11
		int[] dx = { 0, 0, -1, 1 };
		int[] kdy = { -2, -2, 2, 2, -1, 1, 1, -1 };
		int[] kdx = { -1, 1, -1, 1, -2, 2, -2, 2 };
		
		Queue<State> q = new ArrayDeque<>();
		q.add(new State(0, 0, 0, 0));
		visited[0][0][0] = true;
		while (!q.isEmpty()) {
			State cur = q.poll();
			if (cur.x == w - 1 && cur.y == h - 1) {
				min = cur.d;
				return;
			}

			//사방탐색
			for (int di = 0; di < 4; di++) {
				int ny = cur.y + dy[di];
				int nx = cur.x + dx[di];
				if (nx >= 0 && ny >= 0 && nx < w && ny < h && map[ny][nx] == 0 && !visited[cur.j][ny][nx]) {
					visited[cur.j][ny][nx] = true;
					q.add(new State(nx, ny, cur.d+1, cur.j));
				}
			}
			// 점프 횟수가 있으면 나이트 탐색
			if (cur.j < k) {
				for (int di = 0; di < 8; di++) {
					int ny = cur.y + kdy[di];
					int nx = cur.x + kdx[di];
					if (nx >= 0 && ny >= 0 && nx < w && ny < h && map[ny][nx] == 0&& !visited[cur.j+1][ny][nx]) {
						visited[cur.j + 1][ny][nx] = true;
						q.add(new State(nx, ny, cur.d + 1, cur.j + 1));// 다음 차원, 점프
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		k = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][w];

		for (int y = 0; y < h; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < w; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		if (w == 1 && h == 1) {
			System.out.println(0);
			return;
		}

		bfs();

		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
	}

}
