import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj10866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Integer> q = new ArrayDeque<Integer>();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String action = st.nextToken();
			int t;
			switch(action) {
			
			case "push_front":
				t = Integer.parseInt(st.nextToken());
				q.addFirst(t);
				break;
			case "push_back":
				t = Integer.parseInt(st.nextToken());
				q.addLast(t);
				break;
			case "pop_front":
				if(q.size()==0) {
					sb.append("-1\n");
				}
				else {
					sb.append(q.removeFirst()+"\n");
				}
				break;
			case "pop_back":
				if(q.size()==0) {
					sb.append("-1\n");
				}
				else {
					sb.append(q.removeLast()+"\n");
				}
				break;
			case "size":
				sb.append(q.size()+"\n");
				break;
			case "empty":
				if(q.isEmpty()) {
					sb.append("1\n");
				}
				else {
					sb.append("0\n");
				}
				break;
			case "front":
				if(q.isEmpty()) {
					sb.append("-1\n");
				}
				else {
					sb.append(q.peekFirst()+"\n");
				}
				break;
			case "back":
				if(q.isEmpty()) {
					sb.append("-1\n");
				}
				else {
					sb.append(q.peekLast()+"\n");
				}
				break;
			}
		}
		System.out.println(sb);
	}

}
