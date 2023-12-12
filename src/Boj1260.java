import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Boj1260 {
	static StringBuilder sb = new StringBuilder();
	static boolean [] visited;
	static int [][] graph;
	
	static void dfs(int start) {
		visited[start]=true;
		sb.append(start+" ");
		for(int i=0; i<graph.length; i++) {
			if(graph[start][i]!=0 && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int start) {
		visited = new boolean [graph.length];
		visited[start]=true;
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur+" ");
			for(int i=0; i<graph.length; i++) {
				if(graph[cur][i]!=0 && !visited[i]) {
					q.add(i);
					visited[i]=true;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		graph = new int [v+1][v+1];
		visited= new boolean [v+1];
		for(int i=0; i<e; i++) {
			st= new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from][to]=1;
			graph[to][from]=1;
		}
		
		dfs(start);
		sb.append("\n");
		bfs(start);
		sb.append("\n");
		System.out.println(sb);
	}

}
