import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj2493 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Point> stack = new Stack();
		for(int i=1; i<=n; i++) {
			int t = Integer.parseInt(st.nextToken());
			while(true) {
				if(stack.isEmpty()) {
					sb.append("0 ");
					break;
				}
				if(stack.peek().y < t) {
					stack.pop();
				}
				else {
					sb.append(stack.peek().x).append(" ");
					break;
				}
			}
			stack.add(new Point(i,t));
		}
		System.out.println(sb);
	}

}
