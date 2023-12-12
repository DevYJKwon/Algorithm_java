import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj16927 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		Deque<Integer> q = new ArrayDeque<Integer>();
		int[][] map = new int[row][col];
		boolean[][] visited = new boolean[row][col];

		for (int y = 0; y < row; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < col; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dy = { 1, 0, -1, 0 };
		int[] dx = { 0, 1, 0, -1 };
		
		
		if(row==col && row==1) {
			System.out.println(map[0][0]);
			return;
		}
		
		for (int t = 0; row - t * 2 > 0 && col - t * 2 > 0; t++) {
			int m = (row - t*2) * 2 + (col - t*2) * 2 - 4;
			int spin = r % m;
			int y = t - 1, x = t;
			for (int i = 0; i < 4; i++) {
				while (true) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny >= t && nx >= t && ny < row - t && nx < col - t && !visited[ny][nx]) {
						visited[ny][nx] = true;
						q.add(map[ny][nx]);
						y = ny;
						x = nx;
					} else {
						break;
					}
				}
			}
			for (int i = 0; i < spin; i++) {
				int cur = q.removeLast();
				q.addFirst(cur);
			}
			y = t - 1;
			x = t;
			for (int i = 0; i < 4; i++) {
				while (true) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny >= t && nx >= t && ny < row - t && nx < col - t && visited[ny][nx]) {
						visited[ny][nx] = false;
						map[ny][nx] = q.removeFirst();
						y = ny;
						x = nx;
					} else {
						break;
					}
				}
			}
		}
		for (int y = 0; y < row; y++) {
			for (int x = 0; x < col; x++) {
				sb.append(map[y][x] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}