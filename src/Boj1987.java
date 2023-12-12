import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1987 {
	static int[][] map;
	static int r, c,max=0;
	static int[] arr = new int[27];

	static void dfs(int x, int y, int depth, int[] arr) {
		arr[map[y][x]] = -1;
		max = Math.max(max, depth);

		int[] dy = { 0, 1, -1, 0 };
		int[] dx = { 1, 0, 0, -1 };

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < c && ny < r && arr[map[ny][nx]] != -1) {
				dfs(nx,ny,depth+1,arr.clone());
			}
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		for (int i = 0; i < 27; i++) {
			arr[i] = i;
		}
		for (int y = 0; y < r; y++) {
			String str = br.readLine();
			for (int x = 0; x < c; x++) {
				map[y][x] = str.charAt(x) - 'A';
			}
		}
		dfs(0, 0, 1, arr.clone());
		System.out.println(max);
	}

}
