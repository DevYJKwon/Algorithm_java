import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2294 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		int [] coin = new int [n];
		for(int i=0; i<n; i++) {
			coin[i]=Integer.parseInt(br.readLine());
		}
		int [] dp = new int [money+1];
		Arrays.fill(dp, 1234567890);
		dp[0]=0;
		for(int i=1; i<=money; i++) {
			for(int c=0; c<n; c++) {
				if(i-coin[c] >=0) {
					dp[i]= Math.min(dp[i-coin[c]]+1, dp[i]);
				}
			}
		}
		if(dp[money]==1234567890) {
			dp[money]=-1;
		}
		System.out.println(dp[money]);
	}

}
