import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class swea1218 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			Deque<Character> q = new ArrayDeque<>();
			String str = br.readLine();
			boolean flag = true;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				switch (c) {
				case '{':
				case '[':
				case '(':
				case '<':
					q.addLast(c);
					break;
				case '}':
					if (q.isEmpty()) {
						flag = false;
						break;
					} else {
						if (q.remove('{')) {
							break;
						} else {
							flag = false;
						}
						break;
					}
				case ']':
					if (q.isEmpty()) {
						flag = false;
						break;
					} else {
						if (q.remove('[')) {
							break;
						} else {
							flag = false;
						}
						break;
					}
				case ')':
					if (q.isEmpty()) {
						flag = false;
						break;
					} else {
						if (q.remove('(')) {
							break;
						} else {
							flag = false;
						}
						break;
					}
				case '>':
					if (q.isEmpty()) {
						flag = false;
						break;
					} else {
						if (q.remove('<')) {
							break;
						} else {
							flag = false;
						}
						break;
					}
				}

				if (!flag) {
					break;
				}
			}
			int res = 0;
			if (q.isEmpty() && flag) {
				res = 1;
			} else {
				res = 0;
			}
			sb.append(String.format("#%d %d\n", t, res));
		}
		System.out.println(sb);
	}

}
