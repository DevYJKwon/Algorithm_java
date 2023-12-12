import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2293 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		int [] coins = new int [n];
		int [] dp = new int [goal+1];
		dp[0]=1;
		for(int i=0; i<n; i++) {
			int c = Integer.parseInt(br.readLine());
			coins[i]=c;
			
			for(int j=coins[i]; j <= goal; j++) {
				dp[j] += dp[j - coins[i]];
			}
		}
		
		System.out.println(dp[goal]);
	}

}
