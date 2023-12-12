import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1916 {
	static final int INF = Integer.MAX_VALUE;
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
	
	static int dijkstra(int start, int dest) {
		int [] d = new int [n+1];
		Arrays.fill(d, INF);
		boolean [] visited = new boolean [n+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		d[start]=0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			visited[cur.i]=true;
			if(d[cur.i] < cur.weight) { //현재 경로가 최단인지 확인, d보다 크다면 다른 곳을 경유해서 온 것이기 때문에 탐색할 필요가 없음.
				continue;
			}
			for(Node next : graph.get(cur.i)) {
				if(!visited[next.i] && d[next.i] > cur.weight+next.weight) {
					d[next.i] = cur.weight+next.weight;
					pq.add(new Node(next.i,cur.weight+next.weight));
				}
			}
		}
		return d[dest];
	}
	static int n,m;
	static ArrayList<ArrayList<Node>> graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine()); // 도시의 수
		m = Integer.parseInt(br.readLine()); // 버스의 수
		graph = new ArrayList<>();
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<m; i++) {
			st= new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph.get(from).add(new Node(to,weight));
		}
		st= new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());
		System.out.println(dijkstra(start,dest));
	}

}
