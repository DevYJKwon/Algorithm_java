import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj11003 {
/* 	       
 *     입력을 받는다.
	       리스트의 크기가 l보다 크다면? 맨 앞 요소를 버린다
	       요소 중 가장 작은 값을 출력*/
	
	static class Node{
		int v,i;

		public Node(int v, int i) {
			super();
			this.v = v;
			this.i = i;
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		Deque <Node> dq = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(!dq.isEmpty() && dq.peekLast().v > num) {
				dq.removeLast();
			}
			dq.add(new Node(num,i));
			if(dq.peek().i < i-l+1) {
				dq.removeFirst();
			}
			sb.append(dq.peek().v).append(" ");
		}
		System.out.println(sb);
	}

}
