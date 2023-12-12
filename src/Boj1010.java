import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1010 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int [][] dp = new int [31][31];
		for(int i=0; i<=30; i++) {
			for(int j=0, end = Math.min(i, 30); j <=end; j++) {
				if(j==0 || i==j) {
					dp[i][j]=1;
					continue;
				}
				dp[i][j] = dp[i-1][j-1] +dp[i-1][j];
			}
		}
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			sb.append(dp[n][r]).append("\n");
		}
		System.out.println(sb);
		
	}

}
