import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj11723 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String action = st.nextToken();
			switch (action) {
			case "add":
				set.add(st.nextToken());
				break;
			case "remove":
				set.remove(st.nextToken());
				break;
			case "check":
				sb.append(set.contains(st.nextToken()) ? 1 : 0).append("\n");
				break;
			case "toggle":
				String target = st.nextToken();
				if (set.contains(target)) {
					set.remove(target);
				} else {
					set.add(target);
				}
				break;
			case "all":
				set.clear();
				for (int e = 1; e <= 20; e++) {
					set.add(Integer.toString(e));
				}
				break;
			case "empty":
				set.clear();
				break;
			}
		}
		System.out.println(sb);
	}

}
