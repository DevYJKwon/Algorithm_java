import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1197 {
	static class Edge implements Comparable<Edge>{
		int from,to,w;

		public Edge(int from,int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	static int v,e;
	static Edge [] list;
	static int [] parents;
	static void makeSet() {
		for(int i=1; i<=v; i++) {
			parents[i]=i;
		}
	}
	static int find(int a) {
		if(parents[a]==a) {
			return a;
		}
		return parents[a]=find(parents[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			return false;
		}
		parents[bRoot]=aRoot;
		return true;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		parents = new int [v+1];
		for(int i=0; i<e; i++) {
			st= new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to =Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.add(new Edge(from,to,weight));
		}
		makeSet();
		int res=0, cnt=0;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(union(cur.from,cur.to)) {
				res+=cur.w;
				if(++cnt == v-1) {
					break;
				}
			}
		}
		System.out.println(res);
	}
}
