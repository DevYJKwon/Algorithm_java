import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14938 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 정점의 개수
		int range = Integer.parseInt(st.nextToken()); // 수색 범위
		int m = Integer.parseInt(st.nextToken()); // 간선의 개수

		int[] v = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}

		int[][] map = new int[n + 1][n + 1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			map[from][to] = cost;
			map[to][from] = cost;
		}
		
		for(int i = 1; i<=n; i++){
		    for(int j =1; j<=n; j++){
		        if(i!=j && map[i][j]==0) {
		        	map[i][j]= 1000000;
		        }
		    }
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		int max=0;
		for(int i=1; i<=n; i++) {
			int sum=0;
			for(int j=1; j<=n; j++) {
				if(map[i][j] <= range) {
					sum+= v[j];
				}
			}
			max = Math.max(sum, max);
		}
		System.out.println(max);
	}

}
