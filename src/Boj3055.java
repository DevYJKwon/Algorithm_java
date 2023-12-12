import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj3055 {
	static Queue<Node> wq = new ArrayDeque<Node>();
	static Queue<Node> q = new ArrayDeque<Node>();
	static class Node {
		int x, y, d;

		public Node(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

	static String bfs() {
		int[] dy = { 1, 0, 0, -1 };
		int[] dx = { 0, 1, -1, 0 };
		int step = 0;
		while (!q.isEmpty()) {
			while (!wq.isEmpty()) {
				if (wq.peek().d != step) {
					break;
				}
				Node w = wq.poll();

				for (int i = 0; i < 4; i++) {
					int nx = w.x + dx[i];
					int ny = w.y + dy[i];
					if (isIn(nx, ny) && (map[ny][nx] == 'S' || map[ny][nx] == '.')) {
						map[ny][nx] = '*';
						wq.add(new Node(nx, ny, w.d + 1));
					}
				}
			}

			while (!q.isEmpty()) {
				if (q.peek().d != step) {
					break;
				}
				Node cur = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];
					if (isIn(nx, ny) && (map[ny][nx] == '.' || map[ny][nx] == 'D')) {
						if (nx == goal.x && ny == goal.y) {
							return Integer.toString(cur.d + 1);
						}
						map[ny][nx] = 'S';
						q.add(new Node(nx, ny, cur.d + 1));
					}
				}
			}
			step++;
		}
		return "KAKTUS";
	}

	static boolean isIn(int x, int y) {
		if (x >= 0 && y >= 0 && x < m && y < n) {
			return true;
		}
		return false;
	}

	static char[][] map;
	static int n, m;
	static Point goal;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for (int y = 0; y < n; y++) {
			String str = br.readLine();
			for (int x = 0; x < m; x++) {
				map[y][x] = str.charAt(x);
				if (map[y][x] == 'S') {
					q.add(new Node(x, y, 0));
				} else if (map[y][x] == '*') {
					wq.add(new Node(x,y,0));
				} else if (map[y][x] == 'D') {
					goal = new Point(x, y);
				}
			}
		}
		System.out.println(bfs());

	}

}
