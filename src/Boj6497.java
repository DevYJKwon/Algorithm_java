import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj6497 {

	static class Edge implements Comparable<Edge>{
		int from,to,weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight,o.weight);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int [] parents;
	static int m,n;
	static Edge [] list;
	static StringBuilder sb = new StringBuilder();
	static void makeSet() {
		for(int i=0; i<m; i++) {
			parents[i]=i;
		}
	}
	
	static int find(int a) {
		if(parents[a]==a) {
			return a;
		}
		
		return parents[a]=find(parents[a]);
	}
	
	static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			return false;
		}
		parents[bRoot]=aRoot;
		return true;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		while(true) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken()); // 집의 수
			n = Integer.parseInt(st.nextToken()); // 길의 수
			if(m==0 && n==0) {
				break;
			}
			parents = new int [m];
			list = new Edge [n];
			int max =0;
			for(int i=0; i<n;i++) {
				st= new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				list[i]=new Edge(from,to,weight);
				max+=weight;
			}
			Arrays.sort(list);
			makeSet();
			int result =0; 
			int count=0;
			for(Edge edge:list) {
				if(union(edge.from,edge.to)) {
					result += edge.weight;
					if(++count == m-1) {
						break;
					}
				}
			}
			sb.append(max-result).append("\n");
		}
		System.out.println(sb);
	}

}
