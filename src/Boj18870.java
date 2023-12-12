import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj18870 {
	static class Node implements Comparable<Node>{
		int v,i;

		public Node(int v, int i) {
			this.v = v;
			this.i = i;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.v, o.v);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int [] arr = new int [n];
		for(int i=0; i<n; i++) {
			int num= Integer.parseInt(st.nextToken());
			pq.add(new Node(num,i));
		}
		int idx=0;
		while(!pq.isEmpty()) {
			Node cur= pq.poll();
			arr[cur.i] = idx;
			
			if(!pq.isEmpty() && pq.peek().v != cur.v) {
				idx++;
			}
		}
		
		for(int i=0; i<n; i++) {
			sb.append(arr[i]).append(" ");
		}
		
		System.out.println(sb);
	}

}
