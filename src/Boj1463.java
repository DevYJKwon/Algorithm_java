import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1463 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		
		int [] dp = new int [1000001];
		
		dp[1]=0;
		dp[2]=1;
		dp[3]=1;
		
		for(int i=4; i<=n; i++) {
			if(i%3 == 0) {
				if(i%2==0) {
					dp[i] = Math.min(Math.min(dp[i/3]+1, dp[i/2]+1),dp[i-1]+1);
				}
				else {
					dp[i] = Math.min(dp[i/3]+1, dp[i-1]+1);
				}
			}
			else if(i%2==0) {
				dp[i] = Math.min(dp[i-1]+1, dp[i/2]+1);
			}
			else {
				dp[i] = dp[i-1]+1;
			}
		}
		System.out.println(dp[n]);
	}

}
