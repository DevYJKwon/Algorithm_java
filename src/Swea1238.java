import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea1238 {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<Integer> [] list;
	
	static int bfs(int start) {
		int max=1;
		int [] visited = new int [101];
		Queue <Integer> q = new ArrayDeque<>();
		q.add(start);
		visited[start]=1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(visited[cur] == visited[max]) {
				max= Math.max(max, cur);
			}
			else if(visited[cur] > visited[max]) {
				max = cur;
			}
			
			for(int i : list[cur]) {
				if(visited[i]==0) {
					visited[i]=visited[cur]+1;
					q.add(i);
				}
			}
		}
		
		return max;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		for(int testCase=1; testCase<=10; testCase++) {
			
			list = new List[101];
			for(int i=1; i<=100; i++) {
				list[i]= new ArrayList<Integer>();
			}
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if(list[from].contains(to)) {
					continue;
				}
				list[from].add(to);
			}
			
			sb.append(String.format("#%d %d\n", testCase,bfs(start)));
		}
		System.out.println(sb);
	}

}
