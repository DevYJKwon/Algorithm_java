import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14567 {
	static class Node{
		int data;
		Node next;
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	static Node [] list;
	static int indegree[], res[];
	static int n,m;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n  = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new Node [n+1];
		indegree = new int[n+1];
		res = new int [n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from] = new Node(to,list[from]);
			indegree[to]++;
		}
		Arrays.fill(res, 1);
		topologySort();
		for(int i=1; i<=n; i++) {
			sb.append(res[i]+" ");
		}
		System.out.println(sb);
	}
	static void topologySort() {
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=1; i<=n; i++) {
			if(indegree[i]==0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(Node next = list[cur]; next != null; next = next.next) {
				indegree[next.data]--;
				if(indegree[next.data]==0) {
					res[next.data]=res[cur]+1;
					q.add(next.data);
				}
			}
		}
	}

}
