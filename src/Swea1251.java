import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea1251 {
	
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
	static class Island {
		int i,x,y;

		public Island(int i, int x, int y) {
			this.i = i;
			this.x = x;
			this.y = y;
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
		int testCase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testCase; t++) {
			n = Integer.parseInt(br.readLine());
			Island [] islands = new Island [n];
			List<Edge> list = new ArrayList<>();
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int x= Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				islands[i] = new Island(i, x, y);
			}
			double e = Double.parseDouble(br.readLine());
			
			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					int w = Math.abs(islands[i].x - islands[j].x) + Math.abs(islands[i].y-islands[j].y);
					list.add(new Edge(i,j,w));
				}
			}
			makeSet();
			long res=0;
			int cnt=0;
			for(Edge edge : list) {
				if(union(edge.from,edge.to)) {
					res+=(double)Math.pow(edge.weight, 2)*e;
					if(++cnt == n-1) {
						break;
					}
				}
			}
			
			System.out.println(res);
		}
	}

}
