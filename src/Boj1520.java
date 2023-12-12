import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1520 {
	static int n, m;
	static int[][] map;
	static int[][] dp;

	static int[] dx = { 0, 1, -1, 0 };
	static int[] dy = { 1, 0, 0, -1 };

	static int dfs(int x, int y) {
		if(y == n-1 && x== m-1 ) {
			return 1;
		}
		
		if(dp[y][x] != -1) {
			return dp[y][x];
		}
		
		dp[y][x]=0;
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
				if(map[y][x] > map[ny][nx]) {
					dp[y][x] += dfs(nx,ny);
				}
			}
		}
		return dp[y][x];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		dp = new int[n][m];
		
		
		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < m; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				dp[y][x]=-1;
			}
		}

		System.out.println(dfs(0,0));
	}

}
