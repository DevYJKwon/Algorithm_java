import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17069 {
	static final int R = 0, C = 1, D = 2;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [][]map = new int[n+1][n+1];
		long [][][] dp = new long[3][n+1][n+1];
		StringTokenizer st;
		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < n; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[R][0][1]=1;

		for(int y=0; y<n; y++) {
			for(int x=1; x<n; x++) {
				if(map[y][x+1] == 0) {
					dp[R][y][x+1]= dp[R][y][x]+dp[C][y][x];
				}
				if(map[y+1][x+1] == 0 && map[y+1][x] ==0 && map[y][x+1]==0) {
					dp[C][y+1][x+1]=dp[R][y][x]+dp[C][y][x]+dp[D][y][x];
				}
				if(map[y+1][x]==0) {
					dp[D][y+1][x]=dp[C][y][x]+dp[D][y][x];
				}
			}
		}
		
		System.out.println(dp[R][n][n]+dp[C][n][n]+dp[D][n][n]);
	}

}
