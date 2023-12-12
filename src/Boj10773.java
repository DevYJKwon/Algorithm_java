import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj10773 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 0; i < k; i++) {
			int money = Integer.parseInt(br.readLine());
			if (money == 0) {
				stack.pop();
			} else {
				stack.add(money);
			}
		}

		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}

}
