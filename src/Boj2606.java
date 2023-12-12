import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2606 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		boolean[][] graph = new boolean[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from][to] = true;
			graph[to][from] = true;
			graph[from][from] = true;
			graph[to][to] = true;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if (graph[j][i] && graph[i][k]) {
						graph[j][k]=true;
					}
				}
			}
		}
		int cnt = 0;
		for (int i = 2; i <= n; i++) {
			if (graph[1][i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
