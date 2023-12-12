import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16928 {
	static class Node{
		int i,d;

		public Node(int i, int d) {
			this.i = i;
			this.d = d;
		}
		
	}
	static int [] map;
	static int n,m,res;
	
	static void bfs() {
		boolean [] visited = new boolean [101];
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(1,0));
		while(!q.isEmpty()) {
			Node cur = q.poll();
			visited[cur.i] = true;
			for(int i=1; i<=6; i++) {
				int next = i+cur.i;
				if(next <= 100 && !visited[next]) {
					if(next==100) {
						res = cur.d+1;
						return;
					}
					if(map[next]==0) {
						q.add(new Node(next,cur.d+1));
					}
					else {
						q.add(new Node(map[next],cur.d+1));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		map = new int [101];
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			map[s]=e;
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			map[s]=e;
		}
		bfs();
		System.out.println(res);
	}

}
