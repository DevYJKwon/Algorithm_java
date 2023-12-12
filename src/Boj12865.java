import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12865 {
	/*
	 * N개의 물건 , 각 물건은 무게 W와 가치V를 가진다.
	 * 최대 K무게까지 가방에 넣을 수 있다
	 * 가치 최댓값 구하기
	 * 1<=N<=100, 1<=K,W<=100000, 0<=V<=1000
	 * 2초 512MB
	 */

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int [][] dp = new int [n+1][k+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			for(int j=1; j<=k; j++) {
				if(weight > j) {
					dp[i][j]=dp[i-1][j];
				}
				else {
					dp[i][j]=Math.max(value+dp[i-1][j-weight], dp[i-1][j]);
				}
			}
		}
		System.out.println(dp[n][k]);
	}

}
