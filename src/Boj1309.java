import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long [][] dp = new long [n+1][3];
        dp[1][0]=1; // 놓지 않음
        dp[1][1]=1; // 왼쪽에 놓음
        dp[1][2]=1; // 오른쪽에 놓음

        for(int i=2; i<=n; i++){
            dp[i][0] = dp[i-1][0]%9901+dp[i-1][1]%9901+dp[i-1][2]%9901;
            dp[i][1] = dp[i-1][0]%9901+dp[i-1][2]%9901;
            dp[i][2] = dp[i-1][0]%9901+dp[i-1][1]%9901;
        }
        System.out.println((dp[n][0]+dp[n][1]+dp[n][2])%9901);
    }
}
