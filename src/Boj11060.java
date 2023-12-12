import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11060 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int [] dp = new int [n+1];
		final int NONE = 100000;
		Arrays.fill(dp, NONE);
		dp[1]=0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			int j = Integer.parseInt(st.nextToken());
			for(int x=1; x<=j; x++) {
				if(x+i > n) {
					break;
				}
				dp[x+i] = Math.min(dp[i]+1,dp[x+i]);
			}
		}
		if(dp[n]==NONE) {
			dp[n]=-1;
		}
		System.out.println(dp[n]);
	}

}
