import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj13549 {
	static final int max = 100000;
	static class Node{
		int pos;
		int time;
		public Node(int pos, int time) {
			super();
			this.pos = pos;
			this.time = time;
		}
		
	}
	
	// x-1, x+1, x*2 (0sec)
	static int bfs(int start, int goal) {
		Queue<Node> q = new ArrayDeque<>();
		boolean visited [] = new boolean [max+1];
		q.add(new Node(start,0));
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.pos == goal) {
				return cur.time;
			}
			if(visited[cur.pos]) {
				continue;
			}
			
			if(cur.pos != 0 && cur.pos <= max/2) {
				q.add(new Node(cur.pos*2,cur.time));
				visited[cur.pos]=true;
			}
			if(cur.pos > 0) {
				q.add(new Node(cur.pos-1,cur.time+1));
				visited[cur.pos]=true;
				
			}
			if(cur.pos < max) {
				q.add(new Node(cur.pos+1,cur.time+1));
				visited[cur.pos]=true;
			}
			
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(start,goal));
		
	}

}
