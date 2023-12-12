import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11727 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] dp = new int [n+1];
		dp[1]=1;
		if(n>1) {
			dp[2]=3;
			for(int i =3; i <=n; i++) {
				if(i%2==0) {
					dp[i]= (dp[i-1]*2+1)%10007;
				}
				else {
					dp[i]= (dp[i-1]*2-1)%10007;
				}
			}
		}
		System.out.println(dp[n]);
	}

}
