import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Boj1912 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] dp = new int [n+1];
		for(int i=1; i<=n; i++) {
			int num = Integer.parseInt(st.nextToken());
			dp[i] = Math.max(dp[i-1]+num, num);
		}
		int max =-1001;
		for(int i=1; i<=n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
