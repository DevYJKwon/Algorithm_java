import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Boj4949 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Character> stack;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			if(str.charAt(0)=='.') {
				break;
			}
			stack = new ArrayDeque();
			String res = "yes";
			outer:for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				switch(c) {
				case '(':
				case '[':
					stack.push(c);
					break;
				case ')':
					if(stack.isEmpty()) {
						res = "no";
						break outer;
					}
					
					if(stack.peek() == '(') {
						stack.pop();
						break;
					}
					else {
						res = "no";
						break outer;
					}
				case ']':
					if(stack.isEmpty()) {
						res = "no";
						break outer;
					}
					
					if(stack.peek() == '[') {
						stack.pop();
						break;
					}
					else {
						res = "no";
						break outer;
					}
				default:
					break;
				}
				
			}
			if(!stack.isEmpty()) {				
				res = "no"; 
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
		
		
	}

}
