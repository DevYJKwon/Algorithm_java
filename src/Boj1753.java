import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1753 {

	static class Node implements Comparable<Node>{
		int i,weight;
		public Node(int i, int weight) {
			this.i = i;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	static List<Node> []list;
	static int e,v;
	static final int INF = 300001;
	static int [] d;
	
	static void dijkstra(int start) {
		d = new int [v+1];
		boolean [] visited = new boolean [v+1];
		Arrays.fill(d, INF);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.i]) {
				continue;
			}
			visited[cur.i]=true;
			d[cur.i] = Math.min(d[cur.i], cur.weight);
			for(Node next:list[cur.i]) {
				if(!visited[next.i] && cur.weight+next.weight < d[next.i]) {
					d[next.i] = cur.weight+next.weight;
					pq.add(new Node(next.i,d[next.i]));
				}
			}
			
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		int start= Integer.parseInt(br.readLine());
		list = new List[v+1];
		for(int i=1; i<=v; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to,weight));
		}
		dijkstra(start);
		for(int i=1; i<=v; i++) {
			String res="";
			if(d[i]==INF) {
				res = "INF";
			}
			else {
				res = Integer.toString(d[i]);
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}

}
