
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 두 나라의 인구 차이가 L명 이상 R명 이하라면 국경선을 연다
 * 연합을 이루고 있는 각 칸의 인구수 = 연합의 인구수 / 칸의 개수
 * 모든 국경선을 닫는다
 * N,L,R 주어지고
 * 각 나라의 인구수 주어짐
 */
public class Boj16234 {
	static int n, min, max;
	static int[][] map;
	static boolean[][] visited;
	static List<Point> list;

	static int start() {
		int cnt = 0;

		while (true) {
			boolean isChanged = false;
			visited = new boolean[n][n];
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					if (visited[y][x]) {
						continue;
					}

					int sum = bfs(x, y);

					if (list.size()==1) {
						continue;
					}

					isChanged = true;
					for (Point p : list) {
						map[p.y][p.x] = sum / list.size();
					}

				}
			}

			if (!isChanged) {
				break;
			}
			cnt++;
		}

		return cnt;
	}

	static boolean checkGap(int from, int to) {
		int gap = Math.abs(from - to);
		if (gap >= min && gap <= max) {
			return true;
		}
		return false;
	}

	static int bfs(int x, int y) {
		list = new ArrayList<>();
		list.add(new Point(x,y));
		int sum = map[y][x];
		int[] dy = { 1, 0, 0, -1 };
		int[] dx = { 0, 1, -1, 0 };
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(x, y));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[ny][nx]
						&& checkGap(map[cur.y][cur.x], map[ny][nx])) {
					sum += map[ny][nx];
					list.add(new Point(nx,ny));
					q.add(new Point(nx, ny));
					visited[ny][nx] = true;
				}
			}
		}

		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		min = Integer.parseInt(st.nextToken()); // L
		max = Integer.parseInt(st.nextToken()); // R
		map = new int[n][n];
		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < n; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(start());
	}
}
