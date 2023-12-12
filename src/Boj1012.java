import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1012 {

	static int[][] map;
	static boolean[][] visited;
	static int n, m, k;
	

	static int bfs(Point p) {
		if (visited[p.y][p.x]) {
			return 0;
		}

		Queue<Point> q = new LinkedList<>();
		q.offer(p);
		visited[p.y][p.x] = true;

		int[] dy = { 0, 1, -1, 0 };
		int[] dx = { 1, 0, 0, -1 };
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for(int i=0; i<4; i++) {
				int ny = dy[i]+cur.y;
				int nx = dx[i]+cur.x;
				if(ny >=0 && nx >= 0&& ny < m && nx <n && !visited[ny][nx] && map[ny][nx]==1) {
					visited[ny][nx]=true;
					q.offer(new Point(nx,ny));
				}
			}
		}

		return 1;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int t = 0; t < testCase; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // x
			m = Integer.parseInt(st.nextToken()); // y
			k = Integer.parseInt(st.nextToken());

			map = new int[m][n];
			visited = new boolean[m][n];
			Point [] cabbage = new Point [k];
			int cnt = 0;
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x]=1;
				cabbage[i] = new Point(x,y);
			}
			
			for(int i=0; i<k; i++) {
				cnt+=bfs(cabbage[i]);
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
