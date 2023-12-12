import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj10845 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Integer> q = new ArrayDeque<Integer>();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String action = st.nextToken();
			if(action.equals("push")) {
				int t = Integer.parseInt(st.nextToken());
				q.addFirst(t);
			}
			else if(action.equals("front")) {
				if(q.size() ==0) {
					sb.append("-1\n");
				}
				else {
					sb.append(q.peekLast()+"\n");
				}
			}
			else if(action.equals("back")) {
				if(q.size() ==0) {
					sb.append("-1\n");
				}
				else {
					sb.append(q.peek()+"\n");
				}
			}
			else if(action.equals("pop")) {
				if(q.size() ==0) {
					sb.append("-1\n");
				}
				else {
					sb.append(q.removeLast()+"\n");
				}
			}
			else if(action.equals("size")) {
				sb.append(q.size()+"\n");
			}
			else { //empty
				if(q.isEmpty()) {
					sb.append("1\n");
				}
				else {
					sb.append("0\n");
				}
			}
		}
		System.out.println(sb);
	}

}
