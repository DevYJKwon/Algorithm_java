import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10971 {
	static int [][] graph;
	static int n,min=Integer.MAX_VALUE;
	static void dfs(int from,int start, int nth,int sum,boolean [] visited) {
		if(nth == n) {
			if(from == start) {
				min = Math.min(sum, min);
			}
			return;
		}
		for(int to=0; to < n; to++) {
			if(graph[from][to] > 0 && !visited[to]) {
				visited[to]=true;
				dfs(to,start,nth+1,sum+graph[from][to],visited);
				visited[to]=false;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		graph = new int [n][n];
		for(int from=0; from<n;from++) {
			st = new StringTokenizer(br.readLine());
			for(int to=0; to<n;to++) {
				graph[from][to]=Integer.parseInt(st.nextToken());
			}
		}
			dfs(0,0,0,0,new boolean[n]);
		System.out.println(min);
	}

}
