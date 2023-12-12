import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11404 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int v = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		long[][] graph = new long[v + 1][v + 1];
		final long INF =Integer.MAX_VALUE;
		for(int i=1; i<=v; i++) {
			Arrays.fill(graph[i], INF);
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long cost = Integer.parseInt(st.nextToken());
			graph[from][to] = Math.min(graph[from][to],cost);
		}
		
		for(int i=1; i<=v; i++) {
			for(int j=1; j<=v; j++) {
				if(i==j) {
					graph[i][j]=0;
				}
			}
		}
		
		for (int mid = 1; mid <= v; mid++) {
			for (int from = 1; from <= v; from++) {
				for (int to = 1; to <= v; to++) {
					graph[from][to]= Math.min(graph[from][mid]+graph[mid][to],graph[from][to]);
				}
			}
		}
		for (int from = 1; from <= v; from++) {
			for (int to = 1; to <= v; to++) {
				if(graph[from][to]==INF) {
					graph[from][to]=0;
				}
				sb.append(graph[from][to]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
