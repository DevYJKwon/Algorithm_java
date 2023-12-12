import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1149 {
	static final int R = 0, G = 1, B = 2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[3][n];
		st = new StringTokenizer(br.readLine());
		dp[R][0] = Integer.parseInt(st.nextToken());
		dp[G][0] = Integer.parseInt(st.nextToken());
		dp[B][0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dp[R][i] = Math.min(dp[G][i-1]+r, dp[B][i-1]+r);
			dp[G][i] = Math.min(dp[R][i-1]+g, dp[B][i-1]+g);
			dp[B][i] = Math.min(dp[R][i-1]+b, dp[G][i-1]+b);
		}
		n--;
		System.out.println(Math.min(dp[R][n], Math.min(dp[G][n], dp[B][n])));
	}

}
