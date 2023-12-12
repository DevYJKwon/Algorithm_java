import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9095 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int [] dp = new int [12];
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		for(int i=4; i<=11; i++) {
			dp[i]= dp[i-1]+dp[i-2]+dp[i-3];
		}
		
		for(int t=0; t<testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb);
	}

}
