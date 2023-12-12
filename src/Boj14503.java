import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14503 {
	// 방향 0 북 1동 2남 3서
	static int[][] map;
	static int r, c;

	static int start(int startX, int startY, int startD) {
		int cnt = 0;
		int dir = startD;
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(startX, startY));
		int[] dy = { -1, 0, 1, 0 };
		int[] dx = { 0, 1, 0, -1 };

		while (!q.isEmpty()) {
			Point cur = q.poll();
			// 현재 칸 청소
			if (map[cur.y][cur.x] == 0) {
				map[cur.y][cur.x] = 2;
				cnt++;
			}

			boolean isEmpty = false;
			// 4방향에 빈칸 있는지 탐색
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + cur.x;
				int ny = dy[i] + cur.y;

				if (map[ny][nx] == 0) {
					isEmpty = true;
					break;
				}
			}

			if (isEmpty) {
				for (int i = 0; i < 4; i++) {
					dir--;// 빈칸 있으면 90도 회전
					if(dir < 0) {
						dir=3;
					}
					// 앞으로 갈 수 있는지?
					int nx = dx[dir] + cur.x;
					int ny = dy[dir] + cur.y;
					if (map[ny][nx] == 0) {
						q.add(new Point(nx, ny));
						break;
					}
				}

			} else { // 뒤로 이동 가능한지?
				int nx = cur.x + dx[(dir + 2) % 4];
				int ny = cur.y + dy[(dir + 2) % 4];
				if (map[ny][nx] == 1) {
					break;
				} else {
					q.add(new Point(nx, ny));
				}
			}

		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new int[r][c];

		st = new StringTokenizer(br.readLine());
		int startY = Integer.parseInt(st.nextToken());
		int startX = Integer.parseInt(st.nextToken());
		int startD = Integer.parseInt(st.nextToken());

		for (int y = 0; y < r; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < c; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(start(startX, startY, startD));
	}

}
