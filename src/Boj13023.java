import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj13023 {
	
	/*	
	 *  A는 B와 친구다.
		B는 C와 친구다.
		C는 D와 친구다.
		D는 E와 친구다.
		친구는 일방적인 관계가 아니라 양방향 관계다. 즉 양방향 그래프.
		5명이 연속적으로 친구인 경우를 찾는다. -> dfs를 통해 깊이가 5만큼 들어가지는지 체크
		
	*/
	static class Node{
		int data;
		Node next;
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m,res;
	static Node [] graph;
	static boolean [] visited;
	
	
	static void dfs(int start,int depth) {
		if(depth ==5 ) { // 깊이가 5까지 들어가면 더이상 탐색할 필요가 없음, 이미 방문한 노드도 마찬가지
				res=1;
			return;
		}
		if(visited[start]) {
			return;
		}
		visited[start]=true;
		for(Node next=graph[start]; next !=null; next=next.next) {
			if(!visited[next.data]) {
				dfs(next.data,depth+1);
				visited[next.data]=false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new Node [n];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[to] = new Node(from,graph[to]);
			graph[from] = new Node(to,graph[from]);
		}
		
		for(int i=0; i<n; i++) {
			visited = new boolean [n];
			dfs(i,1);
			if(res == 1) { // 결과가 나왔으면 더이상 체크할 필요가 없기 때문에 가지치기
				break;
			}
		}
		
		System.out.println(res);
	}

}
