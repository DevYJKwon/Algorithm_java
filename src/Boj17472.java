import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj17472 {

	/*
	 * 완탐으로 섬의 개수를 구하기 섬 칠하기 -> 노드로 만들기 섬에서 다른 섬까지 간선 비용 구하기 크루스칼
	 */

	static final int INF = 200;

	static class Edge implements Comparable<Edge> {
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	static void makeSet(int i) {
		parents = new int[i];
		for (int j = 0; j < i; j++) {
			parents[j] = j;
		}
	}

	static int find(int a) {
		if (parents[a] == a) {
			return a;
		}

		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot) {
			return false;
		}

		if (aRoot > bRoot) {
			int temp = aRoot;
			aRoot = bRoot;
			bRoot = temp;
		}
		parents[bRoot] = aRoot;
		return true;
	}

	static void getIsland(Point p) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(p);

		while (!q.isEmpty()) {
			Point cur = q.poll();
			map[cur.y][cur.x] = ii;
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + cur.x;
				int ny = dy[i] + cur.y;
				if (nx >= 0 && ny >= 0 && nx < m && ny < n && map[ny][nx] == 1) {
					q.add(new Point(nx, ny));
				}
			}
		}
		ii++;
	}

	static void getEdge(Point p) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(p);
		int me = map[p.y][p.x];
		int[] cost = new int[cnt];
		Arrays.fill(cost, INF);
		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x;
				int ny = cur.y;
				int len = 0;
				while (true) {
					nx += dx[i];
					ny += dy[i];
					if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
						if (map[ny][nx] == me && !checked[ny][nx]) {
							q.add(new Point(nx, ny));
							checked[ny][nx] = true;
							break;
						} else if (map[ny][nx] == 0) {
							len++;
						} else {
							if (len >= 2) {
								cost[map[ny][nx] - 2] = Math.min(cost[map[ny][nx] - 2], len);
							}
							break;
						}
					} else {
						break;
					}
				}
			}
		}
		for (int i = 0; i < cost.length; i++) {
			if (cost[i] == INF) {
				continue;
			}
			pq.add(new Edge(me - 2, i, cost[i]));
		}
		visited[me - 2] = true;
	}

	static int[] parents;
	static int[][] map;
	static int ii = 2, cnt = 0;
	static int n, m;

	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };

	static boolean[] visited = new boolean[6];
	static boolean[][] checked;

	static PriorityQueue<Edge> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		checked = new boolean[n][m];
		List<Point> list = new ArrayList<>();
		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < m; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == 1) {
					list.add(new Point(x, y));
				}
			}
		}

		for (Point p : list) {
			if (map[p.y][p.x] == 1) {
				getIsland(p);
			}
		}

		cnt = ii - 2; // 섬의 개수
		for (Point p : list) {
			if (!visited[map[p.y][p.x] - 2]) {
				getEdge(p);
			}
		}
		makeSet(cnt);
		int success = 0;
		int res = 0;
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			if (union(e.from, e.to)) {
				res += e.cost;
				if (++success == cnt - 1) {
					break;
				}
			}
		}
		if (success == cnt - 1) {
			System.out.println(res);
		} else {
			System.out.println(-1);
		}

	}

}
