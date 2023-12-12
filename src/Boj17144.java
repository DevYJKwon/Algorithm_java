import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj17144 {

	static int[][] map;
	static int r, c, t;
	static Point up, down;
	static Queue<Dust> dQueue = new ArrayDeque<>();

	static class Dust {
		int x, y, v;

		public Dust(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}

	}

	static void start() {
		Queue<Dust> q = new ArrayDeque<>();

		while (t-- > 0) {
			for (int y = 0; y < r; y++) {
				for (int x = 0; x < c; x++) {
					if (map[y][x] > 4) {
						spread(x, y, map[y][x]);
					}
				}
			}

			while (!dQueue.isEmpty()) {
				Dust d = dQueue.poll();
				map[d.y][d.x] += d.v;
			}

			// 공기 회전
			circular(0); // 위
			circular(1); // 아래
		}
	}

	static void spread(int ox, int oy, int v) {
		int[] dy = { 1, 0, -1, 0 };
		int[] dx = { 0, 1, 0, -1 };
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int ny = dy[i] + oy;
			int nx = dx[i] + ox;
			if (nx >= 0 && ny >= 0 && ny < r && nx < c && map[ny][nx] != -1) {
				cnt++;
				dQueue.add(new Dust(nx, ny, v / 5));
			}
		}
		map[oy][ox] = v - ((v / 5) * cnt);
	}

	static int getResult() {
		int sum = 0;
		for (int y = 0; y < r; y++) {
			for (int x = 0; x < c; x++) {
				if (map[y][x] > 0) {
					sum += map[y][x];
				}
			}
		}

		return sum;
	}

	static void circular(int dir) {
		int row = 0;
		int startR = 0, endR = 0;
		if (dir == 1) { // 시계
			row = r - down.y;
			startR = down.y;
			endR = r;

		} else { // 0 반시계
			row = up.y + 1;
			startR = 0;
			endR = row;
		}
		int col = c;
		int[][] dx = { { 1, 0, -1, 0 }, { 0, 1, 0, -1 } };
		int[][] dy = { { 0, 1, 0, -1 }, { 1, 0, -1, 0 } };

			int x = 0;
			int y = startR;
			int temp = map[y][x];

			for (int i = 0; i < 4; i++) {
				while (true) {
					int nx = x + dx[dir][i];
					int ny = y + dy[dir][i];
					if (nx >= 0 && ny >= startR && nx < col && ny < endR) {
						map[y][x] = map[ny][nx];
						y = ny;
						x = nx;
					} else {
						break;
					}
				}
			}
			
			
		if (dir == 1) {
			map[down.y][0] = -1;
			map[down.y][1] = 0;
		} else {
			map[1][0]=temp;
			map[up.y][0] = -1;
			map[up.y][1] = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		map = new int[r][c];

		for (int y = 0; y < r; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < c; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == -1) {
					if (up == null) {
						up = new Point(x, y);
					} else {
						down = new Point(x, y);
					}
				}
			}
		}
		

		start();


		System.out.println(getResult());

	}

}
