import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Battery {
	int index;
	int power;

	Battery(int index, int power) {
		this.index = index;
		this.power = power;
	}

}

public class Swea5644 {
	/*
	 * 10x10 A는 0,0에서 b는 9,9에서 출발
	 *
	 */
	static int[][][] map;

	static void setBattery(int x, int y, int range, int index) {
		boolean[][] visited = new boolean[11][11];
		map[index][y][x] = index;
		Queue<Point> q = new LinkedList<Point>();
		int[] dy = { 1, 0, -1, 0 };
		int[] dx = { 0, -1, 0, 1 };
		q.add(new Point(x, y));
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;
				if (Math.abs(x - nx) + Math.abs(y - ny) <= range && nx >= 1 && ny >= 1 && ny <= 10 && nx <= 10 && !visited[ny][nx]) {
					map[index][ny][nx] = index;
					visited[ny][nx]=true;
					q.add(new Point(nx,ny));
				}
				
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Point[] p1; // a
		Point[] p2; // b
		Battery[] bc;
		for (int t = 1; t <= testCase; t++) {
			map = new int[9][11][11];
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken()); // 이동 횟수
			int a = Integer.parseInt(st.nextToken()); // BC 개수
			p1 = new Point[m + 1];
			p2 = new Point[m + 1];
			p1[0] = new Point(1, 1);
			p2[0] = new Point(10, 10);
			int[] dy = { 0, -1, 0, 1, 0 };
			int[] dx = { 0, 0, 1, 0, -1 };
			bc = new Battery[a + 1];
			bc[0] = new Battery(0, 0);
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) {
				int d = Integer.parseInt(st.nextToken());
				int ny = p1[i - 1].y + dy[d];
				int nx = p1[i - 1].x + dx[d];
				p1[i] = new Point(nx, ny);
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) {
				int d = Integer.parseInt(st.nextToken());
				int ny = p2[i - 1].y + dy[d];
				int nx = p2[i - 1].x + dx[d];
				p2[i] = new Point(nx, ny);
			}

			for (int i = 1; i <= a; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int range = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());

				bc[i] = new Battery(i, power);
				setBattery(x, y, range, i);
			}


			int sum = 0;
			for (int i = 0; i <= m; i++) {
				Point p1Pos = p1[i];
				Point p2Pos = p2[i];
				int temp = 0;
				for (int j = 0; j <= 8; j++) {
					for (int k = 0; k <= 8; k++) {
						if (map[j][p1Pos.y][p1Pos.x] == map[k][p2Pos.y][p2Pos.x]) {
							temp = Math.max(temp, bc[map[j][p1Pos.y][p1Pos.x]].power);
						} else {
							temp = Math.max(temp,
									bc[map[j][p1Pos.y][p1Pos.x]].power + bc[map[k][p2Pos.y][p2Pos.x]].power);
						}
					}
				}
				sum += temp;
			}
			sb.append(String.format("#%d %d\n", t, sum));

		}
		System.out.println(sb);
	}

}
