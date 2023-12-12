import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Boj2252 {
	static class LinkNode{
		int i;
		LinkNode next;
		public LinkNode(int i, LinkNode next) {
			this.i = i;
			this.next = next;
		}
	}
	static StringBuilder sb = new StringBuilder();
	static LinkNode [] graph;
	static int n,m;
	static int [] degree;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n =Integer.parseInt(st.nextToken());
		m =Integer.parseInt(st.nextToken());
		graph = new LinkNode [n+1];
		degree = new int [n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from]= new LinkNode(to,graph[from]);
			degree[to]++;
		}
		
		topologySort(degree);
		System.out.println(sb);
	}
	
	static void topologySort(int [] degree) {
		Queue<Integer> q = new ArrayDeque<>();
		for(int v=1; v<degree.length; v++) {
			if(degree[v]==0) {
				q.offer(v);
			}
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur+" ");
			
			for(LinkNode next = graph[cur]; next!=null; next = next.next) {
				degree[next.i]--;
				if(degree[next.i]==0) {
					q.add(next.i);
				}
			}
		}
	}

}
