import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2098 {
	
	
private static int dfs(int cur, int visited) {
		
		if(visited == (1 << n) - 1) {	
			if(graph[cur][0] == 0) {	
				return INF;
			}
			
			return graph[cur][0];	
		}
		
		if(dp[cur][visited] != -1) {	
			return dp[cur][visited];
		}
		dp[cur][visited]=INF;
		
		for(int i = 0; i < n; i++) {	
			if((visited & (1 << i)) == 0 && graph[cur][i] != 0) {	

				dp[cur][visited] = Math.min(dp[cur][visited], dfs(i, visited | (1 << i)) + graph[cur][i]);	
			}
		}
		
		return dp[cur][visited];
	}
	
	static final int INF=987654321;
	static int n;
	static int [][] graph;
	static int [][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		graph = new int [n][n];
		dp = new int [n][(1<<n)-1];
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int cost = Integer.parseInt(st.nextToken());
				graph[i][j]=cost;
			}
		}
		for(int i=0; i<n; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(dfs(0,1));
		
	}

}
