import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Boj16953 {
	static class Node {
		long i;
		long depth;
		public Node(long i, long depth) {
			this.i = i;
			this.depth = depth;
		}
	}
	static long bfs(long start,long goal) {
		Queue<Node>q = new ArrayDeque<>();
		q.add(new Node(start,1));
		long min=-1;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.i==goal) {
				min=cur.depth;
				break;
			}
			if(cur.i*10+1 <= goal) {
				q.add(new Node(cur.i*10+1,cur.depth+1));
			}
			if(cur.i*2 <= goal) {
				q.add(new Node(cur.i*2,cur.depth+1));
			}
		}
		return min;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long start = Integer.parseInt(st.nextToken());
		long goal =Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(start,goal));
	}

}
