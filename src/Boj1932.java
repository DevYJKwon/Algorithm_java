import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1932 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [][] dp = new int [n+1][n+1];
		for(int i=1; i<=n; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j=1; j<=i; j++) {
				int cur = Integer.parseInt(st.nextToken());
				dp[i][j]= Math.max(dp[i-1][j-1], dp[i-1][j])+cur;
			}
		}
		
		int max=0;
		for(int j=1; j<=n; j++) {
			max= Math.max(dp[n][j], max);
		}

		System.out.println(max);
		
	}

}
