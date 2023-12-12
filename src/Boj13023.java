import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj13023 {
	
	/*	
	 *  A�� B�� ģ����.
		B�� C�� ģ����.
		C�� D�� ģ����.
		D�� E�� ģ����.
		ģ���� �Ϲ����� ���谡 �ƴ϶� ����� �����. �� ����� �׷���.
		5���� ���������� ģ���� ��츦 ã�´�. -> dfs�� ���� ���̰� 5��ŭ �������� üũ
		
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
		if(depth ==5 ) { // ���̰� 5���� ���� ���̻� Ž���� �ʿ䰡 ����, �̹� �湮�� ��嵵 ��������
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
			if(res == 1) { // ����� �������� ���̻� üũ�� �ʿ䰡 ���� ������ ����ġ��
				break;
			}
		}
		
		System.out.println(res);
	}

}
