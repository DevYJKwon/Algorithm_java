import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj15683 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, min = Integer.MAX_VALUE;
	static int[][] map;
	static List<Point> cctv = new ArrayList<>();
	static int [][] temp;

	static void getComb(int nth, int[] choosed) {
		if (choosed.length == nth) {
			temp = new int[n][m];
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < m; x++) {
					temp[y][x] = map[y][x];
				}
			}
			for (int i = 0; i < choosed.length; i++) {
				Point cur = cctv.get(i);
				temp[cur.y][cur.x] = choosed[i];

				String str = Integer.toString(choosed[i]);
				for (int s = 0; s < str.length(); s++) {
					int dir = str.charAt(s) - '0';

					int[] dx = { 0, 0, 0, -1, 1 };
					int[] dy = { 0, -1, 1, 0, 0 };
					int d = 0;

					while (true) {
						int nx = dx[dir] * d + cur.x;
						int ny = dy[dir] * d + cur.y;
						if (nx >= 0 && ny >= 0 && nx < m && ny < n && temp[ny][nx] != 6) {
							temp[ny][nx] = 9; // 9 = checked
							d++;
						} else {
							break;
						}
					}
				}
			}
			int cnt = 0;
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < m; x++) {
					if (temp[y][x] == 0) {
						cnt++;
					}
				}
			}
			min = Math.min(min, cnt);
			return;
		}
		Point cur = cctv.get(nth);
		int type = map[cur.y][cur.x];
		// 1.상 2.하 3.좌 4.우

		if (type == 1) {
			int[] dir = { 1, 2, 3, 4 };
			for (int i = 0; i < dir.length; i++) {
				choosed[nth] = dir[i];
				getComb(nth + 1, choosed);
			}
		} // 한 방향
		else if (type == 2) {
			int[] dir = { 34, 12 };
			for (int i = 0; i < dir.length; i++) {
				choosed[nth] = dir[i];
				getComb(nth + 1, choosed);
			}
		} else if (type == 3) {
			int[] dir = { 13, 14, 24, 23 };
			for (int i = 0; i < dir.length; i++) {
				choosed[nth] = dir[i];
				getComb(nth + 1, choosed);
			}
		} else if (type == 4) {
			int[] dir = { 134, 234, 123, 124 };
			for (int i = 0; i < dir.length; i++) {
				choosed[nth] = dir[i];
				getComb(nth + 1, choosed);
			}
		} else {
			choosed[nth] = 1234;
			getComb(nth + 1, choosed);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < m; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] != 0 && map[y][x] != 6) {
					cctv.add(new Point(x, y));
				}
			}
		}
		getComb(0, new int[cctv.size()]);
		System.out.println(min);
	}
}
