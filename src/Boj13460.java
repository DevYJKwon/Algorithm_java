import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj13460 {
	/*
	 * 보드 세로 n 가로 m 구멍은 하나 빨간 구슬을 구멍으로 빼기 파란 구슬이 구멍에 들어가면 안 됨 상하좌우로 기울여서 빼기 구슬이 움직이지
	 * 않을 때까지 최소 몇 번만에 구슬을 뺄 수 있는가? 10번이하로 뺄 수 없으면 -1 출력
	 */
	static class State {
		Point red, blue;
		int cnt = 0;

		public State(Point red, Point blue, int cnt) {
			this.red = red;
			this.blue = blue;
			this.cnt = cnt;
		}

	}

	static int bfs(State start) {
		Queue<State> q = new ArrayDeque<>();
		q.add(start);

		while (!q.isEmpty()) {
			State cur = q.poll();
			Point red, blue;
			int res=0;
			// 상하좌우
			if (cur.red.y < cur.blue.y) {
				red = moveBall(cur.red, cur.blue, 0);
				blue = moveBall(cur.blue, red, 0);
			} else {
				blue = moveBall(cur.blue, cur.red, 0);
				red = moveBall(cur.red, blue, 0);
			}
			res = checkGoal(red,blue);
			if (res==1 && cur.cnt < 10) {
				return cur.cnt + 1;
			}
			else if (res==0 &&cur.cnt + 1 < 11) {
				q.add(new State(red, blue, cur.cnt + 1));
			}

			if (cur.red.y < cur.blue.y) {
				blue = moveBall(cur.blue, cur.red, 1);
				red = moveBall(cur.red, blue, 1);
			} else {
				red = moveBall(cur.red, cur.blue, 1);
				blue = moveBall(cur.blue, red, 1);
			}
			res = checkGoal(red,blue);
			if (res==1 && cur.cnt < 10) {
				return cur.cnt + 1;
			}
			else if (res==0 &&cur.cnt + 1 < 11) {
				q.add(new State(red, blue, cur.cnt + 1));
			}

			if (cur.red.x < cur.blue.x) {
				red = moveBall(cur.red, cur.blue, 2);
				blue = moveBall(cur.blue, red, 2);
			} else {
				blue = moveBall(cur.blue, cur.red, 2);
				red = moveBall(cur.red, blue, 2);
			}
			res = checkGoal(red,blue);
			if (res==1 && cur.cnt < 10) {
				return cur.cnt + 1;
			}
			else if (res==0 &&cur.cnt + 1 < 11) {
				q.add(new State(red, blue, cur.cnt + 1));
			}

			if (cur.red.x < cur.blue.x) {
				blue = moveBall(cur.blue, cur.red, 3);
				red = moveBall(cur.red, blue, 3);
			} else {
				red = moveBall(cur.red, cur.blue, 3);
				blue = moveBall(cur.blue, red, 3);
			}
			res = checkGoal(red,blue);
			if (res==1 && cur.cnt < 10) {
				return cur.cnt + 1;
			}
			else if (res==0 &&cur.cnt + 1 < 11) {
				q.add(new State(red, blue, cur.cnt + 1));
			}
		}

		return -1;
	}

	private static int checkGoal(Point red, Point blue) {
		if(red.x == -1 && red.y == -1) {
			if(blue.x == -1 && blue.y == -1) {
				return -1;
			}
			return 1;
		}
		else {
			if(blue.x == -1 && blue.y == -1) {
				return -1;
			}
			return 0;
		}
	}

	static Point moveBall(Point ball, Point other, int d) {
		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };

		int nx = ball.x;
		int ny = ball.y;
		while (true) {
			nx = nx + dx[d];
			ny = ny + dy[d];
			if (nx >= 0 && ny >= 0 && nx < m && ny < n && map[ny][nx] != '#' && (nx != other.x || ny != other.y)) {
				if(nx == goal.x && ny == goal.y) {
					return new Point(-1,-1);
				}
				continue;
			} else {
				nx = nx - dx[d];
				ny = ny - dy[d];
				break;
			}
		}
		return new Point(nx, ny);
	}

	static char[][] map;
	static Point goal;
	static int m, n;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		State start = new State(null, null, 0);
		for (int y = 0; y < n; y++) {
			String str = br.readLine();
			for (int x = 0; x < m; x++) {
				map[y][x] = str.charAt(x);
				if (map[y][x] == 'R') {
					start.red = new Point(x, y);
				} else if (map[y][x] == 'B') {
					start.blue = new Point(x, y);
				} else if (map[y][x] == 'O') {
					goal = new Point(x, y);
				}
			}
		}
		System.out.println(bfs(start));
	}

}
