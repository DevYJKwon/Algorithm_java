import java.io.*;
import java.util.*;
import java.util.List;
import java.awt.*;

public class Boj16236 {
	/*
	 * 아기상어 초반 크기 :2 1초에 상하좌우 1칸 이동 자신보다 큰 물고기가 있는 칸을 갈 수 없다. 자기보다 작은 물고기만 먹을 수 있다.
	 * 같은 크기면 먹을 순 없지만 칸으로 갈 수 있다. 왼쪽,위 우선순위 크기는 상관 x
	 * 
	 */

	static class Node implements Comparable<Node> {
		int x, y, d;

		Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		public int compareTo(Node o) {
			if (this.d == o.d) {
				if (this.y < o.y) {
					return -1;
				} else if (this.y > o.y) {
					return 1;
				} else {
					if (this.x < o.x) {
						return -1;
					} else {
						return 1;
					}
				}
			}

			return Integer.compare(this.d, o.d);

		}
	}
	static int ate,size,exp;
	static int bfs(Point start) {
		int time = 0;
		Queue<Node> pq = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][n];

		int[] dy = { -1, 0, 1, 0 };
		int[] dx = { 0, -1, 0, 1 };
		ate = 0;
		size = 2;
		exp = 0;

		pq.add(new Node(start.x, start.y, 0));
		visited[start.y][start.x] = true;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[ny][nx]) {
					if (map[ny][nx] == 0) {
						pq.add(new Node(nx, ny, cur.d + 1));
					} else if (map[ny][nx] < 7) {
						if (map[ny][nx] == size) {
							pq.add(new Node(nx, ny, cur.d + 1));
						} else if (map[ny][nx] < size) {
							pq.clear();
							pq.add(new Node(nx, ny, cur.d + 1));

							
							if (isFin(size)) {
								return cur.d + 1;
							}
							visited = new boolean[n][n];
							visited[ny][nx] = true;
							break;
						}
					}
					visited[ny][nx] = true;
				}
			}
		}

		return time;
	}
	static void eat(Point pos) {
		ate++;
		exp++;
		if (exp == size) {
			exp = 0;
			size++;
		}
		map[pos.y][pos.x] = 0;
	}
	static boolean isFin(int size) {
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (map[y][x] > 0 && map[y][x] < 7 && map[y][x] < size) {
					return false;
				}
			}
		}
		return true;
	}

	static int[][] map;
	static int n;
	static int fCnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		Point start = null;
		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < n; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] > 0 && map[y][x] < 7) {
					fCnt++;
				} else if (map[y][x] == 9) {
					start = new Point(x, y);
				}
			}
		}

		if (isFin(2)) {
			System.out.println(0);
			return;
		}

		System.out.println(bfs(start));

	}

}
