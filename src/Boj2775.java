import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2775 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//a층의 b호에 살려면 a-1층의 1호부터 b호까지 사람들의 수의 한만큼 사람이 있어야한다.
		// k층 n호에 몇 명이 살고 있는지? 0층부터 1호부터 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int [][] dp = new int [15][15];
		for(int i =1; i<15; i++) {
			dp[0][i]=i;
		}
		
		for(int f=1; f<15; f++) {
			for(int h=1; h<15; h++) {
				int sum=0;
				for(int i=1; i<=h; i++) {
					sum+=dp[f-1][i];
				}
				dp[f][h]=sum;
			}
		}

		for(int t=0; t<testCase; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[k][n]).append("\n");
		}
		System.out.println(sb);
	}

}
