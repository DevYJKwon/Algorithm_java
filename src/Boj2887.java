import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// x y z 으로 각각 정렬해서 3개 중 가장 작은 값
public class Boj2887 {
	static class Planet{
		int i;
		int x;
		int y;
		int z;
		public Planet(int i,int x, int y, int z) {
			this.i = i;
			this.x = x;
			this.y = y;
			this.z = z;
		}

	}
	
	static class Edge implements Comparable<Edge>{
		int from,to,weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	static int parents[];
	static int n;
	static void makeSet() {
		for(int i=0; i<n; i++) {
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
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Planet[] pList = new Planet[n];
		parents = new int [n];

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			pList[i] = new Planet(i,x, y, z);
		}
		Arrays.sort(pList, (o1,o2)->Integer.compare(o1.x, o2.x));
		
		for(int i=0; i<n-1; i++) {
			int p1 = pList[i].i;
			int p2 = pList[i + 1].i;
			int w = Math.abs(pList[i].x - pList[i+1].x);
			pq.add(new Edge(p1,p2,w));
			pq.add(new Edge(p2,p1,w));
		}
		Arrays.sort(pList, (o1,o2)->Integer.compare(o1.y, o2.y));
		
		for(int i=0; i<n-1; i++) {
			int p1 = pList[i].i;
			int p2 = pList[i + 1].i;
			int w = Math.abs(pList[i].y - pList[i+1].y);
			pq.add(new Edge(p1,p2,w));
			pq.add(new Edge(p2,p1,w));
		}
		Arrays.sort(pList, (o1,o2)->Integer.compare(o1.z, o2.z));
		
		for(int i=0; i<n-1; i++) {
			int p1 = pList[i].i;
			int p2 = pList[i + 1].i;
			int w = Math.abs(pList[i].z - pList[i+1].z);
			pq.add(new Edge(p1,p2,w));
			pq.add(new Edge(p2,p1,w));
		}
		
		makeSet();
		int res=0;
		int cnt=0;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(union(e.from,e.to)) {
				res+=e.weight;
				if(++cnt == n-1) {
					break;
				}
			}
		}
		
		System.out.println(res);
	}

}
