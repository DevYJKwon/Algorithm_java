import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1005 {
	/*
	 * 위상정렬하고 같은 차수의 노드를 꺼낼 때 가장 시간이 많이 걸리는 것으로 더하기
	 */
	static class Node{
		int i;
		Node next;
		
		public Node(int i, Node next) {
			this.i = i;
			this.next = next;
		}
		
	}

	public static int topologySort(int [] indegree, int [] time) {
		int [] d = new int [indegree.length];
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=1; i<indegree.length; i++) {
			d[i]=time[i];
			if(indegree[i]==0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == goal) {
				return d[goal];
			}
			for(Node next = graph[cur]; next != null; next= next.next) {
				d[next.i] = Math.max(d[next.i], d[cur]+time[next.i]);
				indegree[next.i]--;
				if(indegree[next.i]==0) {
					q.add(next.i);
				}
			}
		}
		return d[goal];
	}

	static Node [] graph;
	static int [] turn;
	static List<List<Integer>> list = new ArrayList<>();
	static int goal;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			turn = new int [n+1];
			graph = new Node [n+1];
			for(int i=0; i<n; i++) {
				list.add(new ArrayList<Integer>());
			}
			int [] indegree = new int [n+1];
			int [] time = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				time[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				indegree[to]++;
				graph[from]= new Node(to,graph[from]);
			}
			goal = Integer.parseInt(br.readLine());
			sb.append(topologySort(indegree, time)).append("\n");
			
		}
		System.out.println(sb);
	}

}
