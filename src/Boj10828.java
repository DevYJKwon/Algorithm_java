import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj10828 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String action = st.nextToken();
			if(action.equals("push")) {
				int t = Integer.parseInt(st.nextToken());
				stack.add(t);
			}
			else if(action.equals("top")) {
				if(stack.size() ==0) {
					sb.append("-1\n");
				}
				else {
					sb.append(stack.peek()+"\n");
				}
			}
			else if(action.equals("pop")) {
				if(stack.size() ==0) {
					sb.append("-1\n");
				}
				else {
					sb.append(stack.pop()+"\n");
				}
			}
			else if(action.equals("size")) {
				sb.append(stack.size()+"\n");
			}
			else { //empty
				if(stack.isEmpty()) {
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
