import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj9205 {
	/*
	 * 한 상자 20개 맥주 1맥주 -> 50미터
	 * 
	 * 풀 상자 -> 1000미터
	 */
	static class Node {
		int x, y, beer;

		public Node(int x, int y, int beer) {
			super();
			this.x = x;
			this.y = y;
			this.beer = beer;
		}

	}

	static String bfs(Node start) {
		Queue<Node> q = new ArrayDeque<>();
		boolean res = false;
		boolean[] visited = new boolean[store.length];
		q.add(start);

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (move(cur.x, cur.y, goal) != -1) {
				return "happy";
			}

			for (int i = 0; i < store.length; i++) {
				int b = move(cur.x, cur.y, store[i]);
				if (!visited[i] && b != -1) {
					visited[i] = true;
					q.add(new Node(store[i].x, store[i].y, cur.beer - b));
				}
			}
		}

		return "sad";
	}

	static int move(int x, int y, Point store) {
		int dis = Math.abs(x - store.x) + Math.abs(y - store.y);
		if (dis <= 1000) {
			return (int) Math.ceil(dis / 50);
		}
		return -1;
	}

	static Point[] store;
	static Point goal;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int s = Integer.parseInt(br.readLine());
			store = new Point[s];
			st = new StringTokenizer(br.readLine());
			Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 20);

			for (int i = 0; i < s; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				store[i] = new Point(x, y);
			}

			st = new StringTokenizer(br.readLine());
			goal = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			sb.append(bfs(start)).append("\n");

		}
		System.out.println(sb);
	}

}
