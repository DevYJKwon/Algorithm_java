import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj4991 {
	static char[][] map;

	static class Robot {
		int x, y, n, d;

		public Robot(int x, int y, int n, int d) {
			this.x = x;
			this.y = y;
			this.n = n;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Robot [x=" + x + ", y=" + y + ", n=" + n + ", d=" + Integer.toBinaryString(d) + "]";
		}

	}

	static int bfs(Point start, int dust, int r, int c) {
		boolean[][][] visited = new boolean[1 << dust][r][c];
		Queue<Robot> q = new ArrayDeque<>();
		q.add(new Robot(start.x, start.y, 0, 0));
		
		int goal =(1<<dust+1)-1>>1; 
		int[] dy = { 0, 1, 0, -1 };
		int[] dx = { 1, 0, -1, 0 };

		while (!q.isEmpty()) {

			Robot cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				int d = cur.d;
				if (nx >= 0 && ny >= 0 && nx < c && ny < r && !visited[cur.d][ny][nx]&& map[ny][nx] != 'x') {
					if (map[ny][nx] >= 'A'  && map[ny][nx]<= 'A'+dust) {
						d = cur.d | (1 << (map[ny][nx]-'A'));
						if (d == goal) {
							return cur.n+1;
						}
					} 
					visited[d][ny][nx] = true;
					q.add(new Robot(nx, ny,cur.n+1, d));
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			if (r == 0 && c == 0) {
				break;
			}

			map = new char[r][c];
			Point start = null;
			int dust = 0;
			for (int y = 0; y < r; y++) {
				String str = br.readLine();
				for (int x = 0; x < c; x++) {
					map[y][x] = str.charAt(x);
					if (map[y][x] == 'o') {
						start = new Point(x, y);
					} else if (map[y][x] == '*') {
						map[y][x]= (char)('A'+dust++);
					}
				}
			}

			if(dust==0) {
				sb.append(-1).append("\n");
			}else {
				sb.append(bfs(start, dust, r, c)).append("\n");
			}
		}

		System.out.println(sb);
	}

}
