import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj17406 {
	static int  [][] map;
	static int M,N,R;
	static boolean [][] visited;
	
	static void rotate(int r, int c, int s) {
		int row =r+r;
		int col = c+c;
		int cnt = Math.min(row, col)/2;
		Deque<Integer> q = new ArrayDeque<Integer>();
		int[] dy = { 1, 0, -1, 0 };
		int[] dx = { 0, 1, 0, -1 };
		
		for (int t = 0; t<cnt; t++) {
			int y = r-s, x = c-s;
			for (int i = 0; i < 4; i++) {
				while (true) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny >= r+t && nx >= c+t && ny < row - t && nx < col - t && !visited[ny][nx]) {
						visited[ny][nx] = true;
						q.add(map[ny][nx]);
						y = ny;
						x = nx;
					} else {
						break;
					}
				}
			}
			
			int cur = q.removeLast();
			q.addFirst(cur);
			
			y = r-s;
			x = c-s;
			for (int i = 0; i < 4; i++) {
				while (true) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny >= t && nx >= t && ny < row - t && nx < col - t && visited[ny][nx]) {
						visited[ny][nx] = false;
						map[ny][nx] = q.removeLast();
						y = ny;
						x = nx;
					} else {
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // row
		M = Integer.parseInt(st.nextToken()); // col
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < M; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			rotate(r,c,s);
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					sb.append(map[y][x] + " ");
				}
				sb.append("\n");
			}
		}
	}
}
