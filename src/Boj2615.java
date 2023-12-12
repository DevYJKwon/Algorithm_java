import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj2615 {
	static int[][] map = new int[19][19];
	static Point min;

	static boolean check(Point start) {
		boolean res = false;

		int[][] dy = { { -1, 1 }, { -1, 1 }, { -1, 1 }, { 0, 0 } };
		int[][] dx = { { -1, 1 }, { 0, 0 }, { 1, -1 }, { -1, 1 } };

		for (int i = 0; i < 4; i++) {
			int cnt = 1;
			min = new Point(start.x, start.y);
			for (int j = 0; j < 2; j++) {
				int d = 1;
				while (true) {
					int ny = start.y + dy[i][j] * d;
					int nx = start.x + dx[i][j] * d;
					if (ny >= 0 && nx >= 0 && ny < 19 && nx < 19 && map[start.y][start.x] == map[ny][nx]) {
						cnt++;

						if (nx < min.x || (nx==min.x && ny < min.y)) {
							min = new Point(nx, ny);
						}

					} else {
						break;
					}
					d++;
				}
			}
			if (cnt == 5) {
				res = true;
				return res;
			}
		}
		return res;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Point> list = new ArrayList<>();
		for (int y = 0; y < 19; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < 19; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());

				if (map[y][x] == 1 || map[y][x] == 2) {
					list.add(new Point(x, y));
				}

			}
		}
		int res = 0;
		for (int i = 0; i < list.size(); i++) {
			if (check(list.get(i))) {
				Point cur = list.get(i);
				res = map[cur.y][cur.x];
				break;
			}
		}
		sb.append(res + "\n");
		if (res != 0) {
			sb.append((min.y+1) + " " + (min.x+1));
		}
		System.out.println(sb);
	}
}
