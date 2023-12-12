import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj17135 {
	static int r, c, d, max = 0, e = 0;
	static int[][] map;

	
	static int fire(int[] chosen) {
		int[] dy = { 0, -1, 0 }; // 우선 순위가 좌 우
		int[] dx = { -1, 0, 1 };
		int [][] temp = new int [r][c];
		int cnt=0;
		for(int y=0; y<r; y++) {
				for(int x=0; x<c; x++) {
					temp[y][x]=map[y][x];
				}
		}
		for (int t = 0; t < r; t++) {
			HashSet<Point> killed = new HashSet<>();
		for (int a = 0; a < chosen.length; a++) { // 궁수만큼 반복
			
			Queue<Point> q = new ArrayDeque<>();
			boolean [][] visited = new boolean[r][c];
				int aX = chosen[a];
				int aY = r - t;
				q.offer(new Point(aX, aY - 1));
				while (!q.isEmpty()) { // bfs 탐색
					Point cur = q.poll();
					if(temp[cur.y][cur.x]==1 && !visited[cur.y][cur.x]) {
						killed.add(cur);
						break;
					}
					visited[cur.y][cur.x] = true;
					
					for (int i = 0; i < 3; i++) {
						int ny = dy[i] + cur.y;
						int nx = dx[i] + cur.x;
						if (nx >= 0 && ny >= 0 && nx < c && ny < aY && !visited[ny][nx]) {
							Point next = new Point(nx, ny);
							if (isIn(aX, aY, next)) {
								q.add(next);
							}
						}
					}
				}
				q.clear();
		}
		cnt+=killed.size();
		for(Point p : killed) {
			temp[p.y][p.x]=0;
		}
		}
		return cnt;
	}

	static boolean isIn(int aX, int aY, Point target) {
		int distance = Math.abs(aX - target.x) + Math.abs(aY - target.y);
		if (target.y < aY && distance <= d) {
			return true;
		} else {
			return false;
		}
	}

	static void makeComb(int nth, int start, int[] chosen) {
		if (max == e) {
			return;
		}
		if (nth == chosen.length) {
			max = Math.max(max, fire(chosen));
			return;
		}

		for (int i = start; i < c; i++) {
			chosen[nth] = i;
			makeComb(nth + 1, i + 1, chosen);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[r + 1][c];
		for (int y = 0; y < r; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < c; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == 1) {
					e++;
				}
			}
		}

		if (e != 0) {
			makeComb(0, 0, new int[3]);
		}
		System.out.println(max);
	}

}
