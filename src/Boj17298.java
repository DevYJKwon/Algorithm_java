import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj17298 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Integer> next = new Stack<>();
		Stack<Integer> prev = new Stack<>();
		Stack<Integer> res = new Stack<>();
		
		for(int i=0; i<n; i++) {
			next.push(Integer.parseInt(st.nextToken()));
		}
		while(!next.isEmpty()) {
			int num = next.pop();
			
			while(!prev.isEmpty()&& prev.peek() <= num) {
				prev.pop();
			}
			
			if(prev.isEmpty()) {
				res.push(-1);
			}else {
				res.push(prev.peek());
			}
			prev.add(num);
			
		}
		while(!res.isEmpty()) {
			sb.append(res.pop()).append(" ");
		}
		System.out.println(sb);
	}

}
