import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2225 {
    static final int MOD =1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [][] dp = new int [n+1][k+1];
        for(int i=1; i<=k; i++){
            dp[0][i]=1;
        }

        for(int y=1; y<=n; y++){
            for(int x=1; x<=k; x++){
                dp[y][x]=dp[y-1][x]+dp[y][x-1];
                dp[y][x] %= MOD;
            }
        }

        System.out.println(dp[n][k]);
    }
}
