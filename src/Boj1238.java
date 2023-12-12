import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int idx;
	int dis;
	public Node(int idx, int dis) {
		this.idx = idx;
		this.dis = dis;
	}
	
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.dis, o.dis);
	}
}

public class Boj1238 {
	static final int INF = 1000000;
	static List<Node> [] list;
	static int n,m;
	static int dijkstra(int start, int end) {
		int [] d = new int[n+1];
		Arrays.fill(d, INF);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		d[start]=0;
		
		while(!pq.isEmpty()) {
			int curIdx = pq.peek().idx;
			int curDis = pq.peek().dis;
			pq.poll();
			
			if(curDis > d[curIdx]) {
				continue;
			}
			
			for(Node node : list[curIdx]) {
				int nextIdx = node.idx;
				int nextCost = node.dis + curDis;
				if(d[nextIdx] > nextCost) {
					d[nextIdx]=nextCost;
					pq.add(new Node(nextIdx,nextCost));
				}
			}
		}
		return d[end];
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from =Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to,cost));
		}
		long max =0;
		for(int i=1; i<=n; i++) {
			long tmp = dijkstra(i, x)+dijkstra(x, i);
			if(tmp >= INF) {
				continue;
			}
			max = Math.max(max, tmp);
		}
		System.out.println(max);
	}

}